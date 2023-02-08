package com.example.task1.mapper;

import com.example.task1.dto.CarResponseDto;
import com.example.task1.dto.ClientRequestDto;
import com.example.task1.dto.ClientResponseDto;
import com.example.task1.model.Car;
import com.example.task1.model.Client;
import com.example.task1.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientDtoMapper {
    private final ClientRepository clientRepository;
    public final CarDtoMapper carDtoMapper;

    public ClientResponseDto toDto(Client client){

        ClientResponseDto clientResponseDto= new ClientResponseDto();

        clientResponseDto.setFirstName(client.getFirstName());
        clientResponseDto.setLastName(client.getLastName());
        clientResponseDto.setOib(client.getOib());
        clientResponseDto.setCity(client.getCity());
        clientResponseDto.setStreet(client.getStreet());
        clientResponseDto.setZipCode(client.getZipCode());
        clientResponseDto.setCountry(client.getCountry());
        clientResponseDto.setNumber(client.getNumber());

        List<CarResponseDto> cars = new ArrayList<>();
        for(Car car : client.getCars()){
            CarResponseDto carResponseDto = carDtoMapper.toDto(car);
            cars.add(carResponseDto);
        }
        clientResponseDto.setCars(cars);

        return clientResponseDto;
    }

    public Client toEntity(ClientRequestDto clientRequestDto){

        Client client= new Client();

        client.setFirstName(clientRequestDto.getFirstName());
        client.setLastName(clientRequestDto.getLastName());
        client.setOib(clientRequestDto.getOib());
        client.setCity(clientRequestDto.getCity());
        client.setStreet(clientRequestDto.getStreet());
        client.setZipCode(clientRequestDto.getZipCode());
        client.setCountry(clientRequestDto.getCountry());
        client.setNumber(clientRequestDto.getNumber());

        return client;
    }

    public Client toEntity(Long id, ClientRequestDto clientRequestDto){

        Client client = clientRepository.findById(id).get();

        client.setFirstName(clientRequestDto.getFirstName());
        client.setLastName(clientRequestDto.getLastName());
        client.setOib(clientRequestDto.getOib());
        client.setCity(clientRequestDto.getCity());
        client.setStreet(clientRequestDto.getStreet());
        client.setZipCode(clientRequestDto.getZipCode());
        client.setCountry(clientRequestDto.getCountry());
        client.setNumber(clientRequestDto.getNumber());

        return client;
    }

}
