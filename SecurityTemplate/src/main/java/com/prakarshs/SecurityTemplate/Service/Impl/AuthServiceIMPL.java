package com.prakarshs.SecurityTemplate.Service.Impl;

import com.prakarshs.SecurityTemplate.DTO.JWTAuthResponse;
import com.prakarshs.SecurityTemplate.DTO.RefreshTokenRequest;
import com.prakarshs.SecurityTemplate.DTO.SignInRequest;
import com.prakarshs.SecurityTemplate.DTO.SignUpRequest;
import com.prakarshs.SecurityTemplate.Entity.UserEntity;
import com.prakarshs.SecurityTemplate.Enums.Role;
import com.prakarshs.SecurityTemplate.Exceptions.DuplicateValueException;
import com.prakarshs.SecurityTemplate.Exceptions.ValueDoesntExist;
import com.prakarshs.SecurityTemplate.Repository.UserRepository;
import com.prakarshs.SecurityTemplate.Service.AuthService;
import com.prakarshs.SecurityTemplate.Service.JWTService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Log4j2
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
        try{
            userRepository.save(user);
        }catch (Exception e){
            log.error("Duplicate Email ID. Try With A Different Email ID.");
            throw new DuplicateValueException("The EmailID Already Exists.","Try With A Different EmailID Instead.");
        }

        return user;
    }

    @Override
    public JWTAuthResponse signIn(SignInRequest signInRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
        log.info("here in sign in");

        var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new ValueDoesntExist("The Entered Email Doesn't Exist","Try Signing Up With The Email First."));

        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();

        jwtAuthResponse.setToken(jwt);
        jwtAuthResponse.setRefreshToken(refreshToken);

        return jwtAuthResponse;
    }

    @Override
    public JWTAuthResponse refresh(RefreshTokenRequest refreshRequest) {
        String userEmail = jwtService.extractUserName(refreshRequest.getToken());
        var user = userRepository.findByEmail(userEmail).orElseThrow(() -> new ValueDoesntExist("The Entered Email Doesn't Exist","Try Signing Up With The Email First."));
        if(jwtService.isTokenValid(refreshRequest.getToken(),user)){
            var jwt = jwtService.generateToken(user);

            JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();

            jwtAuthResponse.setToken(jwt);
            jwtAuthResponse.setRefreshToken(refreshRequest.getToken());

            return jwtAuthResponse;
        }
        return null;
    }

}
