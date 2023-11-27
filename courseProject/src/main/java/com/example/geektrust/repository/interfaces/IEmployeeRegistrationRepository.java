package com.example.geektrust.repository.interfaces;

import com.example.geektrust.entities.EmployeeRegistration;

public interface IEmployeeRegistrationRepository {
    public EmployeeRegistration upsertEmployeeRegistration(EmployeeRegistration employeeRegistration);
    public EmployeeRegistration getEmployeeByRegistrationId(String registrationId);

    public EmployeeRegistration removeEmployeeRegistration(EmployeeRegistration employeeRegistration);
}
