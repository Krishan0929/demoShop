package com.demoShop.exception;

public class ReturnNotValidException extends RuntimeException
{
    public ReturnNotValidException(String msg)
    {
        super(msg);
    }
}
