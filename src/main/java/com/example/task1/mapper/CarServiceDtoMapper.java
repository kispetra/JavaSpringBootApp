package com.example.task1.mapper;

import com.example.task1.dto.CarServiceRequestDto;
import com.example.task1.dto.CarServiceResponseDto;
import com.example.task1.model.Car;
import com.example.task1.model.CarService;
import com.example.task1.repository.CarRepository;
import com.example.task1.repository.CarServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CarServiceDtoMapper {
    private final CarRepository carRepository;
    private final CarServiceRepository carServiceRepository;

    public CarService toEntity(Long  carId, CarServiceRequestDto carServiceRequestDto){
        CarService carService= new CarService();

        Car car = carRepository.findById(carId).orElseThrow(() -> new EntityNotFoundException("Car not found"));
        carService.setCar(car);

        carService.setDateOfService(carServiceRequestDto.getDateOfService());
        carService.setWorkerFirstName(carServiceRequestDto.getWorkerFirstName());
        carService.setWorkerLastName(carServiceRequestDto.getWorkerLastName());
        carService.setWorkDescription(carServiceRequestDto.getWorkDescription());
        carService.setPrice(carServiceRequestDto.getPrice());
        carService.setIsPaid(carServiceRequestDto.getIsPaid());

        return  carService;
    }
    public CarService toEntity(Long carId, Long carServiceId, CarServiceRequestDto carServiceRequestDto){
        CarService carService= carServiceRepository.findById(carServiceId).orElseThrow(()-> new EntityNotFoundException("Car service not found."));
        Car car = carRepository.findById(carId).orElseThrow(() -> new EntityNotFoundException("Car not found."));
        carService.setCar(car);

        carService.setDateOfService(carServiceRequestDto.getDateOfService());
        carService.setWorkerFirstName(carServiceRequestDto.getWorkerFirstName());
        carService.setWorkerLastName(carServiceRequestDto.getWorkerLastName());
        carService.setWorkDescription(carServiceRequestDto.getWorkDescription());
        carService.setPrice(carServiceRequestDto.getPrice());
        carService.setIsPaid(carServiceRequestDto.getIsPaid());

        return carService;
    }

    public CarServiceResponseDto toDto(CarService carService){
        CarServiceResponseDto carServiceResponseDto=new CarServiceResponseDto();

        carServiceResponseDto.setDateOfService(carService.getDateOfService());
        carServiceResponseDto.setWorkerFirstName(carService.getWorkerFirstName());
        carServiceResponseDto.setWorkerLastName(carService.getWorkerLastName());
        carServiceResponseDto.setWorkDescription(carService.getWorkDescription());
        carServiceResponseDto.setPrice(carService.getPrice());
        carServiceResponseDto.setIsPaid(carService.getIsPaid());

        return carServiceResponseDto;
    }
}
