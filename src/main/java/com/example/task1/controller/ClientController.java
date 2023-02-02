package com.example.task1.controller;

import com.example.task1.dto.ClientRequestDto;
import com.example.task1.dto.ClientResponseDto;
import com.example.task1.mapper.ClientDtoMapper;
import com.example.task1.repository.ClientRepository;
import com.example.task1.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClientController {
    private ClientService clientService;
    private final ClientRepository clientRepository;


    public ClientController(ClientService clientService,
                            ClientRepository clientRepository,
                            ClientDtoMapper clientDtoMapper) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;

    }

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
