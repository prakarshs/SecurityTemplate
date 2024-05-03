package com.prakarshs.SecurityTemplate.Exceptions;

import lombok.Data;

@Data
public class ErrorBody {
    private String message;
    private String resolution;
}
