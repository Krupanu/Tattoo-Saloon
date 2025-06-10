package com.example.tattoosalon.service.serviceImpl;

import com.example.tattoosalon.config.JwtService;
import com.example.tattoosalon.dto.SignIn;
import com.example.tattoosalon.dto.UserDto;
import com.example.tattoosalon.model.*;
import com.example.tattoosalon.repository.UserRepository;
import com.example.tattoosalon.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto CreateUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        user.setRole(userDto.getRole());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        return this.modelMapper.map(user,UserDto.class);
    }

    @Override
    public SignIn SignIn(SignIn singIn) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(singIn.getEmail(),singIn.getPassword()));
        User user=this.userRepository.findByEmail(singIn.getEmail());
        var jwtToken=jwtService.generateToken(user);
        singIn.setJwt(jwtToken);
        return singIn;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return convertToDtoList(userRepository.findAll());
    }

    public List<UserDto> convertToDtoList(List<User> users) {
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }


    public List<UserDto> convertToDtoListForMaster(List<User> users) {
        return users.stream()
                .filter(user -> user.getRole().equals(Role.MASTER))
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public List<UserDto> convertToDtoListForClient(List<User> users) {
        return users.stream()
                .filter(user -> user.getRole().equals(Role.CLIENT))
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<UserDto> getAllMasters() {
        return convertToDtoListForMaster(userRepository.findAll());
    }

    @Override
    public List<UserDto> getAllClients() {
        return convertToDtoListForClient(userRepository.findAll());
    }
}