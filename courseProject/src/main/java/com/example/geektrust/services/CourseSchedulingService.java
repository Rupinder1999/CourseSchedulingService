package com.example.geektrust.services;

import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.factory.CommandExecutorFactory;
import com.example.geektrust.factory.FileParserFactory;
import com.example.geektrust.interfaces.services.ICommandExecutorService;
import com.example.geektrust.interfaces.services.IFileParserService;
import com.example.geektrust.utilities.FileUtil;
import com.example.geektrust.validator.BasicCommandValidator;
import java.util.List;

public class CourseSchedulingService {
    private BasicCommandValidator basicCommandValidator;

    public CourseSchedulingService(BasicCommandValidator basicCommandValidator){
        this.basicCommandValidator=basicCommandValidator;
    }
    public void start(String filePath) throws InvalidInputException {
        String fileType= FileUtil.getFileType(filePath);
        IFileParserService fileParserService=
                FileParserFactory.getFileParserService(fileType);
        List<String[]> commands=fileParserService.parseFile(filePath);
        startCommandsExecution(commands);
        printCommands(commands);
    }
    private void printCommands(List<String[]> commands){
        for(String[] command : commands){
            for(String column: command)
                System.out.print(column+"  ");
            System.out.println();
        }
    }

    private void startCommandsExecution(List<String[]> commands)  {
        for(String command[]:commands) {
            basicCommandValidator.doBasicValidation(command);
            ICommandExecutorService commandExecutorService=
                    CommandExecutorFactory.getCommandExecutor(command[0]);
            try{
                commandExecutorService.execute(command);
            }
            catch (InvalidInputException invalidInputException){
                System.out.println(invalidInputException.getMessage());
            }

        }
    }
}
