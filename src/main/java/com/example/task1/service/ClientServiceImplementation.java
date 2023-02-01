package com.example.task1.service;

import com.example.task1.dto.ClientRequestDto;
import com.example.task1.dto.ClientResponseDto;
import com.example.task1.mapper.ClientDtoMapper;
import com.example.task1.model.Client;
import com.example.task1.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImplementation implements  ClientService{
    private  ClientRepository clientRepository;
    private ClientDtoMapper clientDtoMapper;
    public ClientServiceImplementation(ClientRepository clientRepository, ClientDtoMapper clientDtoMapper) {
        this.clientRepository = clientRepository;
        this.clientDtoMapper=clientDtoMapper;
    }
    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto){

        Client client = clientDtoMapper.toEntity(clientRequestDto);
        Client savedClient = clientRepository.save(client);
        ClientResponseDto clientResponseDto=clientDtoMapper.toDto(savedClient);

        return clientResponseDto;
    }
    @Override
    public List<ClientResponseDto> fetchAll(){

        List<Client> clients= clientRepository.findAll();
        List<ClientResponseDto> allClients= new ArrayList<>();

        for(Client client: clients){
            ClientResponseDto clientResponseDto=clientDtoMapper.toDto(client);
            allClients.add(clientResponseDto);
        }
        return allClients;
    }
    @Override
    public ClientResponseDto fetchClientById(Long id){
        Client client= clientRepository.findById(id).get();
        ClientResponseDto clientResponseDto = clientDtoMapper.toDto(client);
        return clientResponseDto;
    }
     @Override
    public void deleteById(Long id){
         clientRepository.deleteById(id);
    }

    @Override
    public ClientResponseDto updateById(Long id, ClientRequestDto clientRequestDto){
        Client client = clientDtoMapper.toEntity(id, clientRequestDto);
        Client savedClient = clientRepository.save(client);
        ClientResponseDto clientResponseDto= clientDtoMapper.toDto(savedClient);
        return clientResponseDto;
    }

}
