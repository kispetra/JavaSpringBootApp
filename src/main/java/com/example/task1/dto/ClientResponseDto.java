package com.example.task1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ClientResponseDto {
    public String id;
    public String firstName;
    public String lastName;
    public String oib;
    public String city;
    public String street;
    public int zipCode;
    public String country;
    public String adressNumber;
    public List<CarResponseDto> cars;

}