package com.Semestralka.Plushies.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
public class UserSaveRequest {
    private String name;
    private String surname;
    //private LocalDate dateOfBirth;  //dorobit v bootstrape frontend
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
