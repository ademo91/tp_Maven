package org.example.service;

import org.example.model.Produit;

import java.util.ArrayList;
import java.util.List;

public class GestionStockService {
    private List<Produit> produits;

    public GestionStockService() {
        produits = new ArrayList<>();
    }

    // Ajouter un produit
    public void ajouterProduit(Produit produit) {
        produits.add(produit);
        System.out.println("✅ Produit ajouté : " + produit);
    }

    // Supprimer un produit par ID
    public void supprimerProduit(int id) {
        boolean removed = produits.removeIf(p -> p.getId() == id);
        if (removed) {
            System.out.println("🗑️ Produit supprimé avec ID : " + id);
        } else {
            System.out.println("❌ Aucun produit trouvé avec l'ID : " + id);
        }
    }

    // Mettre à jour un produit
    public void mettreAJourProduit(Produit nouveauProduit) {
        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getId() == nouveauProduit.getId()) {
                produits.set(i, nouveauProduit);
                System.out.println("🔄 Produit mis à jour : " + nouveauProduit);
                return;
            }
        }
        System.out.println("❌ Produit non trouvé pour mise à jour (ID : " + nouveauProduit.getId() + ")");
    }

    // Afficher tous les produits
    public void afficherProduits() {
        if (produits.isEmpty()) {
            System.out.println("📦 Aucun produit dans le stock.");
        } else {
            System.out.println("📋 Liste des produits en stock :");
            for (Produit p : produits) {
                System.out.println(p);
            }
        }
    }

    // Rechercher un produit par nom ou ID
    public void rechercherProduit(String motCle) {
        boolean trouve = false;
        for (Produit p : produits) {
            if (String.valueOf(p.getId()).equals(motCle) || p.getNom().equalsIgnoreCase(motCle)) {
                System.out.println("🔍 Produit trouvé : " + p);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("❌ Aucun produit trouvé pour : " + motCle);
        }
    }
}

