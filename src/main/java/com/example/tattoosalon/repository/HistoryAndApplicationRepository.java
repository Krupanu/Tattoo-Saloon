package com.example.tattoosalon.repository;

import com.example.tattoosalon.model.HistoryAndApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryAndApplicationRepository extends JpaRepository<HistoryAndApplication, Long> {
    HistoryAndApplication getAppointmentById(Long id);
}
