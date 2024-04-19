package com.hackathon.prduction.domain.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")


public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "First_name")
    private String firstName;

    @Column(name = "Last_name")
    private String lastName;

    @Column(name = "Patronimic")
    private String patronimic;

    @ManyToOne
    @JoinColumn(name = "role")
    private RoleEntity role;

    @OneToMany( mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true)
    @JsonIgnore
    private List<TransactionEntity> transactions;

    @OneToMany( mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true)
    @JsonIgnore
    private List<RoleEntity> roles;
}
