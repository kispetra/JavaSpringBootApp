package com.example.task1.service;

import com.example.task1.dto.ClientRequestDto;
import com.example.task1.dto.ClientResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    ClientResponseDto save(ClientRequestDto clientRequestDto);

    Page<ClientResponseDto> fetchAll(String firstName, String lastName, Pageable pageable);

    ClientResponseDto fetchClientById(Long id);
    void deleteById(Long id);

    ClientResponseDto updateById(Long id, ClientRequestDto clientRequestDto);



}
