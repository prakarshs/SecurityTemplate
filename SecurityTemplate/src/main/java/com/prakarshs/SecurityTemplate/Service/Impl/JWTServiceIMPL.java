package com.prakarshs.SecurityTemplate.Service.Impl;

import com.prakarshs.SecurityTemplate.Service.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTServiceIMPL implements JWTService {


    @Override
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 *24))
                .signWith(getSignKey())
                .compact();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }
    @Override
    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().build().parseSignedClaims(token).getPayload();
    }

    private Key getSignKey() {
        byte[] key = "**@@your-private-key-here@@**".getBytes(); // instead you can have base64 byte[] of your string aswell
        return Keys.hmacShaKeyFor(key); 
    }
}
