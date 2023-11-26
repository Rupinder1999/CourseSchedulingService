package com.example.geektrust.model.command;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AllotCommand {
    private String courseOfferingId;
}
