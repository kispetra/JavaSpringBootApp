package com.example.task1.service;

import com.example.task1.dto.CarRequestDto;
import com.example.task1.dto.CarResponseDto;
import com.example.task1.dto.ClientResponseDto;
import com.example.task1.mapper.CarDtoMapper;
import com.example.task1.mapper.ClientDtoMapper;
import com.example.task1.model.Car;
import com.example.task1.model.Client;
import com.example.task1.repository.CarRepository;
import com.example.task1.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{

    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final CarDtoMapper carDtoMapper;
    private final ClientDtoMapper clientDtoMapper;
    @Override
    public ClientResponseDto save(Long id, CarRequestDto carRequestDto){

        Client client= clientRepository.findById(id).orElse(null);

        Car car= carDtoMapper.toEntity(carRequestDto);
        car.setClient(client);
        Car savedCar= carRepository.save(car);

        ClientResponseDto clientResponseDto= clientDtoMapper.toDto(client);

        return clientResponseDto;
    }
    public void deleteById(Long clientId, Long carId){
        Car car = carRepository.findById(carId).orElse(null);
        Client client=clientRepository.findById(clientId).orElse(null);
        carRepository.delete(car);
        client.getCars().remove(car);
    }
    public CarResponseDto updateById(Long clientId, Long carId, CarRequestDto carRequestDto){
        Client client= clientRepository.findById(clientId).orElse(null);
        Car car= carRepository.findById(carId).orElse(null);
        client.getCars().remove(car);

        car= carDtoMapper.toEntity(carId,carRequestDto);
        Car savedCar=carRepository.save(car);
        client.getCars().add(savedCar);

        CarResponseDto carResponseDto= carDtoMapper.toDto(savedCar);
        return  carResponseDto;

    }

}
