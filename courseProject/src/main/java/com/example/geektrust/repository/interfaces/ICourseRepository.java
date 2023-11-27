package com.example.geektrust.repository.interfaces;

import com.example.geektrust.entities.CourseOffering;

public interface ICourseRepository {
    public CourseOffering addCourseOffering(CourseOffering courseOffering);
    public CourseOffering cancelCourseOffering(CourseOffering courseOffering);
    public CourseOffering getCourseByOfferingId(String courseOfferingId);
}
