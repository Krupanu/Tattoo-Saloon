package com.example.tattoosalon.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HistoryAndApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "master_id")
    private User master;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    private LocalDateTime appointmentDate;

    @Column(name = "salon_services",nullable = false)
    @Enumerated(EnumType.STRING)
    private TotalSalonServices services;

    @Column(name = "service_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceStatus ServiceStatus;

}

