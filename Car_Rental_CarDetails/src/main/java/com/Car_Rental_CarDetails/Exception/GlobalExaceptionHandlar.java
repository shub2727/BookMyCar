package com.Car_Rental_CarDetails.Exception;



import com.Car_Rental_CarDetails.Payloads.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExaceptionHandlar  {


    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<Constant> resourceNotFoundExceptionHandlar(ResourceNotFoundException ex){
     String msg= ex.getMessage();
        Constant apiRespones= Constant.builder()
             .msg(msg)
             .build();
     return new ResponseEntity<>(apiRespones, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodNotFoundExceptionHandler(MethodArgumentNotValidException ex){

        Map<String,String> handel= new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName= ((FieldError)error).getField();
            String message= error.getDefaultMessage();
            handel.putIfAbsent(fieldName,message);

        });
        return new ResponseEntity<Map<String,String>>(handel,HttpStatus.BAD_REQUEST);


    }



}
