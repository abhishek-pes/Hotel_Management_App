package com.hotel_management.controller;

import com.hotel_management.model.Driver;
import com.hotel_management.model.Room;
import com.hotel_management.model.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/authenticate/allrooms")
    public String allrooms(Model model)
    {
        model.addAttribute("roomlist",roomService.getAllRooms());
        return "all_rooms";
    }


    @GetMapping("/authenticate/roomlist/{username}")
    public String getroomlist(@PathVariable(value = "username") String username, Model model)
    {
        System.out.println("The user checking a room currently is "+username);
        model.addAttribute("username",username);
        model.addAttribute("roomlist",roomService.getAllRooms());
        return "book_room";
    }

    @PostMapping("/saveRoom")
    public String saveRoom(@RequestParam String username, @ModelAttribute("room") Room room, Model model){
        // save blog post details to database
        model.addAttribute("username",username);
        roomService.SaveRoomList(room);
        return "user_home";
    }

    //controller to handle booking of driver
    @GetMapping("/authenticate/bookroom/{username}/{roomid}")
    public  String bookroom(@PathVariable (value = "username") String username ,@PathVariable (value = "roomid") long roomid, Model model){
        System.out.println("The room getting booked is "+ roomid);
        System.out.println("The room getting booked for "+ username);
        Room room = roomService.getRoomById(roomid);
        room.setRoomstatus("booked");
        room.setAssignedto(username);
        model.addAttribute("room",room);
        return "confirm_room";
    }

}
