package com.example.tattoosalon.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ServiceStatus {
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED"),
    DELETED("DELETED");

    private final String value;

    ServiceStatus(final String value) {
        this.value = value;
    }

    @JsonCreator
    public static ServiceStatus fromValue(String value) {
        for (ServiceStatus serviceStatus : ServiceStatus.values()) {
            if (serviceStatus.value.equalsIgnoreCase(value.trim())) {
                return serviceStatus;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

    @Override
    public String toString() {
        return value;
    }
}
