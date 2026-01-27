package com.example.tp1_spring.data;

import jakarta.persistence.*;

@Entity
public class LigneCommande {

    @Id
    @GeneratedValue
    private long id;
    private String labelProduct;
    private int quantity;
    private double priceUnit;

    @ManyToOne
    private Commande commande;

    public LigneCommande(String labelProduct, int quantity, double priceUnit) {
        this.labelProduct = labelProduct;
        this.quantity = quantity;
        this.priceUnit = priceUnit;
    }

    public LigneCommande(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabelProduct() {
        return labelProduct;
    }

    public void setLabelProduct(String labelProduct) {
        this.labelProduct = labelProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    public double getTotalPrice(){return quantity*priceUnit;}
}
