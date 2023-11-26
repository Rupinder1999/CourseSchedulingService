package com.example.geektrust.dao.interfaces;

import com.example.geektrust.entities.Course;

public interface ICourseDao {
    public Course addCourse(Course course);
    public Course getCourseByOfferingId(String offeringId);
}
