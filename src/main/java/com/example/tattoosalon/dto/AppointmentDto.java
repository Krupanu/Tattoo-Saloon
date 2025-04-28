package com.example.tattoosalon.dto;

import com.example.tattoosalon.model.ServiceStatus;
import com.example.tattoosalon.model.TotalSalonServices;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Long id;
    @NotEmpty(message = "Enter master id")
    private Long masterId;
    @NotEmpty(message = "Enter client id")
    private Long clientId;
    @NotEmpty
    private LocalDateTime appointmentDate;
    @NotEmpty
    private TotalSalonServices salonServices;
    @NotEmpty
    private ServiceStatus serviceStatus;
}
