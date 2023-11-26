package com.example.geektrust.dao.impl;

import com.example.geektrust.dao.interfaces.ICourseDao;
import com.example.geektrust.entities.Course;
import com.example.geektrust.repository.classes.CourseRepository;

public class CourseDao implements ICourseDao {

    private static CourseRepository courseRepository=new CourseRepository();

    @Override
    public Course addCourse(Course course) {
        courseRepository.addCourseOffering(course);
        return  course;
    }

    @Override
    public Course getCourseByOfferingId(String offeringId) {
        return courseRepository.getCourseByOfferingId(offeringId);
    }
}
