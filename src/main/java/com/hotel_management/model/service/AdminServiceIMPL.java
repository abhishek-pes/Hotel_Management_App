package com.hotel_management.model.service;

import com.hotel_management.model.Driver;
import com.hotel_management.model.Room;
import com.hotel_management.model.User;
import com.hotel_management.model.repository.DriverRepository;
import com.hotel_management.model.repository.RoomRepository;
import com.hotel_management.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceIMPL implements AdminService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void SaveDriverList(Driver driver) {
        this.driverRepository.save(driver);
    }

    @Override
    public void SaveRoomList(Room room) {
        this.roomRepository.save(room);
    }
}
