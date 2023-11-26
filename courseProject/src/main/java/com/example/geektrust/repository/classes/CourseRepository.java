package com.example.geektrust.repository.classes;

import com.example.geektrust.database.table.CourseTable;
import com.example.geektrust.entities.Course;
import com.example.geektrust.repository.interfaces.ICourseRepository;

public class CourseRepository implements ICourseRepository {

    private static CourseTable courseTable=new CourseTable();
    @Override
    public Course addCourseOffering(Course course) {
        courseTable.addCourse(course.getCourseOfferingId(),course);
        return course;
    }

    @Override
    public Course cancelCourseOffering(Course course) {
        return null;
    }

    @Override
    public Course getCourseByOfferingId(String courseOfferingId) {
        return  courseTable.getCourseById(courseOfferingId);
    }
}
