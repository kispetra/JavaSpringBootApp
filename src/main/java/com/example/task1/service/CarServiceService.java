package com.example.task1.service;

import com.example.task1.dto.*;

public interface CarServiceService {
    ClientResponseDto save(Long clientId, Long carId, CarServiceRequestDto carServiceRequestDto);
    void delete(Long clientId, Long carId, Long carServiceId);
    CarServiceResponseDto updateById(Long clientId, Long carId, Long carServiceId, CarServiceRequestDto carServiceRequestDto);
    IsPaidCarServiceResponseDto updateIsPaid(Long clientId, Long carId, Long carServiceId,
                                             IsPaidCarServiceRequestDto isPaidCarServiceRequestDto);
}
