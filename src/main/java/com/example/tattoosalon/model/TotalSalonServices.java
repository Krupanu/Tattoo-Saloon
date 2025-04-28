package com.example.tattoosalon.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum TotalSalonServices {
    TATTOOING ("TATTOOING"),
    TATTOO_REMOVAL("TATTOO_REMOVAL"),
    TATTOO_AFTERCARE("TATTOO_AFTERCARE"),
    TEMPORARY_TATTOO("TEMPORARY_TATTOO");


        private final String value;

        TotalSalonServices(final String value) {
            this.value = value;
        }

        @JsonCreator
        public static TotalSalonServices fromValue(String value) {
            for (TotalSalonServices salonServices : TotalSalonServices.values()) {
                if (salonServices.value.equalsIgnoreCase(value.trim())) {
                    return salonServices;
                }
            }
            throw new IllegalArgumentException("Unknown value: " + value);
        }

        @Override
        public String toString() {
            return value;
        }
    }
