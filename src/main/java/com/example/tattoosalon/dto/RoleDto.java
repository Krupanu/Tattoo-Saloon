package com.example.tattoosalon.dto;

import com.example.tattoosalon.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Role value;

    private String title;
}
