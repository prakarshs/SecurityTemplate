package com.prakarshs.SecurityTemplate.Controller;

import com.prakarshs.SecurityTemplate.DTO.JWTAuthResponse;
import com.prakarshs.SecurityTemplate.DTO.RefreshTokenRequest;
import com.prakarshs.SecurityTemplate.DTO.SignInRequest;
import com.prakarshs.SecurityTemplate.DTO.SignUpRequest;
import com.prakarshs.SecurityTemplate.Entity.UserEntity;
import com.prakarshs.SecurityTemplate.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> signin(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authService.signIn(signInRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JWTAuthResponse> refresh(@RequestBody RefreshTokenRequest refreshRequest){
        return ResponseEntity.ok(authService.refresh(refreshRequest));
    }




}
