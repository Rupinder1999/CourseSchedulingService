package com.example.geektrust.repository.classes;

import com.example.geektrust.database.table.EmployeeRegistrationTable;
import com.example.geektrust.entities.EmployeeRegistration;
import com.example.geektrust.repository.interfaces.IEmployeeRegistrationRepository;

public class EmployeeRegistrationRepository implements IEmployeeRegistrationRepository {

    private  static EmployeeRegistrationTable employeeRegistrationTable = new EmployeeRegistrationTable();
    @Override
    public EmployeeRegistration upsertEmployeeRegistration(EmployeeRegistration employeeRegistration) {
        return employeeRegistrationTable.addEmployeeRegistration(employeeRegistration.getRegistration_no(), employeeRegistration);
    }

    @Override
    public EmployeeRegistration getEmployeeByRegistrationId(String registrationId) {
        return employeeRegistrationTable.getEmployeeRegistrationById(registrationId);
    }

    @Override
    public EmployeeRegistration removeEmployeeRegistration(EmployeeRegistration employeeRegistration) {
      employeeRegistration=
              employeeRegistrationTable.removeEmployeeRegistration(employeeRegistration);
      return employeeRegistration;
    }

}
