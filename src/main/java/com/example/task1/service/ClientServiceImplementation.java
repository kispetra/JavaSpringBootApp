package com.example.task1.service;

import com.example.task1.model.Client;
import com.example.task1.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImplementation implements  ClientService{
    private ClientRepository clientRepository;
    public ClientServiceImplementation(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public Client save(Client client){

        Client clientTest = new Client();

        clientTest.setFirstName(client.getFirstName());
        clientTest.setLastName(client.getLastName());
        clientTest.setOib(client.getOib());
        clientTest.setCity(client.getCity());
        clientTest.setStreet(client.getStreet());
        clientTest.setZipCode(client.getZipCode());
        clientTest.setCountry(client.getCountry());

        Client savedClient = clientRepository.save(clientTest);

        return savedClient;
    }

}
