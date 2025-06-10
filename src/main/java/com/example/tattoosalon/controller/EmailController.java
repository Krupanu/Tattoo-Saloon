package com.example.tattoosalon.controller;

import com.example.tattoosalon.dto.EmailDto;
import com.example.tattoosalon.model.EmailDetails;
import com.example.tattoosalon.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailDto request) {
        emailService.sendEmail(request);
        return "Email sent successfully!";
    }
}
