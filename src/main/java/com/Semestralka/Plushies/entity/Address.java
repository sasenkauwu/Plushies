package com.Semestralka.Plushies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "address")
@Getter
@Setter
@RequiredArgsConstructor
public class Address {

        @Id
        private UUID id;

        @OneToOne
        @MapsId
        @JoinColumn(name = "pouzivatel_id")
        @JsonIgnore
        private User user;

        private String street;
        private String city;
        private String zipCode;
        private String country;
}
