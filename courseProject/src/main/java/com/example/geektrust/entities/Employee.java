package com.example.geektrust.entities;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Employee {
    private  String registration_no;
    private  String name;
    private  String email ;
    private  String course_offering_id;
    private  String status;
    private   String    date;
}
