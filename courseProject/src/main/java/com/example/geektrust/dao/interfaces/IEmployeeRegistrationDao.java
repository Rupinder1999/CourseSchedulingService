package com.example.geektrust.dao.interfaces;

import com.example.geektrust.entities.EmployeeRegistration;

public interface IEmployeeRegistrationDao {
    public EmployeeRegistration upsertEmployeeRegistration(EmployeeRegistration employeeRegistration);
    public EmployeeRegistration getEmployeeByRegistrationId(String registrationId);
    public EmployeeRegistration removeEmployeeRegistration(EmployeeRegistration employeeRegistration);
}
