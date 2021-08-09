package com.demoShop.exception;

import com.demoShop.model.Order;

public class OrderNotFoundException extends RuntimeException
{
    public OrderNotFoundException(String msg)
    {
        super(msg);
    }
}
