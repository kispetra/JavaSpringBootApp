package com.example.task1.service;

import com.example.task1.dto.ClientRequestDto;
import com.example.task1.dto.ClientResponseDto;
import com.example.task1.mapper.ClientDtoMapper;
import com.example.task1.model.Client;
import com.example.task1.repository.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<ClientResponseDto> fetchAll(String firstName, String lastName, Pageable pageable){

        return clientRepository.findingByNameOrLastNameASC(firstName,lastName, pageable)
                .map(clientDtoMapper:: toDto);
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
