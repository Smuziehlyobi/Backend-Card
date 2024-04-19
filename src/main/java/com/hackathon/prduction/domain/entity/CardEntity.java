package com.hackathon.prduction.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "cards")

public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private String value;

    @Column(name = "balance")
    private Long balance;
}
