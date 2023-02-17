package com.example.task1.service;

import com.example.task1.dto.CarServiceRequestDto;
import com.example.task1.dto.CarServiceResponseDto;
import com.example.task1.dto.ClientResponseDto;

public interface CarServiceService {
    ClientResponseDto save(Long clientId, Long carId, CarServiceRequestDto carServiceRequestDto);
    void delete(Long clientId, Long carId, Long carServiceId);
    CarServiceResponseDto updateById(Long clientId, Long carId, Long carServiceId, CarServiceRequestDto carServiceRequestDto);
}
