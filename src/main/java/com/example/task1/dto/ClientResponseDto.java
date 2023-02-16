package com.example.task1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ClientResponseDto {
    private String id;
    private String firstName;
    private String lastName;
    private String oib;
    private String city;
    private String street;
    private int zipCode;
    private String country;
    private String number;
    private List<CarResponseDto> cars;

}