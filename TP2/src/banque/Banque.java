package banque;

import java.util.ArrayList;
import java.util.Scanner;

public class Banque {
    private String nom;
    private ArrayList<Client> listeClients;
    private ArrayList<Compte> listeComptes;

    private int nbClient;
    private int nbCompte;
    public Banque(String nom){
        this.nom = nom;
        this.listeClients = new ArrayList<Client>();
        this.listeComptes = new ArrayList<Compte>();
        this.nbClient = 0;
        this.nbCompte = 0;
    }

    public ArrayList<Client> getListeClients(){
        return this.listeClients;
    }

    public ArrayList<Compte> getListeComptes(){
       return this.listeComptes;
    }

    public int getNbClient(){
       return nbClient;
    }

    public int getNbCompte(){
       return nbCompte;
    }
    public void ajouterClient(Client client){
       this.listeClients.add(client);
       this.nbClient++;
    }

    public void ajouterCompte(Compte compte){
       this.listeComptes.add(compte);
       this.nbCompte++;
    }

    public void afficherListeClients(){
       for (Client client : this.getListeClients()){
           System.out.println("----------------------------------");
           System.out.println(client);
       }
    }

    public void afficherListeCompte(){
        for (Compte compte : this.getListeComptes()){
            System.out.println("----------------------------------");
            System.out.println(compte);
        }
    }

    public void saisirNumeroCompte(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\n----------------------------------");
        System.out.print("Saisissez le numéro de compte afin d'afficher ses informations : ");


        int numeroCompte = scanner.nextInt();
        boolean trouve = false;
        for (Compte c : this.listeComptes){
            if (c.getNumeroCompte() == numeroCompte){
                System.out.println("-------------Informations sur le compte n. " + numeroCompte + "-------------");
                System.out.println(c);
                trouve = true;
            }
        }
        if (!trouve){
            System.out.println("\n----------------------------------");
            System.out.println("Erreur, le numéro de compte " + numeroCompte + " n'existe pas!");
            System.out.print("Voulez-vous réessayer ?\n1. Oui\n2.Non\nVotre choix : ");
            int choix = scanner.nextInt();
            while (choix != 1 && choix != 2){
                System.out.println("\n----------------------------------");
                System.out.print("Erreur! Choix Invalide!\n1. Oui\n2.Non\nVotre choix : ");
                choix = scanner.nextInt();
            }
            switch (choix){
                case 1:
                    saisirNumeroCompte();
                case 2:
                    System.out.println("\n----------------------------------");
                    System.exit(0);
            }
        }
    }

    public void afficherComptesADecouvert(){
        System.out.println("\n-----Liste des comptes à découvert-------");

        for (Compte compte : this.listeComptes){
            if (compte.getSolde() < 0){
                System.out.println("\n----------------------------------");
                System.out.println(compte);
            }
        }
    }

