package com.hotel_management.model.service;

import com.hotel_management.model.User;
import com.hotel_management.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceIMPL implements  UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void RegisterUser(User user){
        this.userRepository.save(user);
    }

    @Override
    public User authenticate(String username, String Password) {
        return userRepository.findByUsernameAndPassword(username,Password).orElse(null);
    }
}
