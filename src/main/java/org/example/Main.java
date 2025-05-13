package org.example;

import com.sun.jdi.connect.spi.Connection;
import org.example.model.Produit;
import org.example.service.GestionStockService;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public Main() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
        GestionStockService stockService = new GestionStockService();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n===== MENU GESTION DE STOCK =====");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Supprimer un produit");
            System.out.println("3. Mettre à jour un produit");
            System.out.println("4. Afficher tous les produits");
            System.out.println("5. Rechercher un produit");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // pour consommer le retour à la ligne

            switch (choix) {
                case 1:
                    System.out.print("ID : ");
                    int idAjout = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nom : ");
                    String nomAjout = scanner.nextLine();
                    System.out.print("Quantité : ");
                    int quantiteAjout = scanner.nextInt();
                    System.out.print("Prix : ");
                    double prixAjout = scanner.nextDouble();

                    Produit nouveau = new Produit(idAjout, nomAjout, quantiteAjout, prixAjout);
                    stockService.ajouterProduit(nouveau);
                    break;

                case 2:
                    System.out.print("ID du produit à supprimer : ");
                    int idSup = scanner.nextInt();
                    stockService.supprimerProduit(idSup);
                    break;

                case 3:
                    System.out.print("ID du produit à mettre à jour : ");
                    int idMaj = scanner.nextInt();
                    scanner.nextLine(); // sauter ligne
                    System.out.print("Nouveau nom : ");
                    String nomMaj = scanner.nextLine();
                    System.out.print("Nouvelle quantité : ");
                    int quantiteMaj = scanner.nextInt();
                    System.out.print("Nouveau prix : ");
                    double prixMaj = scanner.nextDouble();

                    Produit maj = new Produit(idMaj, nomMaj, quantiteMaj, prixMaj);
                    stockService.mettreAJourProduit(maj);
                    break;

                case 4:
                    stockService.afficherProduits();
                    break;

                case 5:
                    System.out.print("Entrez l'ID ou le nom du produit à rechercher : ");
                    String motCle = scanner.nextLine();
                    stockService.rechercherProduit(motCle);
                    break;

                case 0:
                    System.out.println("👋 Merci d'avoir utilisé l'application.");
                    break;

                default:
                    System.out.println("❌ Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 0);


        scanner.close();
    }
}
