package com.hackathon.prduction.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "User")

public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany( mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true)
    @JsonIgnore
    private List<Transaction> transactions;


    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "User_suggestion",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_suggestion")
    )
    @JsonIgnore
<<<<<<< HEAD
        private List<Role> roles;
=======
    private Set<Suggestion> suggestions = new HashSet<>();

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "User_event",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_event")
    )
    @JsonIgnore
    private Set<Event> events = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;
>>>>>>> f0a5ea738ef12ace7737cf3a65ae91cf335ea61f
}
