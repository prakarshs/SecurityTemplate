package com.prakarshs.SecurityTemplate.Service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JWTService {
    String generateToken(UserDetails userDetails);
    String extractUserName(String token);
    Boolean isTokenValid(String token, UserDetails userDetails);

}
