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
        clientTest.setNumber(client.getNumber());

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
            responseClient.setNumber(client.getNumber());

            allClients.add(responseClient);
        }
        return allClients;
    }
    @Override
    public Client fetchClientById(Long id){
        Client client= clientRepository.findById(id).get();
        Client fClient= new Client();

        fClient.setId(client.getId());
        fClient.setFirstName(client.getFirstName());
        fClient.setLastName(client.getLastName());
        fClient.setOib(client.getOib());
        fClient.setCity(client.getCity());
        fClient.setStreet(client.getStreet());
        fClient.setZipCode(client.getZipCode());
        fClient.setCountry(client.getCountry());
        fClient.setNumber(client.getNumber());

        return fClient;
    }
     @Override
    public void deleteById(Long id){
         clientRepository.deleteById(id);
    }

    @Override
    public Client updateById(Long id, Client client){
        Client fclient = clientRepository.findById(id).get();

        fclient.setFirstName(client.getFirstName());
        fclient.setLastName(client.getLastName());
        fclient.setOib(client.getOib());
        fclient.setCity(client.getCity());
        fclient.setStreet(client.getStreet());
        fclient.setZipCode(client.getZipCode());
        fclient.setCountry(client.getCountry());
        fclient.setNumber(client.getNumber());

        return clientRepository.save(fclient);
    }

}
