package com.engine.sale.exception;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeJsonMappingException.class)
    public ResponseEntity<String> handleValidationExceptions(RuntimeJsonMappingException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}