package com.example.tattoosalon.controller;


import com.example.tattoosalon.dto.AppointmentDto;
import com.example.tattoosalon.dto.UserDto;
import com.example.tattoosalon.model.HistoryAndApplication;
import com.example.tattoosalon.service.HistoryAndApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryAndAppointmentController {

    @Autowired
    private HistoryAndApplicationService historyAndApplicationService;

    public HistoryAndAppointmentController(HistoryAndApplicationService historyAndApplicationService) {
        this.historyAndApplicationService = historyAndApplicationService;
    }

    @PostMapping("/createNewAppointment")
    public ResponseEntity<String> createNewAppointment(@RequestBody AppointmentDto appointmentDto) {
        AppointmentDto appointment = this.historyAndApplicationService.CreateNewAppointment(appointmentDto);
        return new ResponseEntity<>("Appointment has been created.", HttpStatusCode.valueOf(200));

    }
}