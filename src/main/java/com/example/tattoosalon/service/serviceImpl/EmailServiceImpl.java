package com.example.tattoosalon.service.serviceImpl;

import com.example.tattoosalon.dto.AppointmentDto;
import com.example.tattoosalon.dto.EmailDto;
import com.example.tattoosalon.model.HistoryAndApplication;
import com.example.tattoosalon.repository.HistoryAndApplicationRepository;
import com.example.tattoosalon.repository.UserRepository;
import com.example.tattoosalon.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private HistoryAndApplicationRepository historyAndApplicationRepository;

    public void sendEmail(EmailDto request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("testfortatoosaloon@gmail.com");
        message.setTo(request.getRecipient());
        message.setSubject(request.getSubject());
        message.setText(request.getBody());
        mailSender.send(message);
    }

    @Override
    public void sendCancelAppointmentEmail(Long appointmentId) {
        SimpleMailMessage message = new SimpleMailMessage();
        HistoryAndApplication application = historyAndApplicationRepository.getAppointmentById(appointmentId);
        String clientEmail = application.getClient().getEmail();
        message.setFrom("testfortatoosaloon@gmail.com");
        message.setTo(clientEmail);
        LocalDateTime appointmentDate = application.getAppointmentDate();
        message.setSubject("Appointment has been canceled");
        message.setText("Your appointment on " + appointmentDate + " has been canceled.\nIf you want to get more information you can contact us via phone number or see more info in your profile.");
        mailSender.send(message);
    }
}