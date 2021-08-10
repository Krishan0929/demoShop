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
        ExceptionInfo info=new ExceptionInfo(onf.getMessage(), HttpStatus.NOT_FOUND,ZonedDateTime.now());
        return new ResponseEntity(info,new HttpHeaders(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<Object> handleOutOfStock(OutOfStockException stockExc)
    {
        ExceptionInfo info=new ExceptionInfo(stockExc.getMessage(), HttpStatus.NOT_FOUND,ZonedDateTime.now());
        return new ResponseEntity(info,new HttpHeaders(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InsufficientAmountException.class)
    public ResponseEntity<Object> handleWalletException(InsufficientAmountException walletExc)
    {
        ExceptionInfo info=new ExceptionInfo(walletExc.getMessage(), HttpStatus.BAD_REQUEST,ZonedDateTime.now());
        return new ResponseEntity(info,new HttpHeaders(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ReturnNotValidException.class)
    public ResponseEntity<Object> handleOrderReturnException(ReturnNotValidException returnExc)
    {
        ExceptionInfo info=new ExceptionInfo(returnExc.getMessage(), HttpStatus.BAD_REQUEST,ZonedDateTime.now());
        return new ResponseEntity(info,new HttpHeaders(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFound(CustomerNotFoundException customerExc)
    {
        ExceptionInfo info=new ExceptionInfo(customerExc.getMessage(), HttpStatus.NOT_FOUND,ZonedDateTime.now());
        return new ResponseEntity(info,new HttpHeaders(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFound(ProductNotFoundException productExc)
    {
        ExceptionInfo info=new ExceptionInfo(productExc.getMessage(), HttpStatus.NOT_FOUND,ZonedDateTime.now());
        return new ResponseEntity(info,new HttpHeaders(),HttpStatus.NOT_FOUND);
    }

}
