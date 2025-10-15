package com.revature.security.java_security.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/public")
public class GreetingController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello, World! Public Endpoint.";
    }

}
