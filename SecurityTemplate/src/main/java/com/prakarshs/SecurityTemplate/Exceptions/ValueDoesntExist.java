package com.prakarshs.SecurityTemplate.Exceptions;

import lombok.Data;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Data
public class ValueDoesntExist extends UsernameNotFoundException {
    public String resolution;
    public ValueDoesntExist(String message, String resolution){
        super(message);
        this.resolution = resolution;
    }

}
