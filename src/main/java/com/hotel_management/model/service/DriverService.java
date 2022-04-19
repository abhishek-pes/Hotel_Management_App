package com.hotel_management.model.service;

import com.hotel_management.model.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> getAllDrivers();
    void SaveDriverList(Driver driver);
    Driver getDriverById(long driverid);
    void DeleteDriver(long driverid);


}