    /**
     * Permet à un banquier d'effectuer les opérations suivantes : ajouter un client, ajouter un compte, afficher la liste des clients, afficher la liste des comptes, afficher la liste des comptes à découvert, effectuer des opérations sur un compte. (afficher infos, créditer compte, débiter compte).
     */
    public void menu(){

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\n----------------------------------");
        System.out.print("Bienvenue dans la banque : " + this.nom + "\nSélectionnez l'opération que vous voulez effectuer:\n1. Afficher la liste des clients\n2. Afficher la liste des comptes\n3. Ajouter un client\n4. Ajouter un compte\n5. Afficher la liste des comptes à découvert\n6. Effectuer des opérations sur un compte\n7. Quitter\n\nVotre choix : ");
        int choix = scanner.nextInt();
        while (choix < 1 || choix > 7){
            System.out.println("\n----------------------------------");
            System.out.print("Bienvenue dans la banque : " + this.nom + "\nSélectionnez l'opération que vous voulez effectuer:\n1. Afficher la liste des clients\n2. Afficher la liste des comptes\n3. Ajouter un client\n4. Ajouter un compte\n5. Afficher la liste des comptes à découvert\n6. Effectuer des opérations sur un compte\n\nErreur votre choix est incorrect!\nVotre choix : ");
            choix = scanner.nextInt();
        }

        switch(choix) {
            case 1:
                System.out.println("\n----------------------------------");
                this.afficherListeClients();
                break;
            case 2:
                System.out.println("\n----------------------------------");
                this.afficherListeCompte();
                break;
            case 3:
                System.out.println("\n----------------------------------");
                System.out.print("Saisissez le nom du client : ");
                String nomClient = scanner.nextLine();
                System.out.print("Saisissez l'adresse du client : ");
                String adresseClient = scanner.nextLine();
                Client nouveauClient = new Client(nomClient, adresseClient);
                this.ajouterClient(nouveauClient);
                break;
            case 4:
                System.out.println("\n----------------------------------");
                System.out.println("Liste des clients déjà inscrits :");
                for (int i = 0 ; i < this.listeClients.size() ; i++){
                    System.out.println((i + 1) + ". " + this.listeClients.get(i).getNom());
                }
                System.out.println("\n----------------------------------");
                System.out.print("Voulez-vous créer un client ou attribuer un client déjà inscrit comme titulaire :\n 1. Créer un client\n2. Attribuer un client déjà inscrit\n\nVotre Choix : ");
                int choix2 = scanner.nextInt();
                while (choix2 != 1 && choix2 != 2){
                    System.out.print("Voulez-vous créer un client ou attribuer un client déjà inscrit comme titulaire :\n 1. Créer un client\n2. Attribuer un client déjà inscrit\n\nErreur, choix incorrect!\nVotre Choix : ");
                    choix2 = scanner.nextInt();
                }
                if (choix2 == 1){

                    System.out.println("\n----------------------------------");
                    System.out.print("Saisissez le nom du client : ");
                    String nomNouveauClient = scanner.nextLine();
                    System.out.print("Saisissez l'adresse du client : ");
                    String adresseNouveauClient = scanner.nextLine();
                    Client client = new Client(nomNouveauClient, adresseNouveauClient);
                    this.ajouterClient(client);

                    System.out.println("\n----------------------------------");
                    System.out.print("Insérez le solde de départ du compte : ");
                    long solde = scanner.nextInt();
                    Compte nouveauCompte = new Compte(client,solde);
                    this.ajouterCompte(nouveauCompte);
                    break;

                } else {
                    System.out.println("\n----------------------------------");
                    System.out.println("Liste des clients déjà inscrits :");
                    for (int i = 0 ; i < this.listeClients.size() ; i++){
                        System.out.println((i + 1) + ". " + this.listeClients.get(i).getNom());
                    }
                    System.out.print("Votre choix : ");
                    int choix3 = scanner.nextInt();
                    while (choix3 < 1 || choix3 > this.listeClients.size()){
                        System.out.println("\n----------------------------------");
                        System.out.print("Erreur! Choix Incorrect!\nVotre choix : ");
                        choix3 = scanner.nextInt();
                    }
                    Client titulaire = this.listeClients.get(choix3 - 1);
                    System.out.println("\n----------------------------------");
                    System.out.print("Insérez le solde de départ du compte : ");
                    long solde = scanner.nextInt();

                    Compte nouveauCompte = new Compte(titulaire,solde);
                    this.ajouterCompte(nouveauCompte);
                    break;
                }
            case 5:
                this.afficherComptesADecouvert();
                break;
            case 6:
                this.faireOperationSurCompte();
                break;
            case 7:
                System.exit(0);


        }

        this.menu();

    }

    public void faireOperationSurCompte(){

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\n----------------------------------");
        System.out.print("Insérez le numéro de compte sur lequel vous voulez opérer : ");
        int num = scanner.nextInt();
        while (num < 1 || num > listeComptes.size()){
            System.out.print("Erreur! Compte invalide!\nInsérez le numéro de compte sur lequel vous voulez opérer : ");
            num = scanner.nextInt();
        }
        System.out.println("\n----------------------------------");
        System.out.print("Sélectionnez l'opération :\n1. Afficher infos compte\n2. Créditer le compte\n3. Débiter le Compte\n\nVotre choix : ");
        int choix = scanner.nextInt();
        while (choix < 1 || choix > 3){
            System.out.println("\n----------------------------------");
            System.out.print("Erreur! Choix Invalide\nSélectionnez l'opération :\n1. Afficher infos compte\n2. Créditer le compte\n3. Débiter le Compte\n\nVotre choix : ");
            choix = scanner.nextInt();
        }

        switch (choix){
            case 1:
                System.out.println("\n----------------------------------");
                System.out.println(this.listeComptes.get(num));
            case 2:
                System.out.println("\n----------------------------------");
                System.out.print("Insérez l'argent que vous voulez ajouter au compte (Attention 100 -> 1.00 €) : ");
                long argentCredite = scanner.nextInt();
                while (argentCredite < 0){
                    System.out.println("\n----------------------------------");
                    System.out.print("Erreur! Valeur négative!\nInsérez l'argent que vous voulez ajouter au compte (Attention 100 -> 1.00 €) : ");
                    argentCredite = scanner.nextInt();
                }
                this.listeComptes.get(num).crediterCompte(argentCredite);
            case 3:
                System.out.println("\n----------------------------------");
                System.out.print("Insérez l'argent que vous voulez retirer au compte (Attention 100 -> 1.00 €) : ");
                long argentDebite = scanner.nextInt();
                while (argentDebite < 0){
                    System.out.println("\n----------------------------------");
                    System.out.print("Erreur! Valeur négative!\nInsérez l'argent que vous voulez retirer au compte (Attention 100 -> 1.00 €) : ");
                    argentCredite = scanner.nextInt();
                }
                this.listeComptes.get(num).debiterCompte(argentDebite);

        }
    }



}
