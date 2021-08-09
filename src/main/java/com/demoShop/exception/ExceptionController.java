package com.demoShop.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Clock;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionController
{
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleOrderException(OrderNotFoundException onf)
    {
        ExceptiopnInfo info=new ExceptiopnInfo(onf.getMessage(), HttpStatus.NOT_FOUND,ZonedDateTime.now());

        return new ResponseEntity(info,new HttpHeaders(),HttpStatus.NOT_FOUND);
    }
}
