package com.example.geektrust.services.command;

import com.example.geektrust.dao.impl.CourseOfferingOfferingDao;
import com.example.geektrust.dao.impl.EmployeeCourseOfferingDao;
import com.example.geektrust.dao.impl.EmployeeRegistrationDao;
import com.example.geektrust.dao.interfaces.ICourseOfferingDao;
import com.example.geektrust.dao.interfaces.IEmployeeCourseOfferingDao;
import com.example.geektrust.dao.interfaces.IEmployeeRegistrationDao;
import com.example.geektrust.entities.CourseOffering;
import com.example.geektrust.entities.EmployeeRegistration;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.interfaces.services.ICommandExecutorService;
import com.example.geektrust.model.command.RegisterEmployeeCommand;
import com.example.geektrust.validator.RegisterCourseValidator;

import java.util.List;

import static com.example.geektrust.constant.EmployeeRegistrationStatus.ACCEPTED;
import static com.example.geektrust.constant.EmployeeRegistrationStatus.PENDING;
import static com.example.geektrust.constant.ErrorType.COURSE_FULL_ERROR;
import static com.example.geektrust.constant.ErrorType.INPUT_DATA_ERROR;

public class RegisterCommandExecutorService implements ICommandExecutorService {
    private static RegisterCourseValidator validator=new RegisterCourseValidator();

    private static ICourseOfferingDao courseDao=new CourseOfferingOfferingDao();

    private static IEmployeeRegistrationDao employeeDao = new EmployeeRegistrationDao();

    private static IEmployeeCourseOfferingDao employeeCourseDao = new EmployeeCourseOfferingDao();
    @Override
    public void execute(String[] command) {
        boolean isValid=validator.validate(command);
        if(!isValid)
            throw new InvalidInputException(INPUT_DATA_ERROR);
        RegisterEmployeeCommand registerEmployeeCommand=getCommandObject(command);
      EmployeeRegistration employeeRegistration = registerEmployeeToCourse(registerEmployeeCommand);
      printCommandOutput(employeeRegistration.getRegistration_no(),ACCEPTED);
    }


    private RegisterEmployeeCommand getCommandObject(String command[]) {
       RegisterEmployeeCommand registerEmployeeCommand=RegisterEmployeeCommand.builder()
               .email(command[1])
               .offeringId(command[2])
               .build();
       return registerEmployeeCommand;
    }

    private EmployeeRegistration registerEmployeeToCourse(RegisterEmployeeCommand command){
         Integer index = command.getEmail().indexOf("@");
         String employeeName = command.getEmail().substring(0,index);
         String courseRegistrationId=generateRegistrationId(command,employeeName);
         checkIfRegistrationIsValid(command);
        EmployeeRegistration employeeRegistration = EmployeeRegistration.builder()
                .name(employeeName)
                .course_offering_id(command.getOfferingId())
                .status(PENDING)
                .registration_no(courseRegistrationId)
                .email(command.getEmail())
                .build();
        employeeRegistration = employeeDao.upsertEmployeeRegistration(employeeRegistration);
        CourseOffering course = courseDao.getCourseByOfferingId(command.getOfferingId());
        employeeCourseDao.saveRegistrationAgainstCourseOfferingId(courseRegistrationId,
                course.getCourseOfferingId());
        return employeeRegistration;
    }

    private String generateRegistrationId(RegisterEmployeeCommand command,String employeeName){
        //REG-COURSE-<EMPLOYEE-NAME>-<COURSE-NAME>;
        CourseOffering course = courseDao.getCourseByOfferingId(command.getOfferingId());
        return "REG-COURSE-"+employeeName+"-"+course.getTitle();
    }

    private void checkIfRegistrationIsValid(RegisterEmployeeCommand registerEmployeeCommand){
        //check if course offering exist
        CourseOffering course = courseDao.getCourseByOfferingId(registerEmployeeCommand.getOfferingId());
        if(course==null)
            throw  new InvalidInputException(INPUT_DATA_ERROR);
        List<EmployeeRegistration> employeeRegistrationList =
                employeeCourseDao.getEmployeesByCourseOffering(course.getCourseOfferingId());
        //check if course offering is already full
        if(course.getMaxEmployees()==employeeRegistrationList.size())
            throw  new InvalidInputException(COURSE_FULL_ERROR);
    }

    private  void printCommandOutput(String registrationNo,String status){
        System.out.println(registrationNo+" "+status);
    }
}
