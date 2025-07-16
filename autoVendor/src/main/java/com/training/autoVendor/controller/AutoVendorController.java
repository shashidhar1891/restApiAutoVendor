package com.training.autoVendor.controller;

import com.training.autoVendor.exception.AutoVendorNotFoundException;
import com.training.autoVendor.model.AutoVendor;
import com.training.autoVendor.service.AutoVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auto")
public class AutoVendorController {

    @Autowired
    AutoVendorService autoVendorService;

//    public AutoVendorController(AutoVendorService autoVendorService) {
//        this.autoVendorService = autoVendorService;
//    }

    // Read All Auto Vendor Details from DB
    @GetMapping("/getAutoVendorsList")
    public List<AutoVendor> getAllAutoVendorDetails() {
        return autoVendorService.getAllAutoVendors();
    }

    @GetMapping("/getAutoID/{vendorId}")
    public AutoVendor getAutoVendorById(@PathVariable("vendorId") Long vendorId) {
        return autoVendorService.getByAutoVendorId(vendorId);
    }

    @GetMapping("/getAutoName")
    public List<AutoVendor> getByautoName(@RequestParam (name = "autoName") String autoName) {
        if(autoVendorService.getByautoName(autoName).isEmpty()){
            throw new AutoVendorNotFoundException("Vendor with Auto name : " + autoName + " not found");
        }
        return autoVendorService.getByautoName(autoName);
    }

    @GetMapping("/getAutoNameAndFuel")
    public List<AutoVendor> getByautoNameAndFuel(@RequestParam (name = "autoName") String autoName, @RequestParam (name = "autoFuel") String autoFuel) {
        return autoVendorService.getByautoNameAndFuel(autoName, autoFuel);
    }

    @PostMapping("/createAutoVendor")
    @PreAuthorize("'hasrole ('ADMIN)")
    public String createAutoVendorDetails(@RequestBody AutoVendor autoVendor) {
            autoVendorService.createAutoVendor(autoVendor);
            return "Auto Vendor Created Successfully";
            //return ResponseEntity.status(HttpStatus.CREATED).body(autoVendor);
    }

    @PutMapping("/updateAutoVendor")
    public String updateAutoVendorDetails(@RequestBody AutoVendor autoVendor) {
        if(autoVendor.getAutoId() != null &&
                autoVendorService.getByAutoVendorId(autoVendor.getAutoId()) != null) {
            autoVendorService.updateAutoVendor(autoVendor);
           // return new ResponseEntity<>(autoVendor, HttpStatus.OK);
            return "Vendor details are updated";
        }
        else
            return "Vendor ID not Present:" + autoVendor.getAutoId();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to create vendor");
    }

    @PatchMapping("/patchAutoVendor")
    public String patchAutoVendorDetails(@RequestBody AutoVendor autoVendor) {
        if(autoVendor.getAutoId() != null &&
                autoVendorService.getByAutoVendorId(autoVendor.getAutoId()) != null) {
            autoVendorService.patchAutoVendor(autoVendor);
            return "Auto Vendor patched Successfully";
        }
        else
            return "Auto Vendor Id not present";
    }

    @DeleteMapping("/deleteAutoID/{vendorId}")
    public String deleteAutoVendorDetails(@PathVariable("vendorId") Long vendorId) {
        if(autoVendorService.getByAutoVendorId(vendorId) != null) {
            autoVendorService.deleteAutoVendor(vendorId);
            return "Auto Vendor Deleted Successfully";
        }
        else
            return "Auto Vendor Id not present";
    }
}
