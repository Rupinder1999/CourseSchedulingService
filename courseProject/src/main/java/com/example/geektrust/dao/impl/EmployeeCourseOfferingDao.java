package com.example.geektrust.dao.impl;

import com.example.geektrust.dao.interfaces.IEmployeeCourseOfferingDao;
import com.example.geektrust.entities.EmployeeRegistration;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.repository.classes.EmployeeCourseOfferingRepository;
import com.example.geektrust.repository.interfaces.IEmployeeCourseOfferingRepository;

import java.util.List;
import java.util.SortedSet;

import static com.example.geektrust.constant.ErrorType.INPUT_DATA_ERROR;

public class EmployeeCourseOfferingDao implements IEmployeeCourseOfferingDao {

    private static IEmployeeCourseOfferingRepository employeeCourseRepository = new EmployeeCourseOfferingRepository();
    @Override
    public void saveRegistrationAgainstCourseOfferingId(String  registrationId,
                                                        String courseOfferingId) {
        SortedSet<String> employeesIdSet=
                employeeCourseRepository.getEmployeesIdsByCourseOffering(courseOfferingId);
        if(employeesIdSet.contains(registrationId))
            throw new InvalidInputException(INPUT_DATA_ERROR);
        employeeCourseRepository.saveRegistrationAgainstCourseOfferingId(registrationId ,courseOfferingId);
    }

    @Override
    public List<EmployeeRegistration> getEmployeesByCourseOffering(String courseOfferingId) {
        return employeeCourseRepository.getEmployeesByCourseOffering(courseOfferingId);
    }

    @Override
    public void removeRegistrationFromCourseOffering(String courseOfferingId,
                                                     String registrationNo) {
        employeeCourseRepository.removeRegistrationFromCourseOffering(courseOfferingId,registrationNo);
    }


}
