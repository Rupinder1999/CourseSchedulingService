package com.example.geektrust.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CourseOffering {
    private String title;
    private String  instructor;
    private String date;
    private Integer minEmployees;

    private  Integer maxEmployees;
    private  String courseStatus;
    private  String courseOfferingId;
}
