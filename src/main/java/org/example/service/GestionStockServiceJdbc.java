package org.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestionStockServiceJdbc {

    private static final String URL = "jdbc:mysql://localhost:3306/gestion_stock";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void ajouterProduit(String nom, int quantite, double prix) {
        String sql = "INSERT INTO produits (nom, quantite, prix) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            stmt.setInt(2, quantite);
            stmt.setDouble(3, prix);

            int lignesAjoutees = stmt.executeUpdate();
            if (lignesAjoutees > 0) {
                System.out.println("Produit ajouté avec succès !");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du produit : " + e.getMessage());
        }
    }

    // Exemple de test
    public static void main(String[] args) {
        GestionStockServiceJdbc service = new GestionStockServiceJdbc();
        service.ajouterProduit("Clavier mécanique", 10, 59.99);

    }
}
