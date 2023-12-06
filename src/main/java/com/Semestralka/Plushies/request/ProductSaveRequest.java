package com.Semestralka.Plushies.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@RequiredArgsConstructor
@Getter
@Setter
public class ProductSaveRequest {

    private String title;
    private double price;
    private String description;
    //private String imageURL;
}
