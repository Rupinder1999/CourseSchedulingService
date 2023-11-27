package com.example.geektrust.dao.impl;

import com.example.geektrust.dao.interfaces.ICourseOfferingDao;
import com.example.geektrust.entities.CourseOffering;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.repository.classes.CourseRepository;

import static com.example.geektrust.constant.ErrorType.INPUT_DATA_ERROR;

public class CourseOfferingOfferingDao implements ICourseOfferingDao {

    private static CourseRepository courseRepository=new CourseRepository();

    @Override
    public CourseOffering addCourse(CourseOffering courseOffering) {
        CourseOffering dbCourseOffering=
                courseRepository.getCourseByOfferingId(courseOffering.getCourseOfferingId());
        if(dbCourseOffering!=null)
            throw new InvalidInputException(INPUT_DATA_ERROR);
        courseRepository.addCourseOffering(courseOffering);
        return  courseOffering;
    }

    @Override
    public CourseOffering getCourseByOfferingId(String offeringId) {
        return courseRepository.getCourseByOfferingId(offeringId);
    }
}
