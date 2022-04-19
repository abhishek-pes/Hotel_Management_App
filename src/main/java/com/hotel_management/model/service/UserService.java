package com.hotel_management.model.service;

import com.hotel_management.model.User;

public interface UserService {
    void RegisterUser(User user);
    User authenticate(String username , String Password);
}
