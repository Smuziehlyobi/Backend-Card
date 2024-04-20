package com.hackathon.prduction.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathon.prduction.domain.entity.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import com.hackathon.prduction.domain.entity.Transaction;
import lombok.Data;

import java.util.List;

@Data

public class UserDTO {

    private String firstName;

    private String lastName;

    private String patronymic;

    private String password;

    private String email;

    private List<Transaction> transactions;

    private List<Role> roles;
}
