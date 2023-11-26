package com.example.geektrust.exception;

public class InvalidInputException  extends RuntimeException{
    String errorCode;
    public InvalidInputException(String errorCode){
        super(errorCode);
    }

}
