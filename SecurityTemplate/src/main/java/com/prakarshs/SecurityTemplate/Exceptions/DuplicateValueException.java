package com.prakarshs.SecurityTemplate.Exceptions;

import jakarta.persistence.PersistenceException;
import lombok.Data;

@Data
public class DuplicateValueException extends PersistenceException {
    public String resolution;
    public DuplicateValueException(String message, String resolution){
        super(message);
        this.resolution = resolution;
    }
}
