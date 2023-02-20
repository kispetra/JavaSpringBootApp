package com.example.task1.controller;

import com.example.task1.dto.*;
import com.example.task1.service.CarServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CarServiceController {
    private final CarServiceService carServiceService;
    @PostMapping("/api/customers/{clientId}/cars/{carId}/car-services")
    public ClientResponseDto save(@PathVariable Long clientId, @PathVariable Long carId,
                                  @RequestBody CarServiceRequestDto carServiceRequestDto){
        return carServiceService.save(clientId, carId, carServiceRequestDto);
    }
    @DeleteMapping("/api/customers/{clientId}/cars/{carId}/car-services/{carServiceId}")
    public void delete(@PathVariable Long clientId, @PathVariable Long carId, @PathVariable Long carServiceId){
        carServiceService.delete(clientId, carId, carServiceId);
    }
    @PutMapping("/api/customers/{clientId}/cars/{carId}/car-services/{carServiceId}")
    public CarServiceResponseDto update(@PathVariable Long clientId,@PathVariable Long carId,
                                        @PathVariable Long carServiceId, @RequestBody CarServiceRequestDto carServiceRequestDto){
        return carServiceService.updateById(clientId, carId, carServiceId, carServiceRequestDto);
    }
    @PutMapping("/api/customers/{clientId}/cars/{carId}/car-services/{carServiceId}/is-paid")
    public IsPaidCarServiceResponseDto updateIsPaid(@PathVariable Long clientId, @PathVariable Long carId,
                                                    @PathVariable Long carServiceId,
                                                    @RequestBody IsPaidCarServiceRequestDto isPaidCarServiceRequestDto){
        return carServiceService.updateIsPaid(clientId, carId, carServiceId, isPaidCarServiceRequestDto);

    }

}
