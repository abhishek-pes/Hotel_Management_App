package com.hotel_management.controller;

import com.hotel_management.model.Driver;
import com.hotel_management.model.JobPosting;
import com.hotel_management.model.Room;
import com.hotel_management.model.User;
import com.hotel_management.model.service.AdminService;
import com.hotel_management.model.service.DriverService;
import com.hotel_management.model.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private DriverService driverService;

    @GetMapping("/admin/authenticate/getusers")
    public String getUserlist(Model model)
    {
        model.addAttribute("userlist",adminService.getAllUser());
        return "user_list";
    }

    @GetMapping("/admin/authenticate/goback")
    public String back_menu()
    {
        return "admin_dashboard";
    }

    @GetMapping("/admin/authenticate/add_driver")
    public String add_driver(Model model){
        Driver driver = new Driver();
        model.addAttribute("driver",driver);
        return "add_driver";
    }
    // to register a driver
    @PostMapping("/save_driver")
    public String savedriver(@ModelAttribute("driver")Driver driver){
        adminService.SaveDriverList(driver);
        return "redirect:/admin/authenticate/all_drivers_admin";
    }
    //get list of drivers
    @GetMapping("/admin/authenticate/all_drivers_admin")
    public String viewdriver(Model model){
        model.addAttribute("driverlist",driverService.getAllDrivers());
        return "all_drivers_admin";
    }

    @GetMapping("/admin/authenticate/add_room")
    public String add_room(Model model){
        Room room = new Room();
        model.addAttribute("room",room);
        return "add_room";
    }
    // to register a room
    @PostMapping("/save_room")
    public String saveroom(@ModelAttribute("room")Room room){
        System.out.println(room.getRoomid());
        adminService.SaveRoomList(room);
        return "redirect:/admin/authenticate/all_rooms";
    }

    // get list of rooms
    @GetMapping("/admin/authenticate/all_rooms")
    public String viewallrooms(Model model){
        model.addAttribute("listrooms",roomService.getAllRooms());
        return "all_rooms_Admin";
    }

    //update room
    @GetMapping("/admin/authenticate/showroomupdate/{roomid}")
    public  String updateroom(@PathVariable(value = "roomid") long roomid, Model model){
        Room room = roomService.getRoomById(roomid);

        model.addAttribute("room",room);
        return "update_room";
    }

    //delete a room
    @GetMapping("admin/authenticate/deleteroom/{roomid}")
    public String deleteroom(@PathVariable (value = "roomid") long roomid){

        this.roomService.deleteRoom(roomid);

        return "redirect:/admin/authenticate/all_rooms";
    }

    //update driver
    @GetMapping("/admin/authenticate/showdriverupdate/{driverid}")
    public  String updatedriver(@PathVariable(value = "driverid") long driverid, Model model){
        Driver driver = driverService.getDriverById(driverid);

        model.addAttribute("driver",driver);
        return "update_driver";
    }

    //delete a driver
    @GetMapping("admin/authenticate/deletedriver/{driverid}")
    public String deletedriver(@PathVariable (value = "driverid") long driverid){

        this.driverService.DeleteDriver(driverid);

        return "redirect:/admin/authenticate/all_drivers_admin";
    }

}
