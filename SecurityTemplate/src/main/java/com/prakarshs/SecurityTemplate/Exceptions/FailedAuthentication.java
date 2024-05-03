package com.prakarshs.SecurityTemplate.Exceptions;

import lombok.Data;

@Data
public class FailedAuthentication extends RuntimeException{
    public String resolution;
    public FailedAuthentication(String message, String resolution){
        super(message);
        this.resolution = resolution;
    }

}
