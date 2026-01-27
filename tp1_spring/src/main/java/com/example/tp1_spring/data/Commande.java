package com.example.tp1_spring.data;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String clientEmail;

    @OneToMany(mappedBy = "commande",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<LigneCommande> ligneCommandes =  new ArrayList<>();;

    public Commande(String name, String clientEmail, List<LigneCommande> ligneCommandes) {
        this.name = name;
        this.clientEmail = clientEmail;
        this.ligneCommandes = ligneCommandes;
    }


    public Commande(){}


    public Commande( String name,String clientEmail) {
        this.name = name;
        this.clientEmail = clientEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }
}
