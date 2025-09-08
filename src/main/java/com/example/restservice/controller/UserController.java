package com.example.restservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.pojo.DTO.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public String add(UserDTO user) {
        // For now, just return a confirmation message with the user's info
        return "User added: " + user.toString();
    }
}

