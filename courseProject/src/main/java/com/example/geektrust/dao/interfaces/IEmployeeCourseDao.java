package com.example.geektrust.dao.interfaces;

import com.example.geektrust.entities.Employee;

import java.util.List;

public interface IEmployeeCourseDao {
    public void saveEmployeeByCourseOffering(Employee employee, String courseOfferingId);
    public List<Employee> getEmployeesByCourseOffering(String courseOfferingId);
}
