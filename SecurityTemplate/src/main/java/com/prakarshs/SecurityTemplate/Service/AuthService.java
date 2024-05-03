package com.prakarshs.SecurityTemplate.Service;

import com.prakarshs.SecurityTemplate.DTO.SignUpRequest;
import com.prakarshs.SecurityTemplate.Entity.UserEntity;

public interface AuthService {
    UserEntity signup(SignUpRequest signUpRequest);
}
