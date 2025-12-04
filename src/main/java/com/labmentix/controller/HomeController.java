package com.labmentix.controller;

import com.labmentix.entities.User;
import com.labmentix.service.RoleTypeService;
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
    private RoleTypeService roleTypeService;

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



    @GetMapping("/signup")
    public String signUp(Model model){

        model.addAttribute("roles", roleTypeService.getAllRoles());
        model.addAttribute("user",new User());
        return "sign-up";
    }

    @PostMapping("/do_register")
    public String createUser(User user) {
        System.out.println("RoleType " + user.getRoles());
        user.setPassword(encoder.encode(user.getPassword()));
        userService.createUser(user);
        return "sign-up";
    }
}
