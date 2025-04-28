package com.example.tattoosalon.controller;


import com.example.tattoosalon.dto.SignIn;
import com.example.tattoosalon.dto.UserDto;
import com.example.tattoosalon.service.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/singup")
    public ResponseEntity<UserDto> CreateUser(@RequestBody UserDto userDto){

        UserDto userDto1 = this.userService.CreateUser(userDto);

        return new ResponseEntity<>(userDto1, HttpStatusCode.valueOf(200));
    }


    @PostMapping("/singin")
    public ResponseEntity<SignIn> CreateUser(@RequestBody SignIn singIn){

        SignIn singIn1 = this.userService.SingIn(singIn);
        return new ResponseEntity<>(singIn1, HttpStatusCode.valueOf(200));
    }
}
