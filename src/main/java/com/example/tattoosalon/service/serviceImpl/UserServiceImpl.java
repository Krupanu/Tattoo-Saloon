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

import java.util.ArrayList;
import java.util.List;

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
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public UserDto CreateUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        List<Role> list= new ArrayList<>();
        list.add(new Role(TotalRoles.CLIENT.name()));
        user.setRole(list);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

//        ContactDetail contactDetail = new ContactDetail();
//        contactDetail.setEmail(user.getEmail());
//        contactDetail.setPhoneNumber(user.getContactDetail().getPhoneNumber());
//        contactDetail.setUser(user);
//        user.setContactDetail(contactDetail);

//        List<History> history = new ArrayList<>();
//        user.setHistory(history);

        this.userRepository.save(user);
        return this.modelMapper.map(user,UserDto.class);
    }

    @Override
    public SignIn SingIn(SignIn singIn) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(singIn.getEmail(),singIn.getPassword()));
        User user=this.userRepository.findByEmail(singIn.getEmail());
        var jwtToken=jwtService.generateToken(user);
        singIn.setJwt(jwtToken);
        return singIn;
    }
}