package com.example.geektrust.database.table;

import com.example.geektrust.entities.CourseOffering;

import java.util.HashMap;
import java.util.Map;

public class CourseOfferingTable {
   private static Map<String, CourseOffering> storage=new HashMap<>();

   private static EmployeeCourseOfferingTable employeeCourseOfferingTable =
           new EmployeeCourseOfferingTable();

    public void addCourse(String primaryKey, CourseOffering courseOffering){
        storage.put(primaryKey,courseOffering);
        employeeCourseOfferingTable.setCourseOfferingToEmployee(courseOffering.getCourseOfferingId());
        //System.out.println(storage);
    }

    public  CourseOffering getCourseById(String offeringId){
        CourseOffering courseOffering=storage.get(offeringId);
       // System.out.println(courseOffering);
       return courseOffering;
    }
}
