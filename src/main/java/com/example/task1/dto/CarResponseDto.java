package com.example.task1.dto;

import com.example.task1.model.CarType;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class CarResponseDto {
    private Long clientId;
    public CarType cartype;
    public Integer year;
    public String registrationmark;
    public String color;

}
