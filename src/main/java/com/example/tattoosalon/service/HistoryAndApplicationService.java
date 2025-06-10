package com.example.tattoosalon.service;

import com.example.tattoosalon.dto.AppointmentDto;
import com.example.tattoosalon.dto.UserDto;
import com.example.tattoosalon.model.HistoryAndApplication;

import java.util.List;

public interface HistoryAndApplicationService {
    AppointmentDto CreateNewAppointment(AppointmentDto appointmentDto);

    AppointmentDto CancelAppointment(Long id);

    List<HistoryAndApplication> getSchedule();
}
