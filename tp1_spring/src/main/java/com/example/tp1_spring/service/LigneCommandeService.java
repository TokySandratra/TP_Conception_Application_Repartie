package com.example.tp1_spring.service;

import com.example.tp1_spring.data.LigneCommande;
import com.example.tp1_spring.data.LigneCommandeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LigneCommandeService {

    private final LigneCommandeRepository ligneCommandeRepository;

    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    public void enregistrerLigneCommande( String label,  int quantity,  double price){

    }

}
