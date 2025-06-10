package com.example.tattoosalon.controller;

import com.example.tattoosalon.dto.UserDto;
import com.example.tattoosalon.model.HistoryAndApplication;
import com.example.tattoosalon.service.serviceImpl.EmailServiceImpl;
import com.example.tattoosalon.service.serviceImpl.HistoryAndApplicationServiceImpl;
import com.example.tattoosalon.service.serviceImpl.UserServiceImpl;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminPanelController {
    UserServiceImpl userService;
    HistoryAndApplicationServiceImpl historyAndApplicationService;
    EmailServiceImpl emailService;

    public AdminPanelController(UserServiceImpl userService,
                                HistoryAndApplicationServiceImpl historyAndApplicationService, EmailServiceImpl emailService) {
        this.userService = userService;
        this.emailService = emailService;
        this.historyAndApplicationService = historyAndApplicationService;
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getAllMasters")
    public List<UserDto> getAllMasters(){
        return userService.getAllMasters();
    }

    @GetMapping("/getAllClients")
    public List<UserDto> getAllClients(){
        return userService.getAllClients();
    }

    @PostMapping("/cancelAppointment")
    public ResponseEntity<String> cancelAppointment(@RequestBody Long id){
        historyAndApplicationService.CancelAppointment(id);
        emailService.sendCancelAppointmentEmail(id);
        return new ResponseEntity<>("Appointment has been canceled", HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getSchedule")
    public List<HistoryAndApplication> getSchedule(){
        return historyAndApplicationService.getSchedule();

    }
}
