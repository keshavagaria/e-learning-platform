package com.labmentix.controller;


import com.labmentix.config.MyUserDetails;
import com.labmentix.entities.User;
import com.labmentix.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;



//    @Autowired
//    private JWTService jwtService;

    @Autowired
    private PasswordEncoder encoder;

//    @Autowired
//    private AuthenticationProvider authenticationProvider;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public String createUser(@RequestBody User user) {
        //System.out.println("RoleType " + user.getRoles());
        user.setPassword(encoder.encode(user.getPassword()));

        userService.createUser(user);
        return "user saved successfully";
    }


//    @GetMapping("/updateUserCourse/{courseId}")
//    public String updateUserCourse(@PathVariable Long courseId,User user) {
//
//       Authentication  authentication =  SecurityContextHolder.getContext().getAuthentication();
//
//        System.out.println("Authentication :"+user);
//        log.info("Authentication :"+authentication.getPrincipal());
//        // courseService.updateUserCourse(courseId);
//        return "hello";
//    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }







//    @PostMapping("/authenticate")
//    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
//        Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//        if (authentication.isAuthenticated()) {
//            return jwtService.generateToken(authRequest.getUsername());
//        } else {
//            throw new UsernameNotFoundException("invalid user request !");
//        }
//    }
}
