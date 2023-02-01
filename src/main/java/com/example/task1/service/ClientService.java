package com.example.task1.service;

import com.example.task1.dto.ClientRequestDto;
import com.example.task1.dto.ClientResponseDto;

import java.util.List;

public interface ClientService {
    ClientResponseDto save(ClientRequestDto clientRequestDto);

    List<ClientResponseDto> fetchAll();

    ClientResponseDto fetchClientById(Long id);
    void deleteById(Long id);

    ClientResponseDto updateById(Long id, ClientRequestDto clientRequestDto);



}
