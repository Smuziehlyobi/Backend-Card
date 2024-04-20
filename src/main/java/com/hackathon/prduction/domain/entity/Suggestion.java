package com.hackathon.prduction.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "suggestions")
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "header")
    private String header;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "suggestions", fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JsonIgnore
    private Set<User> users = new HashSet<>();
}
