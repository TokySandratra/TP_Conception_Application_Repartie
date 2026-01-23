package com.example.tp1_spring.service;

import com.example.tp1_spring.data.Commande;
import com.example.tp1_spring.data.LigneCommande;
import com.example.tp1_spring.data.LigneCommandeRepository;
import org.springframework.stereotype.Service;
import com.example.tp1_spring.data.CommandeRepository;

import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final LigneCommandeRepository ligneCommandeRepository;

    public CommandeService(CommandeRepository commandeRepository, LigneCommandeRepository ligneCommandeRepository) {
        this.commandeRepository = commandeRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    public List<Commande> getCommandeClient(String email){
        return commandeRepository.findByClientEmail(email);
    }

//    public void enregistrerCommande(String name, String clientEmail, LigneCommande ligneCommande){
//        ligneCommandeRepository.save(ligneCommande);
//        Commande commande = new Commande(name,clientEmail,ligneCommande);
//        commandeRepository.save(commande);
//    }


}
