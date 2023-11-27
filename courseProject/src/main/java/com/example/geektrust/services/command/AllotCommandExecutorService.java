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
import com.example.geektrust.model.command.AllotCommand;
import com.example.geektrust.validator.AllotCommandValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import static com.example.geektrust.constant.EmployeeRegistrationStatus.CONFIRMED;
import static com.example.geektrust.constant.ErrorType.INPUT_DATA_ERROR;

public class AllotCommandExecutorService implements ICommandExecutorService {

    private static AllotCommandValidator validator = new AllotCommandValidator();

    private   static ICourseOfferingDao courseDao = new CourseOfferingOfferingDao();

    private  static IEmployeeCourseOfferingDao employeeCourseOfferingDao =
            new EmployeeCourseOfferingDao();

    private static IEmployeeRegistrationDao employeeRegistrationDao =new EmployeeRegistrationDao();
    @Override
    public void execute(String[] command) {
       boolean isValid = validator.validate(command);
       if(!isValid)
           throw new InvalidInputException(INPUT_DATA_ERROR);
       AllotCommand allotCommand= getCommandObject(command);
        CourseOffering courseOffering =
                courseDao.getCourseByOfferingId(allotCommand.getCourseOfferingId());
        List<EmployeeRegistration> employeeRegistrationList=
                allotEmployeesToCourseOfferId(courseOffering);
        printCommandOutput(employeeRegistrationList,courseOffering);
    }

    private void printCommandOutput(List<EmployeeRegistration> employeeRegistrationList, CourseOffering courseOffering) {
        for(EmployeeRegistration employeeRegistration : employeeRegistrationList){
            System.out.println(employeeRegistration.getRegistration_no()+" "+
                    employeeRegistration.getEmail()+" "+employeeRegistration.getCourse_offering_id()+" "+
                    courseOffering.getTitle()+" "+courseOffering.getInstructor()+" "+courseOffering.getDate()+ " "+
                    employeeRegistration.getStatus());
        }
    }

    private AllotCommand getCommandObject(String command[]) {
       AllotCommand allotCommand = AllotCommand.builder()
               .courseOfferingId(command[1])
               .build();
       return allotCommand;
    }

    private List<EmployeeRegistration> allotEmployeesToCourseOfferId(
                                                                     CourseOffering courseOffering){
        boolean isValid = isValidAllotment(courseOffering);
        if(!isValid)
            throw new InvalidInputException(INPUT_DATA_ERROR);
        List<EmployeeRegistration> employeeRegistrationList=
                checkAndAllotEmployees(courseOffering);
       return employeeRegistrationList;

    }

    private List<EmployeeRegistration>  checkAndAllotEmployees(CourseOffering courseOffering) {
        List<EmployeeRegistration> employeeRegistrationList =
                getEmployeeRegistrationList(courseOffering.getCourseOfferingId());
        if(employeeRegistrationList.size()<courseOffering.getMinEmployees())
            return employeeRegistrationList;
       return allotEmployees(employeeRegistrationList);
    }

    private List<EmployeeRegistration> allotEmployees(List<EmployeeRegistration> employeeRegistrationList) {
        // convert it to single call
        for(EmployeeRegistration employeeRegistration: employeeRegistrationList ){
            employeeRegistration.setStatus(CONFIRMED);
            employeeRegistrationDao.upsertEmployeeRegistration(employeeRegistration);
        }
        return employeeRegistrationList;
    }

    private List<EmployeeRegistration> getEmployeeRegistrationList(String courseOfferingId){
        return   employeeCourseOfferingDao.getEmployeesByCourseOffering(courseOfferingId);
    }

    private boolean isValidAllotment(CourseOffering course){

        if(course==null)
            return false;
        return true;
    }

//    private SortedSet<String> getCourseRegistrationSet(CourseOffering courseOffering){
//        String courseOfferingId = courseOffering.getCourseOfferingId();
//        SortedSet<String> employeesIdSet=
//                employeeCourseOfferingDao.getEmployeesByCourseOffering(courseOfferingId);
//        return employeesIdSet;
//    }

}
