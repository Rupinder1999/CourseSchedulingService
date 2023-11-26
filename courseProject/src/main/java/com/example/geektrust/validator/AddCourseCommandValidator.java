package com.example.geektrust.validator;

public class AddCourseCommandValidator {
    //count of the no of parameter of Add course offering command
    private static final Integer PARAMETER_COUNT=5;
    public boolean isValid(String command[]){
          if(command.length-1!=PARAMETER_COUNT)
              return false;
          return true;
    }
}
