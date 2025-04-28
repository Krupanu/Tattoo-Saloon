package com.example.tattoosalon.service.serviceImpl;

import com.example.tattoosalon.dto.AppointmentDto;
import com.example.tattoosalon.model.*;
import com.example.tattoosalon.repository.HistoryAndApplicationRepository;
import com.example.tattoosalon.repository.UserRepository;
import com.example.tattoosalon.service.HistoryAndApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryAndApplicationServiceImpl implements HistoryAndApplicationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    private final HistoryAndApplicationRepository historyAndApplicationRepository;

    public HistoryAndApplicationServiceImpl(HistoryAndApplicationRepository historyAndApplicationRepository) {
        this.historyAndApplicationRepository = historyAndApplicationRepository;
    }


    @Override
    public AppointmentDto CreateNewAppointment(AppointmentDto appointmentDto) {
        try{
        HistoryAndApplication appointment = modelMapper.map(appointmentDto, HistoryAndApplication.class);
        appointment.setMaster(userRepository.getUsersByIdAndRole(appointmentDto.getMasterId(),Role.MASTER));
        if (appointment.getMaster() == null) {
            throw new RuntimeException("Master not found");
        }
        appointment.setClient(userRepository.getUsersByIdAndRole(appointmentDto.getClientId(),Role.CLIENT));
        if (appointment.getClient() == null) {
            throw new RuntimeException("Client not found");
        }
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setServices(appointmentDto.getSalonServices());
        appointment.setServiceStatus(appointmentDto.getServiceStatus());
        historyAndApplicationRepository.save(appointment);
        return modelMapper.map(appointment,AppointmentDto.class);}
        catch (Exception e){
            throw new RuntimeException("Error creating appointment: " + e.getMessage());
        }
    }

    @Override
    public AppointmentDto CancelAppointment(Long id) {
        HistoryAndApplication appointment = historyAndApplicationRepository.getAppointmentById(id);
        appointment.setServiceStatus(ServiceStatus.CANCELLED);
        historyAndApplicationRepository.save(appointment);
        return modelMapper.map(appointment, AppointmentDto.class);
    }


}
