package messagerie;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void menu(){

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Scanner scanner2 = new Scanner(System.in).useDelimiter("\n");
        // Création des serveurs
        Serveur gmail = new Serveur("gmail");
        Serveur hotmail = new Serveur("hotmail");

        do {
            String utilisateur = Client.saisirNom();
            if (utilisateur.equals("!")) {
                System.exit(0);
            }
            Client c1 = new Client(utilisateur);
            System.out.println("------------------------------------------------------------");
            System.out.print("Bonjour " + c1.getNom() + ".\nA quel serveur souhaitez-vous vous connecter : \n1. Gmail \n2. Hotmail \nVotre choix : ");
            int choix = scanner.nextInt();
            if (choix == 1) {
                c1.seConnecterAuServeur(gmail);
            } else if (choix == 2) {
                c1.seConnecterAuServeur(hotmail);
            } else {
                System.out.println("Choix Incorrect");
                System.exit(1);
            }
            do {
                System.out.println("------------------------------------------------------------");
                System.out.print("Que voulez-vous faire ?\n1. Envoyer un message\n2. Consulter vos messages\n3. Se déconnecter\nVotre choix : ");
                choix = scanner.nextInt();
                switch (choix) {
                    case 1:
                        System.out.println("------------------------------------------------------------");
                        System.out.print("A qui voulez-vous envoyer le message : ");
                        String destinataire = scanner2.nextLine();
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Écrivez votre message et entrée pour envoyer : \n\n");
                        String contenu = scanner2.nextLine();
                        Message m = c1.redigerMessage(destinataire, contenu);
                        c1.getServeur().posterMessage(m);
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Message envoyé!");

                    case 2:
                        ArrayList<Message> listeMessages = c1.getServeur().creerListeMsgClient(c1.getNom());
                        if (listeMessages.isEmpty()){
                            System.out.println("------------------------------------------------------------");
                            System.out.println("                 Pas de nouveaux messages!                  ");
                            
                        }
                        for (Message messageRecu : listeMessages) {
                            System.out.println(messageRecu);
                        }

                    case 3 :
                        c1.seDeconnecterDuServeurActuel();
                }
            } while (choix == 1 || choix == 2);

        } while (true);
    }
}
