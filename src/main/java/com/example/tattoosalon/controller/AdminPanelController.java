package com.example.tattoosalon.controller;

import com.example.tattoosalon.dto.AppointmentDto;
import com.example.tattoosalon.dto.UserDto;
import com.example.tattoosalon.model.User;
import com.example.tattoosalon.service.serviceImpl.HistoryAndApplicationServiceImpl;
import com.example.tattoosalon.service.serviceImpl.UserServiceImpl;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminPanelController {
    UserServiceImpl userService;
    HistoryAndApplicationServiceImpl historyAndApplicationService;

    public AdminPanelController(UserServiceImpl userService,
                                HistoryAndApplicationServiceImpl historyAndApplicationService) {
        this.userService = userService;
        this.historyAndApplicationService = historyAndApplicationService;
    }

}
