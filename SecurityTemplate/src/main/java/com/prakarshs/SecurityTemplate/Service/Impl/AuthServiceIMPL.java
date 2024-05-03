package com.prakarshs.SecurityTemplate.Service.Impl;

import com.prakarshs.SecurityTemplate.DTO.JWTAuthResponse;
import com.prakarshs.SecurityTemplate.DTO.SignInRequest;
import com.prakarshs.SecurityTemplate.DTO.SignUpRequest;
import com.prakarshs.SecurityTemplate.Entity.UserEntity;
import com.prakarshs.SecurityTemplate.Enums.Role;
import com.prakarshs.SecurityTemplate.Repository.UserRepository;
import com.prakarshs.SecurityTemplate.Service.AuthService;
import com.prakarshs.SecurityTemplate.Service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;
    @Override
    public UserEntity signup(SignUpRequest signUpRequest) {
        UserEntity user = UserEntity.builder()
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .role(Role.USER)
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();

        userRepository.save(user);
        return user;
    }

    @Override
    public JWTAuthResponse signIn(SignInRequest signInRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),signInRequest.getPassword()));

        var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(()-> new IllegalArgumentException("Invalid Email Or Password."));

        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
    }

}
