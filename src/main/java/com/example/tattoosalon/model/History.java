package com.example.tattoosalon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String event;

    @Column(nullable = false)
    private bo status;

    @ManyToOne
    @JoinColumn(name = "master_id")
    private User master;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    private LocalDateTime appointmentDate;
}

