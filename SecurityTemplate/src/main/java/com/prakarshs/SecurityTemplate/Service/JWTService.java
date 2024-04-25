package com.prakarshs.SecurityTemplate.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String generateToken(UserDetails userDetails);

}
