package com.example.tp1_spring.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LigneCommande {

    @Id
    @GeneratedValue
    private long id;
    private int quantity;
    private int idCommande;
    private int idArticle;

    public LigneCommande(int quantity, int idCommande, int idArticle) {
        this.quantity = quantity;
        this.idCommande = idCommande;
        this.idArticle = idArticle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }
}
