package com.example.tp1_spring.data;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Client {
    @Id
    private String email;

    private String password;
    private String nom;
    private String prenom;

    @OneToMany
    private List<Commande> commandes;


    public Client(String email,String password, String nom, String prenom) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client() {
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
