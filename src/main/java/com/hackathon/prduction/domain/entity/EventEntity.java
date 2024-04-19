package com.hackathon.prduction.domain.entity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "events")

public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "time_start")
    private Timestamp timeStart;

    @ManyToOne
    @JoinColumn(name = "category")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "age_category")
    private AgeCategoryEntity ageCategoryEntity;
}
