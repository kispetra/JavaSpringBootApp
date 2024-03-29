package com.example.task1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientRequestDto {
    private String firstName;
    private String lastName;
    private String oib;
    private String city;
    private String street;
    private int zipCode;
    private String country;
    private String number;

}
