package com.hotel_management.controller;

import com.hotel_management.model.Driver;
import com.hotel_management.model.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/authenticate/driverlist/{username}")
    public String getdriverlist(@PathVariable(value = "username") String username, Model model)
    {
        System.out.println("The user booking a driver currently is "+username);
        model.addAttribute("username",username);
        model.addAttribute("driverlist",driverService.getAllDrivers());
        return "driver_list";
    }

    @PostMapping("/saveDriver")
    public String saveDriver(@RequestParam String username, @ModelAttribute("driver") Driver driver, Model model){
        // save blog post details to database
        model.addAttribute("username",username);
        driverService.SaveDriverList(driver);
        return "user_home";
    }

    //controller to handle booking of driver
    @GetMapping("/authenticate/bookedriver/{username}/{driverid}")
    public  String bookedriver(@PathVariable (value = "username") String username ,@PathVariable (value = "driverid") long driverid, Model model){
        System.out.println("The driver id getting booked is "+ driverid);
        System.out.println("The driver id getting booked for "+ username);
        Driver driver = driverService.getDriverById(driverid);
        driver.setStatus("booked");
        driver.setAssigedto(username);
        model.addAttribute("driver",driver);
        return "confirm_driver";
    }
}
