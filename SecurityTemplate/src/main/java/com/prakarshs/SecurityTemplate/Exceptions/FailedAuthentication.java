package com.prakarshs.SecurityTemplate.Exceptions;

import lombok.Data;

import javax.security.auth.login.FailedLoginException;

@Data
public class FailedAuthentication extends FailedLoginException {
    public String resolution;
    public FailedAuthentication(String message, String resolution){
        super(message);
        this.resolution = resolution;
    }

}
