package com.example.tattoosalon.controller;

import com.example.tattoosalon.dto.UserDto;
import com.example.tattoosalon.model.User;
import com.example.tattoosalon.service.serviceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminPanelController {
    UserServiceImpl userService;

    public AdminPanelController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllCustomers")
    public List<User> getAllCustomers() {
        return userService.findAllUsers();
    }
}
