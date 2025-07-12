package com.training.autoVendor.repository;

import com.training.autoVendor.model.AutoVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoVendorRepository extends JpaRepository<AutoVendor, Long> {
    List<AutoVendor> findByAutoName(String vendorName);
    List<AutoVendor> findByAutoNameAndAutoFuel(String vendorName, String fuelName);
}
