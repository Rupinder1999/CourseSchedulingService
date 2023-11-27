package com.example.geektrust.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeRegistration {
    private  String registration_no;
    private  String name;
    private  String email ;
    private  String course_offering_id;
    private  String status;
    private   String    date;
}
