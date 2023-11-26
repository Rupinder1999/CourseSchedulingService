package com.example.geektrust.database.table;

import com.example.geektrust.database.schema.EmployeeToCoursePair;
import com.example.geektrust.entities.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeCourseTable {
    private static List<EmployeeToCoursePair> employeeToCoursePairList;
   private static Map<String,List<Employee>> courseOfferingToEmployee = new HashMap<>();

    public void addEmployeeByCourseOfferingAdd(Employee employee , String courseOfferingId){
        List<Employee> employees = courseOfferingToEmployee.getOrDefault(courseOfferingId,new ArrayList<>());
        employees.add(employee);
        courseOfferingToEmployee.put(courseOfferingId,employees);
    }

    public List<Employee> getEmployeeByCourseOfferingId(String courseOfferingId){
        return  courseOfferingToEmployee.get(courseOfferingId);
    }
}
