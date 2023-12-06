package com.Semestralka.Plushies.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class AddressSaveRequest {
    private String street;
    private String city;
    private String zipCode;
    private String country;
}
