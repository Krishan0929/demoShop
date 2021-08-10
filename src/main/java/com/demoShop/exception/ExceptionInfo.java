package com.demoShop.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class ExceptionInfo
{
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime zonedDateTime;

    public ExceptionInfo(String message, HttpStatus notFound, ZonedDateTime now)
    {

    }
}
