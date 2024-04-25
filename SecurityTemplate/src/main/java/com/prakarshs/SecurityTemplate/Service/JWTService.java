package com.prakarshs.SecurityTemplate.Service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JWTService {
    String generateToken(UserDetails userDetails);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolvers)

}
