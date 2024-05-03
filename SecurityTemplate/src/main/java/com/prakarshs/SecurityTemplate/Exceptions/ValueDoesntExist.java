package com.prakarshs.SecurityTemplate.Exceptions;

import lombok.Data;

@Data
public class ValueDoesntExist extends IllegalArgumentException{
    public String resolution;
    public ValueDoesntExist(String message, String resolution){
        super(message);
        this.resolution = resolution;
    }

}
