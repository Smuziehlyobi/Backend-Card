package com.hackathon.prduction.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class EventDTO {
    private String name;

    private Timestamp timeStart;

//    private Category category;
//
//    private AgeCategory ageCategoryEntity;
}
