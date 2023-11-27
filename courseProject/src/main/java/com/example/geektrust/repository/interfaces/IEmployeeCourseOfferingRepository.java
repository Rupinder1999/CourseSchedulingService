package com.example.geektrust.repository.interfaces;

import com.example.geektrust.entities.EmployeeRegistration;

import java.util.List;
import java.util.SortedSet;


public interface IEmployeeCourseOfferingRepository {
    public void saveRegistrationAgainstCourseOfferingId(String registrationId,
                                                        String courseOfferingId);
    public List<EmployeeRegistration> getEmployeesByCourseOffering(String courseOfferingId);

    public SortedSet<String> getEmployeesIdsByCourseOffering(String courseOfferingId);

    public void removeRegistrationFromCourseOffering(String courseOfferingId,
                                                     String registrationId);
}
