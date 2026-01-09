package com.example.tp1_spring.service;

import com.example.tp1_spring.data.Client;
import com.example.tp1_spring.data.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(String email, String password, String nom, String prenom){
        var client = new Client(email, password, nom, prenom);
        clientRepository.save(client);
    }
}
