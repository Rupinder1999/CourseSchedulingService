package com.example.geektrust.repository.interfaces;

import com.example.geektrust.entities.Employee;

import java.util.List;

public interface IEmployeeCourseRepository {
    public void saveEmployeeByCourseOffering(Employee employee, String courseOfferingId);
    public List<Employee> getEmployeesByCourseOffering(String courseOfferingId);
}
