package com.hotel_management.model.service;


import com.hotel_management.model.Driver;
import com.hotel_management.model.Room;
import com.hotel_management.model.User;

import java.util.List;

public interface AdminService {
    List<User> getAllUser();
    void SaveDriverList(Driver driver);
    void SaveRoomList(Room room);


}
