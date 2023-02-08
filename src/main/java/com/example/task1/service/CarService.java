package com.example.task1.service;

import com.example.task1.dto.CarRequestDto;
import com.example.task1.dto.ClientResponseDto;


public interface CarService {
    ClientResponseDto save(Long id, CarRequestDto carRequestDto);
    void deleteById(Long clientId, Long carId);


}
