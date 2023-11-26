package com.example.geektrust;

import com.example.geektrust.services.CourseSchedulingService;
import com.example.geektrust.validator.BasicCommandValidator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path="/Users/rupindersingh/Downloads/java-maven-starter-kit/sample_input/input2" +
                ".txt";
        path=args.length>0?args[0]:path;
        BasicCommandValidator basicCommandValidator=new BasicCommandValidator();
        CourseSchedulingService courseSchedulingService=
                new CourseSchedulingService(basicCommandValidator);
        courseSchedulingService.start(path);

    }
}
