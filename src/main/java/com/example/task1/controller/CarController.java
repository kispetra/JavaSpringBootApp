package com.example.task1.controller;

import com.example.task1.dto.CarRequestDto;
import com.example.task1.dto.ClientResponseDto;
import com.example.task1.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class CarController {
    private final CarService carService;
    @PostMapping("/api/customers/{id}/cars")
    public ClientResponseDto save(@PathVariable Long id,@RequestBody CarRequestDto carRequestDto) {
        return carService.save(id, carRequestDto);
    }
}
