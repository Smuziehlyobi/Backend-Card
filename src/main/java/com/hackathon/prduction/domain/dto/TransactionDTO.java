package com.hackathon.prduction.domain.dto;

import com.hackathon.prduction.domain.models.User;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionDTO {
    private String name;

    private Integer value;

    private Timestamp time;

    private User user;
}
