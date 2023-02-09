package com.example.task1.service;

import com.example.task1.dto.ClientRequestDto;
import com.example.task1.dto.ClientResponseDto;
import com.example.task1.mapper.ClientDtoMapper;
import com.example.task1.model.Client;
import com.example.task1.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements  ClientService{
    private final ClientRepository clientRepository;
    private final ClientDtoMapper clientDtoMapper;
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
        Client client= clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("client not found"));
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
