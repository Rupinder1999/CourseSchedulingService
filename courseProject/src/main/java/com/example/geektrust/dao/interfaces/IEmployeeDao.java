package com.example.geektrust.dao.interfaces;

import com.example.geektrust.entities.Course;
import com.example.geektrust.entities.Employee;

public interface IEmployeeDao {
    public Employee addEmployee(Employee employee);
    public Employee getEmployeeByRegistrationId(String registrationId);
}
