package com.example.geektrust.services.command;

import com.example.geektrust.dao.impl.CourseOfferingOfferingDao;
import com.example.geektrust.dao.interfaces.ICourseOfferingDao;
import com.example.geektrust.entities.CourseOffering;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.interfaces.services.ICommandExecutorService;
import com.example.geektrust.model.command.AddOfferingCommand;
import com.example.geektrust.validator.AddCourseCommandValidator;

import static com.example.geektrust.constant.ErrorType.INPUT_DATA_ERROR;

public class AddCourseOfferingCommandExecutorService implements ICommandExecutorService {
    private static AddCourseCommandValidator addCourseCommandValidator=new AddCourseCommandValidator();

    private static ICourseOfferingDao courseDao = new CourseOfferingOfferingDao();

    public AddCourseOfferingCommandExecutorService(){

    }

    public AddCourseOfferingCommandExecutorService(AddCourseCommandValidator addCourseCommandValidator){
        this.addCourseCommandValidator=addCourseCommandValidator;
    }

    @Override
    public void execute(String [] command) {
          boolean isValid=addCourseCommandValidator.isValid(command);
          if(!isValid)
              throw new InvalidInputException(INPUT_DATA_ERROR);
          AddOfferingCommand addOfferingCommand=getCommandObject(command);
          CourseOffering courseOffering=addCourseToDataBase(addOfferingCommand);
          System.out.println(courseOffering.getCourseOfferingId());
    }

    // to make this function part of interface
    private AddOfferingCommand getCommandObject(String command[]) {
        return AddOfferingCommand.builder()
                .courseTitle(command[1])
                .instructor(command[2])
                .date(command[3])
                .minEmployee(Integer.parseInt(command[4]))
                .maxEmployee(Integer.parseInt(command[5]))
                .build();
    }

    private CourseOffering addCourseToDataBase(AddOfferingCommand command){
         String courseOfferingId= generateCourseOfferingID(command.getCourseTitle(),
                         command.getInstructor());
         CourseOffering course=CourseOffering.builder()
                 .title(command.getCourseTitle())
                 .instructor(command.getInstructor())
                 .date(command.getDate())
                 .minEmployees(command.getMinEmployee())
                 .maxEmployees(command.getMaxEmployee())
                 .courseOfferingId(courseOfferingId)
                 .build();
         course=courseDao.addCourse(course);

        return course;
    }

    private String generateCourseOfferingID(String courseName,
                                            String instructor){
        return "OFFERING-"+courseName+"-"+instructor;
    }


}
