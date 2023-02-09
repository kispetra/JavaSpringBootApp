package com.example.task1.controller;

import com.example.task1.dto.ClientRequestDto;
import com.example.task1.dto.ClientResponseDto;
import com.example.task1.mapper.ClientDtoMapper;
import com.example.task1.repository.ClientRepository;
import com.example.task1.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    // TODO izbrisati
    private final ClientRepository clientRepository;

    // TODO izbrisati
    private final ClientDtoMapper clientDtoMapper;

    @PostMapping("/api/customers")
    public ClientResponseDto save(@RequestBody ClientRequestDto clientRequestDto){
            return clientService.save(clientRequestDto);}

    @GetMapping("/api/customers")
    public Page<ClientResponseDto> findAll(@RequestParam( value="firstName", required = false) String firstName,
                                           @RequestParam( value="lastName", required = false) String lastName,
                                           Pageable pageable)
    {
        return clientService.fetchAll(firstName, lastName, pageable);
    }


    @GetMapping("/api/customers/{id}")
    public ClientResponseDto fetchClientById(@PathVariable ("id") Long id){
        return clientService.fetchClientById(id);}

    @DeleteMapping("/api/customers/delete/{id}")
    public void deleteById (@PathVariable("id") Long id) {
        clientService.deleteById(id);}

    @PutMapping("/api/customers/{id}")
    public ClientResponseDto updateById(@PathVariable("id") Long id, @RequestBody ClientRequestDto clientRequestDto){
        return clientService.updateById(id,clientRequestDto);}

}
