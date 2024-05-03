package com.prakarshs.SecurityTemplate.Service;

import com.prakarshs.SecurityTemplate.DTO.JWTAuthResponse;
import com.prakarshs.SecurityTemplate.DTO.RefreshTokenRequest;
import com.prakarshs.SecurityTemplate.DTO.SignInRequest;
import com.prakarshs.SecurityTemplate.DTO.SignUpRequest;
import com.prakarshs.SecurityTemplate.Entity.UserEntity;
import com.prakarshs.SecurityTemplate.Exceptions.FailedAuthentication;

public interface AuthService {
    UserEntity signup(SignUpRequest signUpRequest);
    JWTAuthResponse signIn(SignInRequest signInRequest) throws FailedAuthentication;
    JWTAuthResponse refresh(RefreshTokenRequest refreshRequest);


}
