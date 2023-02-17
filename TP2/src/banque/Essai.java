package banque;

public class Essai {

    public static void main(String[] args) {
        Client client1 = new Client("Bruce Wayne","Gotham City");
        //System.out.println(client1);

        client1.setAdresse("Métropolis");
        //System.out.println(client1);

        Compte compte1 = new Compte(client1,800000000);
        //System.out.println(compte1);

        Client client2 = new Client("Peter Parker", "New York");
        Compte compte2 = new Compte(client2,120000);

        Compte compte3 = new Compte(client1,75000000);

        compte1.debiterCompte(500000);
        compte2.crediterCompte(1400);
        compte3.debiterCompte(1000000000);

        /*
        System.out.println("----------------------------");
        System.out.println(compte1.getSolde());
        System.out.println(compte1);
        System.out.println("----------------------------");
        System.out.println(compte2.getSolde());
        System.out.println(compte2);
        System.out.println("----------------------------");
        System.out.println(compte3.getSolde());
        System.out.println(compte3);
        System.out.println("----------------------------");
        */

        Banque banque1 = new Banque("Le Crédit Montreuillois");
        banque1.ajouterClient(client1);
        banque1.ajouterClient(client2);
        banque1.ajouterCompte(compte1);
        banque1.ajouterCompte(compte2);
        banque1.ajouterCompte(compte3);

        /*
        banque1.afficherListeClients();
        System.out.println("----------------------------------");
        banque1.afficherListeCompte();
        System.out.println("----------------------------------");
        banque1.saisirNumeroCompte();
         */
        banque1.menu();

    }
}
