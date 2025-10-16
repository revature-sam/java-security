package com.revature.security.java_security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.revature.security.java_security.model.Users; // Ensure this is the correct package for the Users class
import com.revature.security.java_security.service.UserService;

@RestController
@RequestMapping("/public")
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody Users user) {
        userService.registerUser(user);
    }


}
