package web.Modele;

import dao.entities.Produit;

import java.util.ArrayList;

public class ProduitModel {
    String mc;
    Produit p;
    ArrayList<Produit> produits;

    public ProduitModel() {
    }

    public ProduitModel(String mc, Produit p, ArrayList<Produit> produits) {
        this.mc = mc;
        this.p = p;
        this.produits = produits;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public Produit getP() {
        return p;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }
}
