package com.example.geektrust.repository.classes;

import com.example.geektrust.database.table.EmployeeCourseOfferingTable;
import com.example.geektrust.entities.EmployeeRegistration;
import com.example.geektrust.repository.interfaces.IEmployeeCourseOfferingRepository;

import java.util.List;
import java.util.SortedSet;

public class EmployeeCourseOfferingRepository implements IEmployeeCourseOfferingRepository {

    //To move this to some function like getter
    private static EmployeeCourseOfferingTable employeeCourseOfferingTable = new EmployeeCourseOfferingTable();
    @Override
    public void saveRegistrationAgainstCourseOfferingId(String registrationId, String courseOfferingId) {
        employeeCourseOfferingTable.addEmployeeByCourseOfferingAdd(registrationId,courseOfferingId);
    }

    @Override
    public List<EmployeeRegistration> getEmployeesByCourseOffering(String courseOfferingId) {
        return employeeCourseOfferingTable.getEmployeeByCourseOfferingId(courseOfferingId);
    }

    @Override
    public SortedSet<String> getEmployeesIdsByCourseOffering(String courseOfferingId) {
        return employeeCourseOfferingTable.getEmployeesIdsByCourseOffering(courseOfferingId);
    }

    @Override
    public void removeRegistrationFromCourseOffering(String courseOfferingId,
                                                     String registrationNo) {
        employeeCourseOfferingTable.removeRegistrationFromCourseOffering(courseOfferingId, registrationNo);
    }

}
