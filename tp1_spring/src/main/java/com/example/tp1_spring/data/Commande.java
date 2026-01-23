package com.example.tp1_spring.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    private String clientEmail;

    @OneToMany
    List<LigneCommande> ligneCommandes;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
