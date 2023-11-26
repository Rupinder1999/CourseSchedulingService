package com.example.geektrust.services.command;

import com.example.geektrust.dao.impl.CourseDao;
import com.example.geektrust.dao.interfaces.ICourseDao;
import com.example.geektrust.entities.Course;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.interfaces.services.ICommandExecutorService;
import com.example.geektrust.model.command.AddOfferingCommand;
import com.example.geektrust.validator.AddCourseCommandValidator;

import static com.example.geektrust.constant.ErrorType.INPUT_DATA_ERROR;

public class AddCourseOfferingCommandExecutorService implements ICommandExecutorService {
    private static AddCourseCommandValidator addCourseCommandValidator=new AddCourseCommandValidator();

    private static ICourseDao courseDao = new CourseDao();

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
          Course course=addCourseToDataBase(addOfferingCommand);
          System.out.println(course.getCourseOfferingId());
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

    private Course addCourseToDataBase(AddOfferingCommand command){
         String courseOfferingId= generateCourseOfferingID(command.getCourseTitle(),
                         command.getInstructor());
         Course course=Course.builder()
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
