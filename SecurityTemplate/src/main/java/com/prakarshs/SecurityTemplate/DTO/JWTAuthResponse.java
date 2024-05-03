package com.prakarshs.SecurityTemplate.DTO;

import lombok.Data;

@Data
public class JWTAuthResponse {
    private String token;
    private String refreshToken;
}
