package com.example.tp1_spring.service;

import com.example.tp1_spring.data.Client;
import com.example.tp1_spring.data.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(String email, String password, String nom, String prenom){
        var client = new Client(email, password, nom, prenom);
        clientRepository.save(client);
    }

    public Client connexionClient(String email, String password){
        Client client = clientRepository.findByEmail(email);
        if(client != null  && client.getPassword().equals(password)){
            return client;
        }
        return null;
    }

}
