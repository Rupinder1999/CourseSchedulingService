package com.example.geektrust.repository.classes;

import com.example.geektrust.database.table.CourseOfferingTable;
import com.example.geektrust.entities.CourseOffering;
import com.example.geektrust.repository.interfaces.ICourseRepository;

public class CourseRepository implements ICourseRepository {

    private static CourseOfferingTable courseOfferingTable =new CourseOfferingTable();
    @Override
    public CourseOffering addCourseOffering(CourseOffering course) {
        courseOfferingTable.addCourse(course.getCourseOfferingId(),course);
        return course;
    }

    @Override
    public CourseOffering cancelCourseOffering(CourseOffering courseOffering) {
        return null;
    }

    @Override
    public CourseOffering getCourseByOfferingId(String courseOfferingId) {
        return  courseOfferingTable.getCourseById(courseOfferingId);
    }
}
