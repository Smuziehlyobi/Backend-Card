package com.hackathon.prduction.domain.entity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "transactions")

public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Integer value;

    @Column(name = "time")
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;
}
