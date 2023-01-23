package com.example.task1.controller;

import com.example.task1.Client.Client;
import com.example.task1.clientService.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
