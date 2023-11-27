package com.example.geektrust.validator;

public class CancelCommandValidator {
    private static final Integer PARAMETER_COUNT=1;
    public boolean validate(String command[]){
        if(command.length-1!=PARAMETER_COUNT)
            return false;
        return true;
    }
}
