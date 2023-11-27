package com.example.geektrust.dao.interfaces;

import com.example.geektrust.entities.EmployeeRegistration;

import java.util.List;
import java.util.SortedSet;

public interface IEmployeeCourseOfferingDao {
    public void saveRegistrationAgainstCourseOfferingId(String registrationId,
                                                        String courseOfferingId);
    public List<EmployeeRegistration> getEmployeesByCourseOffering(String courseOfferingId);

    public void removeRegistrationFromCourseOffering(String courseOfferingId,
                                                     String registrationNo);

}
