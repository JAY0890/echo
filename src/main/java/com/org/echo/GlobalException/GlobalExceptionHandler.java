package com.org.echo.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handlevalidation(MethodArgumentNotValidException e){
        Map<String,String> map=new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(er->{
            String field= ((FieldError) er).getField();
            String message=er.getDefaultMessage();
            map.put(field,message);
        });
        return map;
    }
}
