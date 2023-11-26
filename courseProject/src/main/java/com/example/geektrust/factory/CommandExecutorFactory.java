package com.example.geektrust.factory;

import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.interfaces.services.ICommandExecutorService;
import com.example.geektrust.services.command.AddCourseOfferingCommandExecutorService;
import com.example.geektrust.services.command.AllotCommandExecutorService;
import com.example.geektrust.services.command.RegisterCommandExecutorService;

import static com.example.geektrust.constant.CommandType.*;
import static com.example.geektrust.constant.ErrorType.INPUT_DATA_ERROR;

public class CommandExecutorFactory {
    public static ICommandExecutorService getCommandExecutor(String commandName){
        switch (commandName){
            case REGISTER_EMPLOYEE :
               return new RegisterCommandExecutorService();
            case ALLOT:
                return new AllotCommandExecutorService();
            case ADD_COURSE_OFFERING:
                return new AddCourseOfferingCommandExecutorService();
            default:
                throw new InvalidInputException(INPUT_DATA_ERROR);
        }
    }
}
