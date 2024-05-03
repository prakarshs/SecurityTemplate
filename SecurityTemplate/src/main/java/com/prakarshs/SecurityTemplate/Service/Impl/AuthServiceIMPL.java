package com.prakarshs.SecurityTemplate.Service.Impl;

import com.prakarshs.SecurityTemplate.Repository.UserRepository;
import com.prakarshs.SecurityTemplate.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
}
