package com.example.geektrust.database.table;

import com.example.geektrust.entities.Course;

import java.util.HashMap;
import java.util.Map;

public class CourseTable {
    Map<String, Course> storage=new HashMap<>();
    public void addCourse(String primaryKey,Course course){
        storage.put(primaryKey,course);
        System.out.println(storage);
    }

    public  Course getCourseById(String offeringId){
        Course course=storage.get(offeringId);
        System.out.println(course);
       return course;
    }
}
