package com.example.geektrust.dao.impl;

import com.example.geektrust.dao.interfaces.IEmployeeRegistrationDao;
import com.example.geektrust.entities.EmployeeRegistration;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.repository.classes.CourseRepository;
import com.example.geektrust.repository.classes.EmployeeCourseOfferingRepository;
import com.example.geektrust.repository.classes.EmployeeRegistrationRepository;
import com.example.geektrust.repository.interfaces.IEmployeeCourseOfferingRepository;
import com.example.geektrust.repository.interfaces.IEmployeeRegistrationRepository;

import static com.example.geektrust.constant.ErrorType.INPUT_DATA_ERROR;

public class EmployeeRegistrationDao implements IEmployeeRegistrationDao {
    private  static IEmployeeRegistrationRepository employeeRegistrationRepository =
            new EmployeeRegistrationRepository();
    private static IEmployeeCourseOfferingRepository employeeCourseRepository = new EmployeeCourseOfferingRepository();
    private static CourseRepository courseRepository=new CourseRepository();

    @Override
    public EmployeeRegistration upsertEmployeeRegistration(EmployeeRegistration employeeRegistration) {
        EmployeeRegistration employeeRegistrationInDb =
                employeeRegistrationRepository.getEmployeeByRegistrationId(employeeRegistration.getRegistration_no());
        //for allotment this was requried ot update the status of registration to confirmed . but
        // and we have check the employee should not be there  already . this is specific for
        // register case but db layer should not contain the usecase specific or buissness
        // related code . thats why this fials
//        if(employeeRegistrationInDb !=null)
//            throw new InvalidInputException(INPUT_DATA_ERROR);

        return employeeRegistrationRepository.upsertEmployeeRegistration(employeeRegistration);
    }

    @Override
    public EmployeeRegistration getEmployeeByRegistrationId(String registrationId) {
        return employeeRegistrationRepository.getEmployeeByRegistrationId(registrationId);
    }

    @Override
    public EmployeeRegistration removeEmployeeRegistration(EmployeeRegistration employeeRegistration) {
        return  employeeRegistrationRepository.removeEmployeeRegistration(employeeRegistration);
    }
}
