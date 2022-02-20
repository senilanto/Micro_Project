package com.account.advice;

import com.account.Model.EmptyInputException;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import  java.lang.Throwable;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice {


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementExeption1(NoSuchElementException elementException){
        return new ResponseEntity<String>("No such id is present in dB, Please check that", HttpStatus.OK);
    }

@ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleNoSuchElementExeption2(EmptyInputException elementException){
    return new ResponseEntity<String>("Null id present in db, Please check that", HttpStatus.OK);
}






}
