package com.example.task1.dto;

import com.example.task1.model.CarType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CarResponseDto {
    private Long clientId;
    private CarType cartype;
    private Integer year;
    private String registrationmark;
    private String color;
    private List<CarServiceResponseDto> carServices;

}
