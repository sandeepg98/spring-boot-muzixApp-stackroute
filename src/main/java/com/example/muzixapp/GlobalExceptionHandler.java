package com.example.muzixapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> customGlobalException(Exception ex){
        return new ResponseEntity<String>("Global Exception!", HttpStatus.CONFLICT);
    }
}
