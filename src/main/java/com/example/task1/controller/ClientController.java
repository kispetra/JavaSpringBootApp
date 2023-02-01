package com.example.task1.controller;

import com.example.task1.dto.ClientRequestDto;
import com.example.task1.dto.ClientResponseDto;
import com.example.task1.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/api/customers")
    public ClientResponseDto save(@RequestBody ClientRequestDto clientRequestDto){
            return clientService.save(clientRequestDto);}

    @GetMapping("/api/customers")
    public List<ClientResponseDto> findAll(){return clientService.fetchAll();}

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
