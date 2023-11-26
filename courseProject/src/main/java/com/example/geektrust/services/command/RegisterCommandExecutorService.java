package com.example.geektrust.services.command;

import com.example.geektrust.dao.impl.CourseDao;
import com.example.geektrust.dao.impl.EmployeeCourseDao;
import com.example.geektrust.dao.impl.EmployeeDao;
import com.example.geektrust.dao.interfaces.ICourseDao;
import com.example.geektrust.dao.interfaces.IEmployeeCourseDao;
import com.example.geektrust.dao.interfaces.IEmployeeDao;
import com.example.geektrust.entities.Course;
import com.example.geektrust.entities.Employee;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.interfaces.services.ICommandExecutorService;
import com.example.geektrust.model.command.RegisterEmployeeCommand;
import com.example.geektrust.validator.RegisterCourseValidator;

import static com.example.geektrust.constant.EmployeeStatus.PENDING;
import static com.example.geektrust.constant.ErrorType.INPUT_DATA_ERROR;

public class RegisterCommandExecutorService implements ICommandExecutorService {
    private static RegisterCourseValidator validator=new RegisterCourseValidator();

    private static ICourseDao courseDao=new CourseDao();

    private static IEmployeeDao employeeDao = new EmployeeDao();

    private static IEmployeeCourseDao employeeCourseDao = new EmployeeCourseDao();
    @Override
    public void execute(String[] command) {
        boolean isValid=validator.validate(command);
        if(!isValid)
            throw new InvalidInputException(INPUT_DATA_ERROR);
        RegisterEmployeeCommand registerEmployeeCommand=getCommandObject(command);
        registerEmployeeToCourse(registerEmployeeCommand);
    }


    private RegisterEmployeeCommand getCommandObject(String command[]) {
       RegisterEmployeeCommand registerEmployeeCommand=RegisterEmployeeCommand.builder()
               .email(command[1])
               .offeringId(command[2])
               .build();
       return registerEmployeeCommand;
    }

    private  void  registerEmployeeToCourse(RegisterEmployeeCommand command){
         Integer index = command.getEmail().indexOf("@");
         String employeeName = command.getEmail().substring(0,index);
         String courseRegistrationId=generateRegistrationId(command,employeeName);
        Employee employee = Employee.builder()
                .name(employeeName)
                .course_offering_id(command.getOfferingId())
                .status(PENDING)
                .registration_no(courseRegistrationId)
                .build();
        employee = employeeDao.addEmployee(employee);
        Course course = courseDao.getCourseByOfferingId(command.getOfferingId());
        employeeCourseDao.saveEmployeeByCourseOffering(employee,course.getCourseOfferingId());
    }

    private String generateRegistrationId(RegisterEmployeeCommand command,String employeeName){
        //REG-COURSE-<EMPLOYEE-NAME>-<COURSE-NAME>;
        Course course = courseDao.getCourseByOfferingId(command.getOfferingId());
        return "REG-COURSE-"+employeeName+"-"+course.getTitle();
    }
}
