package messagerie;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private String nom;
    private Serveur serveur;

    public Client (String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public Serveur getServeur(){
        return this.serveur;
    }
    public void seConnecterAuServeur(Serveur serveur){
        this.serveur = serveur;
    }

    public Message redigerMessage(String destinataire, String contenu){
        return new Message(this.nom,destinataire,contenu);
    }

    public void seDeconnecterDuServeurActuel(){
        this.serveur = null;
    }

    public void consulterMessages(ArrayList<Message> listeMessage){

        for (int i = 0 ; i < listeMessage.size() ; i++){
            System.out.println("------------------------------------------------------------");
            // Affichage Du Message
            System.out.println("-------------------- Message de " + listeMessage.get(i).getExpediteur() + " --------------------");
            System.out.println("\n" + listeMessage.get(i).getContenu() + "\n");

        }
        System.out.println("------------------------------------------------------------");
        System.out.println("                     Fin des messages                       ");

    }

    public static String saisirNom(){
        System.out.println("------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Insérez votre prénom et votre nom (! pour quitter) : ");

        return scanner.nextLine();
    }
}
