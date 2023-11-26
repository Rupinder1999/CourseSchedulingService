package com.example.geektrust.repository.interfaces;

import com.example.geektrust.entities.Course;

public interface ICourseRepository {
    public Course addCourseOffering(Course course);
    public Course cancelCourseOffering(Course course);
    public Course getCourseByOfferingId(String courseOfferingId);
}
