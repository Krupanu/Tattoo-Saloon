package com.example.tattoosalon.controller;


import com.example.tattoosalon.dto.AppointmentDto;
import com.example.tattoosalon.service.HistoryAndApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HistoryAndAppointmentController {

    @Autowired
    private HistoryAndApplicationService historyAndApplicationService;

    public HistoryAndAppointmentController(HistoryAndApplicationService historyAndApplicationService) {
        this.historyAndApplicationService = historyAndApplicationService;
    }

    @PostMapping("/createNewAppointment")
    public ResponseEntity<String> createNewAppointment(@RequestBody AppointmentDto appointmentDto) {
        try {
        AppointmentDto appointment = this.historyAndApplicationService.CreateNewAppointment(appointmentDto);
        return new ResponseEntity<>("Appointment has been created.", HttpStatusCode.valueOf(200));}
        catch (RuntimeException e) {
            return new ResponseEntity<>("Error creating appointment: " + e.getMessage(), HttpStatusCode.valueOf(400));
        }
    }

    @PostMapping("/cancelAppointment/{appointmentId}")
    public ResponseEntity<String> cancelAppointment(@PathVariable("appointmentId") Long appointmentId) {
        historyAndApplicationService.CancelAppointment(appointmentId);
        return new ResponseEntity<>("appointment has been canceled", HttpStatusCode.valueOf(200));
    }
}