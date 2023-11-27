package com.example.geektrust.dao.interfaces;

import com.example.geektrust.entities.CourseOffering;

public interface ICourseOfferingDao {
    public CourseOffering addCourse(CourseOffering courseOffering);
    public CourseOffering getCourseByOfferingId(String offeringId);
}
