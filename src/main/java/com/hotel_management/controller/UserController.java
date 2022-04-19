package com.hotel_management.controller;

import com.hotel_management.model.Admin;
import com.hotel_management.model.User;
import com.hotel_management.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String viewsignin(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "index";
    }

    @GetMapping("/admin")
    public String adminlogin(Model model){
        Admin admin = new Admin();
        model.addAttribute("admin",admin);
        return "admin_login";
    }

    @PostMapping("/admin/authenticate")
    public String admin_authenticate(@ModelAttribute("admin") Admin admin, Model model){
        String pwd = admin.getPassword();
        System.out.println("admin password entered is "+pwd);
        if(pwd.equals("admin"))
        {

            return "admin_dashboard";
        }
        else {
            System.out.println("Error in admin authentication");
            return "redirect:/";
        }
    }

    @PostMapping("/authenticate")
    public String authenticate(@ModelAttribute("user")User user, Model model){
        System.out.println("username: "+user.getUsername());
        System.out.println("password: "+user.getPassword());
        User authenticated = userService.authenticate(user.getUsername(),user.getPassword());
        if(authenticated != null)
        {
            model.addAttribute("username",authenticated.getUsername());
            return "user_home";
        }
        else {
            System.out.println("Error in authentication");
            return "redirect:/";
        }
    }

    @GetMapping("/register")
    public String viewregister(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }

    // to register a user
    @PostMapping("/saveUser")
    public  String saveUser(@ModelAttribute("user")User user){
        userService.RegisterUser(user);
        return "redirect:/";
    }

    //home page for logged in users
    @GetMapping("/home")
    public String viewhome()
    {
        return "user_home";
    }
}
