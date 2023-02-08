package com.example.task1.mapper;

import com.example.task1.dto.CarRequestDto;
import com.example.task1.dto.CarResponseDto;
import com.example.task1.model.Car;
import com.example.task1.model.CarType;
import com.example.task1.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarDtoMapper {

    private final CarRepository carRepository;

    public CarResponseDto toDto(Car car){

        CarResponseDto carResponseDto= new CarResponseDto();

        carResponseDto.setClientId(car.getClient().getId());
        carResponseDto.setCartype(car.getCarType());
        carResponseDto.setYear(car.getYear());
        carResponseDto.setRegistrationmark(car.getRegistrationMark());
        carResponseDto.setColor(car.getColor());

        return carResponseDto;
    }

    public Car toEntity(CarRequestDto carRequestDto){

        Car car= new Car();

        CarType carType = CarType.valueOf(carRequestDto.getCarType()); //from string to CarType(enum)
        car.setCarType(carType);
        car.setYear(carRequestDto.getYear());
        car.setRegistrationMark(carRequestDto.getRegistrationMark());
        car.setColor(carRequestDto.getColor());

        return car;
    }
    public Car toEntity(Long carId, CarRequestDto carRequestDto){

        Car car= carRepository.findById(carId).orElse(null);
        CarType carType = CarType.valueOf(carRequestDto.getCarType());
        car.setCarType(carType);
        car.setYear(carRequestDto.getYear());
        car.setRegistrationMark(carRequestDto.getRegistrationMark());
        car.setColor(carRequestDto.getColor());
        return car;
    }

}
