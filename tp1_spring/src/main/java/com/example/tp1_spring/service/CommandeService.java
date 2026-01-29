package com.example.tp1_spring.service;

import com.example.tp1_spring.data.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final LigneCommandeRepository ligneCommandeRepository;

    public CommandeService(CommandeRepository commandeRepository, ClientRepository clientRepository, LigneCommandeRepository ligneCommandeRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    public Commande getById(Long id){return commandeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Commande introuvable"));}

    public List<Commande> getCommandesClient(String clientEmail){
        return commandeRepository.findByClientEmail(clientEmail);
    }

    public Commande enregistrerCommande(String name, String clientEmail){
      Client client = clientRepository.findByEmail(clientEmail);
      Commande commande = new Commande(name,clientEmail);
      return commandeRepository.save(commande);
    }


    public Commande ajouterLigne(Long commandeId, String label, int quantity, double priceUnit) {
        Commande commande = commandeRepository.findById(commandeId).orElseThrow(()-> new IllegalArgumentException("Commande introuvable"));

        LigneCommande ligneCommande = new LigneCommande(label,quantity,priceUnit);
        ligneCommande.setCommande(commande);
        ligneCommandeRepository.save(ligneCommande);
        commande.getLigneCommandes().add(ligneCommande);
        return commandeRepository.save(commande);
    }

    public void supprimmerLigne(Long ligneId){
        LigneCommande ligne = ligneCommandeRepository.findById(ligneId).orElseThrow(() -> new IllegalArgumentException("Ligne introuvable"));

        ligneCommandeRepository.delete(ligne);
    }

    public double getTotalCommande(Long commandeId){
        Commande commande = getById(commandeId);
        return commande.getLigneCommandes().stream().mapToDouble(LigneCommande::getTotalPrice).sum();
    }
}
