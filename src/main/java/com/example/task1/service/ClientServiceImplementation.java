package com.example.task1.service;

import com.example.task1.dto.ResponseBodyAllClients;
import com.example.task1.model.Client;
import com.example.task1.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Override
    public List<ResponseBodyAllClients> fetchAll(){

        List<Client> clients= clientRepository.findAll();
        List<ResponseBodyAllClients> allClients= new ArrayList<>();

        for(Client client: clients){
            ResponseBodyAllClients responseClient= new ResponseBodyAllClients();

            responseClient.setFirstName(client.getFirstName());
            responseClient.setLastName(client.getLastName());
            responseClient.setOib(client.getOib());
            responseClient.setCity(client.getCity());
            responseClient.setStreet(client.getStreet());
            responseClient.setZipCode(client.getZipCode());
            responseClient.setCountry(client.getCountry());

            allClients.add(responseClient);
        }
        return allClients;
    }

}
