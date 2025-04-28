package com.example.tattoosalon.service;

import com.example.tattoosalon.dto.SignIn;
import com.example.tattoosalon.dto.UserDto;
import com.example.tattoosalon.model.User;

import java.util.List;

public interface UserService {

    UserDto CreateUser(UserDto userDto);

    SignIn SignIn(SignIn singIn);
}