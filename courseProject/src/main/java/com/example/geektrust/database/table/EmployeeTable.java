package com.example.geektrust.database.table;

import com.example.geektrust.entities.Course;
import com.example.geektrust.entities.Employee;

import java.util.HashMap;

public class EmployeeTable {
    HashMap<String, Employee> storage;
    public Employee addEmployee(String primaryKey, Employee employee){
        storage.put(primaryKey,employee);
        System.out.println(storage);
        return storage.get(primaryKey);
    }

    public  Employee getEmployeeById(String registrationId){
        Employee employee=storage.get(registrationId);
        System.out.println(employee);
        return employee;
    }
}
