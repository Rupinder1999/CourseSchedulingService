package com.example.geektrust.repository.classes;

import com.example.geektrust.database.table.EmployeeCourseTable;
import com.example.geektrust.entities.Employee;
import com.example.geektrust.repository.interfaces.IEmployeeCourseRepository;

import java.util.List;

public class EmployeeCourseRepository implements IEmployeeCourseRepository {
    private static EmployeeCourseTable employeeCourseTable = new EmployeeCourseTable();
    @Override
    public void saveEmployeeByCourseOffering(Employee employee, String courseOfferingId) {
        employeeCourseTable.addEmployeeByCourseOfferingAdd(employee,courseOfferingId);
    }

    @Override
    public List<Employee> getEmployeesByCourseOffering(String courseOfferingId) {
        return employeeCourseTable.getEmployeeByCourseOfferingId(courseOfferingId);
    }
}
