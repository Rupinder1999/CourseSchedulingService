package com.example.geektrust.dao.impl;

import com.example.geektrust.dao.interfaces.IEmployeeDao;
import com.example.geektrust.entities.Employee;
import com.example.geektrust.repository.classes.EmployeeRepository;
import com.example.geektrust.repository.interfaces.IEmployeeRepository;

public class EmployeeDao implements IEmployeeDao {
    private  static IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.upsertEmployee(employee);
    }

    @Override
    public Employee getEmployeeByRegistrationId(String registrationId) {
        return employeeRepository.getEmployeeByRegistrationId(registrationId);
    }
}
