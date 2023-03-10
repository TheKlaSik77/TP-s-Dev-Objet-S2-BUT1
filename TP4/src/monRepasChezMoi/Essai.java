package monRepasChezMoi;

import java.sql.Array;
import java.util.ArrayList;

public class Essai {

    public static void main(String[] args) {

        // Création du central
        MonRepasChezMoi central = new MonRepasChezMoi(new ArrayList<Commande>());

        // Création des livreurs
        GPS positionLivreur = new GPS();
        Livreur l1 = new Livreur("James",positionLivreur);
        Livreur l2 = new Livreur("Stéphane",positionLivreur);

        // Création des commandes
        Commande c1 = new Commande("22 rue de Paris, Paris","21 rue de Marseille, Paris","BigMac avec frites et Coca");
        Commande c2 = new Commande("22 rue de Nantes, Paris","21 rue de Lille, Paris","KFC avec tenders, frites et Ice-Tea");
        Commande c3 = new Commande("22 rue de Metz, Paris","21 rue de Monaco, Paris","SteakHouse avec kingFries Bacon");
        Commande c4 = new Commande("22 rue de Montpellier, Paris","21 rue de Bordeaux, Paris","Gnocchis au saumon");
        Commande c5 = new Commande("22 rue de Metz, Paris","21 rue de Bordeaux, Paris","Commande A");
        Commande c6 = new Commande("22 rue de Montpellier, Paris","21 rue de Marseille, Paris","Commande C");

        central.ajouterCommande(c1);
        central.ajouterCommande(c2);
        central.ajouterCommande(c3);
        central.ajouterCommande(c4);
        central.ajouterCommande(c5);
        central.ajouterCommande(c6);


        // Choix du temps max entre 60 et 1060
        int tempsMax = 800;

        l1.choisirCourse(central.getListeCommandesCentral(),central.lister5CommandesLesPlusProches(l1,tempsMax));
        System.out.println("-----------------------------------------------------------------------------------");
        l1.terminerCourse();





    }
}
