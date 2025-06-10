package com.example.tattoosalon.service;


import com.example.tattoosalon.dto.AppointmentDto;
import com.example.tattoosalon.dto.EmailDto;
import com.example.tattoosalon.model.EmailDetails;

public interface EmailService {

    void sendEmail(EmailDto request);
    void sendCancelAppointmentEmail(Long id);
}
