package com.customer.advice;

import com.customer.customException.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleNoSuchElementExeption(EmptyInputException elementException) {
        return new ResponseEntity<String>("Input should not be empty", HttpStatus.NOT_FOUND);
    }
    }
