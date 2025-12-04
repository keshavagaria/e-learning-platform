package com.labmentix.controller;

import com.labmentix.entities.User;
import com.labmentix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/")
    public String home(){

        return "index";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/home")
    public String home2(){

        return "user-dashboard";
    }

    @GetMapping("/signup")
    public String signUp(Model model){

        model.addAttribute("user",new User());
        return "sign-up";
    }

    @PostMapping("/do_register")
    public String createUser(User user) {
        //System.out.println("Role " + user.getRoles());
        user.setPassword(encoder.encode(user.getPassword()));
        userService.createUser(user);
        return "sign-up";
    }
}
