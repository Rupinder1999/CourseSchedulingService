package com.example.geektrust.model.command;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddOfferingCommand {
    private String courseTitle;
    private String  instructor;
    private String  date ;
    private Integer  minEmployee;
    private Integer  maxEmployee;
}
