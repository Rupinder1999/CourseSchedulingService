package com.example.geektrust.repository.classes;

import com.example.geektrust.database.table.EmployeeTable;
import com.example.geektrust.entities.Employee;
import com.example.geektrust.repository.interfaces.IEmployeeRepository;

public class EmployeeRepository implements IEmployeeRepository {

    private  static EmployeeTable employeeTable= new EmployeeTable();
    @Override
    public Employee upsertEmployee(Employee employee) {
        return employeeTable.addEmployee(employee.getRegistration_no(),employee);
    }

    @Override
    public Employee getEmployeeByRegistrationId(String registrationId) {
        return employeeTable.getEmployeeById(registrationId);
    }

}
