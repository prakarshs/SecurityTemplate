package com.prakarshs.SecurityTemplate.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorBody> duplicateHandler(DuplicateValueException exception){
        return new ResponseEntity<>(ErrorBody.builder()
                .message(exception.getMessage())
                .resolution(exception.getResolution())
                .build(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorBody> invalidHandler(ValueDoesntExist exception){
        return new ResponseEntity<>(ErrorBody.builder()
                .message(exception.getMessage())
                .resolution(exception.getResolution())
                .build(), HttpStatus.NOT_FOUND);
    }

}
