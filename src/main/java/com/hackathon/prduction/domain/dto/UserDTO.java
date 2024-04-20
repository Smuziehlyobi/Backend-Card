package com.hackathon.prduction.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathon.prduction.domain.models.Role;
import com.hackathon.prduction.domain.entity.Transaction;
import lombok.Data;

import java.util.List;

@Data

public class UserDTO {

    private String firstName;

    private String lastName;

    private String patronymic;

    private Role role;

    @JsonIgnore
    private List<Transaction> transactions;

    @JsonIgnore
    private List<Role> roles;
}
