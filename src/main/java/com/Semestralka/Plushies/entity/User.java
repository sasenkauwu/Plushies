package com.Semestralka.Plushies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pouzivatel")
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JsonIgnore
    private Address address;

    private String name;
    private String surname;
    private LocalDate dateOfBirth;  //dorobit v bootstrape frontend
    private String username;
    private String password;

    @Column(unique = true)
    private String email;

    private String phoneNumber;
}
