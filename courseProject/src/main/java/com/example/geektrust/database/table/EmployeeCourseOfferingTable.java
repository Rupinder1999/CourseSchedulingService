package com.example.geektrust.database.table;

import com.example.geektrust.database.schema.EmployeeToCoursePair;
import com.example.geektrust.entities.EmployeeRegistration;

import java.util.*;

public class EmployeeCourseOfferingTable {
    private static List<EmployeeToCoursePair> employeeToCoursePairList;
   private static Map<String, SortedSet<String>> courseOfferingToEmployee = new HashMap<>();

   private static  EmployeeRegistrationTable employeeRegistrationTable =
           new EmployeeRegistrationTable();

    public void addEmployeeByCourseOfferingAdd(String registrationId , String courseOfferingId){
        SortedSet<String> employeesIdsSet= courseOfferingToEmployee.getOrDefault(courseOfferingId,
                new TreeSet<>());
        employeesIdsSet.add(registrationId);
        courseOfferingToEmployee.put(courseOfferingId,employeesIdsSet);
    }

    //To move this to join level thing
    public List<EmployeeRegistration> getEmployeeByCourseOfferingId(String courseOfferingId){

        SortedSet<String> employeeIdSet= courseOfferingToEmployee.get(courseOfferingId);
        List<EmployeeRegistration> employeeRegistrationList = new ArrayList<>();
        for(String registrationNo :employeeIdSet){
            EmployeeRegistration employeeRegistration =
                    employeeRegistrationTable.getEmployeeRegistrationById(registrationNo);
            employeeRegistrationList.add(employeeRegistration);
        }
        return employeeRegistrationList;
    }

    public SortedSet<String> getEmployeesIdsByCourseOffering(String courseOfferingId){
        SortedSet<String> employeeIdSet= courseOfferingToEmployee.get(courseOfferingId);
        return  employeeIdSet;
    }

    public void setCourseOfferingToEmployee(String courseOfferingId){
        courseOfferingToEmployee.put(courseOfferingId,new TreeSet<>());
    }

    public void removeRegistrationFromCourseOffering(String courseOfferingId,String registrationNo){
       SortedSet<String> employeeIdSet =  courseOfferingToEmployee.get(courseOfferingId);
       employeeIdSet.remove(registrationNo);
    }
}
