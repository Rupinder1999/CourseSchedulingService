package com.example.geektrust.dao.impl;

import com.example.geektrust.dao.interfaces.IEmployeeCourseDao;
import com.example.geektrust.entities.Employee;
import com.example.geektrust.repository.classes.EmployeeCourseRepository;
import com.example.geektrust.repository.interfaces.IEmployeeCourseRepository;

import java.util.List;

public class EmployeeCourseDao implements IEmployeeCourseDao {

    private static IEmployeeCourseRepository employeeCourseRepository = new EmployeeCourseRepository();
    @Override
    public void saveEmployeeByCourseOffering(Employee employee, String courseOfferingId) {
        employeeCourseRepository.saveEmployeeByCourseOffering(employee,courseOfferingId);
    }

    @Override
    public List<Employee> getEmployeesByCourseOffering(String courseOfferingId) {
        return employeeCourseRepository.getEmployeesByCourseOffering(courseOfferingId);
    }
}
