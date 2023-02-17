package com.example.task1.service;
import com.example.task1.dto.CarServiceRequestDto;
import com.example.task1.dto.ClientResponseDto;
import com.example.task1.mapper.CarServiceDtoMapper;
import com.example.task1.mapper.ClientDtoMapper;
import com.example.task1.model.Car;
import com.example.task1.model.CarService;
import com.example.task1.model.Client;
import com.example.task1.repository.CarRepository;
import com.example.task1.repository.CarServiceRepository;
import com.example.task1.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CarServiceServiceImpl implements CarServiceService{
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final CarServiceDtoMapper carServiceDtoMapper;
    private final CarServiceRepository carServiceRepository;
    private final ClientDtoMapper clientDtoMapper;

    @Override
    public ClientResponseDto save(Long clientId, Long carId, CarServiceRequestDto carServiceRequestDto) {
        Client client= clientRepository.findById(clientId).orElseThrow(()-> new EntityNotFoundException("Client not found."));
        Car car= carRepository.findById(carId).orElseThrow(()-> new EntityNotFoundException("Car not found."));

        CarService carService = carServiceDtoMapper.toEntity(carId, carServiceRequestDto);
        carServiceRepository.save(carService);

        ClientResponseDto clientResponseDto= clientDtoMapper.toDto(client);
        return clientResponseDto;
    }
    @Override
    public void delete(Long clientId, Long carId, Long carServiceId){
        Client client= clientRepository.findById(clientId).orElseThrow(()-> new EntityNotFoundException("Client not found."));
        Car car= carRepository.findById(carId).orElseThrow(()-> new EntityNotFoundException("Car not found."));
        CarService carService=carServiceRepository.findById(carServiceId).orElseThrow(()-> new EntityNotFoundException("Car service not found."));

        carServiceRepository.delete(carService);
        car.getCarServices().remove(carService);
    }
}
