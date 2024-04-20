package com.hackathon.prduction.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events")

public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "time_start")
    private Timestamp timeStart;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_age_category")
    private AgeCategory ageCategory;

    @ManyToMany(mappedBy = "events", fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JsonIgnore
    private Set<User> users = new HashSet<>();
}
