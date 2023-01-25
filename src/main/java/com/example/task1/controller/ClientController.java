package com.example.task1.controller;

import com.example.task1.dto.ResponseBodyAllClients;
import com.example.task1.model.Client;
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
    public Client save(@RequestBody Client client){
            return clientService.save(client);
    }

    @GetMapping("/api/customers")
    public List<ResponseBodyAllClients> findAll(){return clientService.fetchAll();}
    @GetMapping("/api/customers/{id}")
    public Client fetchClientById(@PathVariable ("id") Long id){
        return clientService.fetchClientById(id);
    }
    @DeleteMapping("/api/customers/delete/{id}")
    public void deleteById (@PathVariable("id") Long id){
    }
}
