package com.training.autoVendor.service;

import com.training.autoVendor.model.AutoVendor;

import java.util.List;

public interface AutoVendorService {
    public String createAutoVendor(AutoVendor autoVendor);
    public String updateAutoVendor(AutoVendor autoVendor);
    public String patchAutoVendor(AutoVendor autoVendor);
    public String deleteAutoVendor(Long autoId);
    public AutoVendor getByAutoVendorId(Long autoId);
    public List<AutoVendor> getByautoName(String autoName);
    public List<AutoVendor> getByautoNameAndFuel(String autoName, String fuelName);
    public List<AutoVendor> getAllAutoVendors();
}
