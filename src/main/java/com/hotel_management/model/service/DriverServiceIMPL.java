package com.hotel_management.model.service;

import com.hotel_management.model.Driver;
import com.hotel_management.model.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceIMPL implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public void SaveDriverList(Driver driver) {
        this.driverRepository.save(driver);
    }

    @Override
    public Driver getDriverById(long driverid) {
        Optional<Driver> optional = driverRepository.findById(driverid);
        Driver driver = null;
        if(optional.isPresent())
        {
            driver = optional.get();
        }
        else{
            throw new RuntimeException("Driver not found for id: "+driverid);
        }
        return driver;
    }

    @Override
    public void DeleteDriver(long driverid) {
        this.driverRepository.deleteById(driverid);
    }
}
