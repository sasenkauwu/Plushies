package com.Semestralka.Plushies.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@RequiredArgsConstructor
@Getter
@Setter
public class UserRegistrationSaveRequest {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    //private LocalDate dateOfBirth;
    private String username;
    private String password;
    private String street;
    private String city;
    private String zipCode;
    private String country;
}
