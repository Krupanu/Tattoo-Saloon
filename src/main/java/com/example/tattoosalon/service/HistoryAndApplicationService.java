package com.example.tattoosalon.service;

import com.example.tattoosalon.dto.AppointmentDto;
import com.example.tattoosalon.dto.UserDto;

public interface HistoryAndApplicationService {
    AppointmentDto CreateNewAppointment(AppointmentDto appointmentDto);
    AppointmentDto CancelAppointment(Long id);
}
