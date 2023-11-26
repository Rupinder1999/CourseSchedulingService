package com.example.geektrust.validator;

import com.example.geektrust.exception.InvalidInputException;

import static com.example.geektrust.constant.ErrorType.INPUT_DATA_ERROR;

public class BasicCommandValidator {
    public void doBasicValidation(String command[]) {
        if(command.length==0){
              throw new InvalidInputException(INPUT_DATA_ERROR);
        }
    }
}
