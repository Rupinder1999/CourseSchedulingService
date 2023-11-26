package com.example.geektrust.repository.interfaces;

import com.example.geektrust.entities.Employee;

public interface IEmployeeRepository {
    public Employee upsertEmployee(Employee employee);
    public Employee getEmployeeByRegistrationId(String registrationId);
}
