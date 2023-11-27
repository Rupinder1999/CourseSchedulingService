package com.example.geektrust.services.command;

import com.example.geektrust.dao.impl.EmployeeCourseOfferingDao;
import com.example.geektrust.dao.impl.EmployeeRegistrationDao;
import com.example.geektrust.dao.interfaces.IEmployeeCourseOfferingDao;
import com.example.geektrust.dao.interfaces.IEmployeeRegistrationDao;
import com.example.geektrust.entities.EmployeeRegistration;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.interfaces.services.ICommandExecutorService;
import com.example.geektrust.model.command.CancelCommand;
import com.example.geektrust.validator.CancelCommandValidator;

import static com.example.geektrust.constant.CancelCommandOutput.CANCEL_ACCEPTED;
import static com.example.geektrust.constant.EmployeeRegistrationStatus.CONFIRMED;
import static com.example.geektrust.constant.ErrorType.CANCEL_REJECTED;
import static com.example.geektrust.constant.ErrorType.INPUT_DATA_ERROR;

public class CancelCommandExecutorService implements ICommandExecutorService {

    private static IEmployeeRegistrationDao employeeRegistrationDao = new EmployeeRegistrationDao();

    private static IEmployeeCourseOfferingDao employeeCourseOfferingDao =
            new EmployeeCourseOfferingDao();

    private static CancelCommandValidator cancelCommandValidator = new CancelCommandValidator();
    @Override
    public void execute(String[] command) {
         boolean isValid = cancelCommandValidator.validate(command);
         if(!isValid)
             throw  new InvalidInputException(INPUT_DATA_ERROR);
        CancelCommand cancelCommand = getCommandObject(command);
        String cancelStatus = cancelRegistration(cancelCommand);
        printCancelCommandOutput( cancelCommand.getCourseRegistrationId(),cancelStatus);

    }

    private CancelCommand getCommandObject(String command[]) {
        CancelCommand cancelCommand =
                CancelCommand.builder().courseRegistrationId(command[1]).build();
        return  cancelCommand;
    }

    private String  cancelRegistration(CancelCommand cancelCommand){
        String registrationNo = cancelCommand.getCourseRegistrationId();
        EmployeeRegistration employeeRegistration =
                employeeRegistrationDao.getEmployeeByRegistrationId(registrationNo);
        if(employeeRegistration==null)
            throw new InvalidInputException(INPUT_DATA_ERROR);
        String registrationStatus = employeeRegistration.getStatus();
        if(registrationStatus==CONFIRMED){
            return CANCEL_REJECTED;
        }

        employeeRegistration =
                employeeRegistrationDao.removeEmployeeRegistration(employeeRegistration);
        employeeCourseOfferingDao.removeRegistrationFromCourseOffering(employeeRegistration.getCourse_offering_id(),
                employeeRegistration.getRegistration_no());
        return CANCEL_ACCEPTED;
    }

    private void printCancelCommandOutput(String courseRegistrationId, String cancelStatus) {
        System.out.println(courseRegistrationId+" "+cancelStatus);
    }

}
