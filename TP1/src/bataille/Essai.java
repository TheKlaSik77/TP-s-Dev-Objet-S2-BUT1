package bataille;

import java.util.ArrayList;

public class Essai {

    public static void main(String[] args) {

        //Carte carte1 = new Carte(11,"carreau");
        //Carte carte2 = new Carte(5,"trèfle");
        //System.out.println(carte1 + " | " + carte2);
        //ArrayList<Carte> paquet32Cartes = FabriqueDeJeuxDe32Cartes.créerJeu32DansOrdre();
        //System.out.println(paquet32Cartes);
        //ArrayList<Carte> paquet32CartesBattu = FabriqueDeJeuxDe32Cartes.créerJeu32Battu();
        //System.out.println(paquet32CartesBattu);

        /*
        if (paquet32CartesBattu.get(0).supérieureA(paquet32CartesBattu.get(1))){
            System.out.println("la première est plus grande que la deuxième" );
        } else if (paquet32CartesBattu.get(1).supérieureA(paquet32CartesBattu.get(0))){
            System.out.println("la deuxième est plus grande que la première");
        } else {
            System.out.println("les deux premières cartes sont de même valeur");
        }
         */
        //Joueur joueur1 = new Joueur("James");
        //System.out.println(joueur1.getNom());
        //System.out.println(joueur1);
        /*
        joueur1.ramasserUneCarte(carte1);
        System.out.println(joueur1);
        joueur1.ramasserUneCarte(carte2);
        System.out.println(joueur1);
        Carte cartePosee = joueur1.poserUneCarte();
        System.out.println(cartePosee);
        System.out.println(joueur1);

        if (joueur1.resteCarte()){
            System.out.println("Le joueur a au moins une carte");
        } else {
            System.out.println("Le joueur n’a aucune carte");
        }
        cartePosee = joueur1.poserUneCarte();
        System.out.println(cartePosee);
        System.out.println(joueur1);
        if (joueur1.resteCarte()){
            System.out.println("Le joueur a au moins une carte");
        } else {
            System.out.println("Le joueur n’a aucune carte");
        }
        */

        ArrayList<Carte> paquetJoueur1 = new ArrayList<Carte>();
        ArrayList<Carte> paquetJoueur2 = new ArrayList<Carte>();
        FabriqueDeJeuxDe32Cartes.créerEtDistribuerJeu32(paquetJoueur1,paquetJoueur2);
        Joueur joueur1 = new Joueur("James",paquetJoueur1);
        Joueur joueur2 = new Joueur("Philippe",paquetJoueur2);
        System.out.println(joueur1);
        System.out.println(joueur2);
        Carte cartePoseeJ1 = joueur1.poserUneCarte();
        Carte cartePoseeJ2 = joueur2.poserUneCarte();
        System.out.println("Carte Joueur 1 : " + cartePoseeJ1);
        System.out.println("Carte Joueur 2 : " + cartePoseeJ2);
        System.out.println(cartePoseeJ1.compareTo(cartePoseeJ2));
        System.out.println("Il reste " + joueur1.nbCartesRestantes() + " au joueur 1.");

        cartePoseeJ1 = joueur1.poserUneCarte();
        cartePoseeJ2 = joueur2.poserUneCarte();
        System.out.println("Carte Joueur 1 : " + cartePoseeJ1);
        System.out.println("Carte Joueur 2 : " + cartePoseeJ2);
        System.out.println(cartePoseeJ1.compareTo(cartePoseeJ2));
        System.out.println("Il reste " + joueur1.nbCartesRestantes() + " au joueur 1.");
    }
}
