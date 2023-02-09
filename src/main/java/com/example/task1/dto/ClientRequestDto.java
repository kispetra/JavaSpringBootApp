package com.example.task1.dto;

import com.example.task1.model.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ClientRequestDto {
    // TODO ne treba id u requestu
    public String id;
    public String firstName;
    public String lastName;
    public String oib;
    public String city;
    public String street;
    public int zipCode;
    public String country;
    public String number;

    // TODO cars ne smije biti ovdje, nigdje ne piše da trebaš slati listu auta u requestu
    public List<Car> cars;
}
