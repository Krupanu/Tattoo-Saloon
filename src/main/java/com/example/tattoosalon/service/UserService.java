package com.example.tattoosalon.service;

import com.example.tattoosalon.dto.SignIn;
import com.example.tattoosalon.dto.UserDto;
import com.example.tattoosalon.model.User;

import java.util.List;

public interface UserService {
//    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<User> findAllUsers();

    UserDto CreateUser(UserDto userDto);

    SignIn SignIn(SignIn singIn);
}