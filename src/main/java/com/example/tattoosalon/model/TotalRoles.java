package com.example.tattoosalon.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum TotalRoles {
    ADMIN("ADMIN"),
    MASTER("MASTER"),
    CLIENT("CLIENT");

    private final String value;

    TotalRoles(final String value) {
        this.value = value;
    }

    @JsonCreator
    public static TotalRoles fromValue(String value) {
        for (TotalRoles role : TotalRoles.values()) {
            if (role.value.equalsIgnoreCase(value.trim())) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

    @Override
    public String toString() {
        return value;
    }
}