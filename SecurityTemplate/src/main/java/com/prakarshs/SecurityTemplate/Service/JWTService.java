package com.prakarshs.SecurityTemplate.Service;

import com.prakarshs.SecurityTemplate.DTO.JWTAuthResponse;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public interface JWTService {
    String generateToken(UserDetails userDetails);
    String extractUserName(String token);
    Boolean isTokenValid(String token, UserDetails userDetails);
    String generateRefreshToken(Map<String, Object> extractClaims, UserDetails userDetails);
}
