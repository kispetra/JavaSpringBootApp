package com.example.task1.controller;

import com.example.task1.dto.CarRequestDto;
import com.example.task1.dto.ClientResponseDto;
import com.example.task1.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CarController {
    private final CarService carService;
    @PostMapping("/api/customers/{id}/cars")
    public ClientResponseDto save(@PathVariable Long id,@RequestBody CarRequestDto carRequestDto) {
        return carService.save(id, carRequestDto);
    }
    @DeleteMapping("/api/customers/{clientId}/cars/{carId}")
    public void deleteCarById(@PathVariable Long clientId, @PathVariable Long carId){
        carService.deleteById(clientId, carId);
    }
}
