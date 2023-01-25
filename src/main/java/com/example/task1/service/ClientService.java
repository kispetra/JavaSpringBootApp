package com.example.task1.service;

import com.example.task1.dto.ResponseBodyAllClients;
import com.example.task1.model.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client);

    List<ResponseBodyAllClients> fetchAll();

    Client fetchClientById(Long id);
    void deleteById(Long id);

    Client updateById(Long id, Client client);
}
