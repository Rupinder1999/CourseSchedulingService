package com.example.geektrust.database.table;

import com.example.geektrust.entities.EmployeeRegistration;

import java.util.HashMap;

public class EmployeeRegistrationTable {
    private  static HashMap<String, EmployeeRegistration> storage=new HashMap<>();
    public EmployeeRegistration addEmployeeRegistration(String primaryKey,
                                                        EmployeeRegistration employeeRegistration){
        storage.put(primaryKey, employeeRegistration);
        //System.out.println(storage);
        return storage.get(primaryKey);
    }

    public EmployeeRegistration getEmployeeRegistrationById(String registrationId){
        EmployeeRegistration employeeRegistration =storage.get(registrationId);
      //  System.out.println(employeeRegistration);
        return employeeRegistration;
    }

    public EmployeeRegistration removeEmployeeRegistration(EmployeeRegistration registration){
      EmployeeRegistration employeeRegistration=  storage.remove(registration.getRegistration_no());
      return employeeRegistration;
    }
}
