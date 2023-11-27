package com.example.geektrust;

import com.example.geektrust.services.CourseSchedulingService;
import com.example.geektrust.validator.BasicCommandValidator;

public class Main {
    public static void main(String[] args) {
        String path="/Users/rupindersingh/Downloads/Projects/java-maven-starter-kit/sample_input/input2.txt";
        path=args.length>0?args[0]:path;
        BasicCommandValidator basicCommandValidator=new BasicCommandValidator();
        CourseSchedulingService courseSchedulingService=
                new CourseSchedulingService(basicCommandValidator);
        courseSchedulingService.start(path);
    }
}
