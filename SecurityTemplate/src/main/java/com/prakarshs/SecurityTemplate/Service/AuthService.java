package com.prakarshs.SecurityTemplate.Service;

import com.prakarshs.SecurityTemplate.DTO.JWTAuthResponse;
import com.prakarshs.SecurityTemplate.DTO.SignInRequest;
import com.prakarshs.SecurityTemplate.DTO.SignUpRequest;
import com.prakarshs.SecurityTemplate.Entity.UserEntity;

public interface AuthService {
    UserEntity signup(SignUpRequest signUpRequest);
    JWTAuthResponse signIn(SignInRequest signInRequest);
}
