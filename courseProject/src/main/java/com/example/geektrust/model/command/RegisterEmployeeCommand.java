package com.example.geektrust.model.command;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterEmployeeCommand {
    private  String offeringId;
    private String  email ;
}


