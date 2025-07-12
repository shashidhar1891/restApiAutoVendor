package com.training.autoVendor.service;

import com.training.autoVendor.model.AutoVendor;
import com.training.autoVendor.repository.AutoVendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoVendorServiceImpl implements AutoVendorService {

    AutoVendorRepository autoVendorRepository;

    public AutoVendorServiceImpl(AutoVendorRepository autoVendorRepository) {
        this.autoVendorRepository = autoVendorRepository;
    }

    @Override
    public String createAutoVendor(AutoVendor autoVendor) {
        autoVendorRepository.save(autoVendor);
        return "Vendor saved successfully";
    }

    @Override
    public String updateAutoVendor(AutoVendor autoVendor) {
        autoVendorRepository.save(autoVendor);
        return "Vendor updated successfully";
    }

    @Override
    public String patchAutoVendor(AutoVendor autoVendor) {
        Optional<AutoVendor> optionalAuto = autoVendorRepository.findById(autoVendor.getAutoId());
        if (optionalAuto.isPresent()) {
            AutoVendor existingAuto = optionalAuto.get();

            if (autoVendor.getAutoName() != null) {
                existingAuto.setAutoName(autoVendor.getAutoName());
            }
            if (autoVendor.getAutoModel() != null) {
                existingAuto.setAutoModel(autoVendor.getAutoModel());
            }
            if (autoVendor.getAutoFuel() != null) {
                existingAuto.setAutoFuel(autoVendor.getAutoFuel());
            }
              autoVendorRepository.save(existingAuto);
            return "Vendor patched successfully";
        } else {
            return "Vendor ID not found";
        }
    }

    @Override
    public String deleteAutoVendor(Long autoVendorId) {
        autoVendorRepository.deleteById(autoVendorId);
        return "Vendor deleted successfully";
    }

    @Override
    public AutoVendor getByAutoVendorId(Long autoVendorId) {
        if(autoVendorRepository.findById(autoVendorId).isEmpty())
            return null;
        return autoVendorRepository.findById(autoVendorId).get();
    }

    @Override
    public List<AutoVendor> getAllAutoVendors() {
        return autoVendorRepository.findAll();
    }

    @Override
    public List<AutoVendor> getByautoName(String autoName) {
        return autoVendorRepository.findByAutoName(autoName);
    }

    @Override
    public List<AutoVendor> getByautoNameAndFuel(String autoName, String fuelName) {
        return autoVendorRepository.findByAutoNameAndAutoFuel(autoName, fuelName);
    }

}
