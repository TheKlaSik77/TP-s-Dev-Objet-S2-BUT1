package bataille;
import java.util.ArrayList;

/*
 * La classe Partie fait fonctionner le jeu de bataille (elle contient la boucle principale du jeu).
 * Une partie oppose deux joueurs qui vont exécuter des tours de jeu jusqu'à ce que l'un d'eux gagne.
 *
 * Une Partie concerne deux Joueur.
 *
 * Responsabilités détaillées de la classe Partie :
 * - créer une nouvelle partie opposant deux Joueur
 * - faire jouer la partie (jouer des tours de jeu jusquà ce qu'un joueur gagne).
 * - dire qui est le gagnant ou bien si la partie est terminée
 *
 */
public class Partie {

    private Joueur joueur1, joueur2;

    public Partie (String nomJ1, String nomJ2) {

        // créer deux paquets de cartes contenant une distribution d'un jeu de 32 cartes
        ArrayList<Carte> paquet1, paquet2;
        paquet1 = new ArrayList<Carte>();
        paquet2 = new ArrayList<Carte>();
        FabriqueDeJeuxDe32Cartes.créerEtDistribuerJeu32(paquet1, paquet2);

        // créer les joueurs
        this.joueur1 = new Joueur(nomJ1, paquet1);
        this.joueur2 = new Joueur(nomJ2, paquet2);
    }

    public void jouer () {

        System.out.println("Nous commençons une nouvelle et grandiose partie qui oppose :");
        System.out.println("Joueur 1 : " + this.joueur1.toString());
        System.out.println("Joueur 2 : " + this.joueur2.toString());
        System.out.println();

        int compteurDeTours = 0;

        // boucle principale du jeu
        while (this.joueur1.resteCarte() && this.joueur2.resteCarte()) {
            compteurDeTours++;
            System.out.println("tour n°" + compteurDeTours);
            this.faireUnTourDeJeu(compteurDeTours);
            System.out.println(this.joueur1.toString());
            System.out.println(this.joueur2.toString());
            System.out.println();
            System.out.println("Joueur 1 : Il vous reste : " + joueur1.nbCartesRestantes() + ".\nJoueur 2 : Il vous reste : " + joueur2.nbCartesRestantes() + ".");
        }


        // affichage du résultat
        if (this.joueur1.resteCarte())
            System.out.println(this.joueur1.getNom() + " a gagné !");
        else
            System.out.println(this.joueur2.getNom() + " a gagné !");
    }


    // dans cette version très simplifiée on ne traite pas la bataille : en cas de bataille on tire au sort.

    private void faireUnTourDeJeu(int compteurDeTours) {

        Carte cartePoséeJoueur1, cartePoséeJoueur2;

        // chaque joueur pose une carte sur le tapis de jeu
        if (compteurDeTours % 3 == 0) {
            cartePoséeJoueur1 = this.joueur1.tricher1();
        } else {
            cartePoséeJoueur1 = this.joueur1.poserUneCarte();
        }
        System.out.println(this.joueur1.getNom() + " pose le " + cartePoséeJoueur1.toString());
        cartePoséeJoueur2 = this.joueur2.poserUneCarte();
        System.out.println(this.joueur2.getNom() + " pose le " + cartePoséeJoueur2.toString());

        // qui gagne le pli ?
        Joueur gagnantPli;
        if (cartePoséeJoueur1.supérieureA(cartePoséeJoueur2))
            gagnantPli = this.joueur1;
        else if (cartePoséeJoueur2.supérieureA(cartePoséeJoueur1))
            gagnantPli = this.joueur2;

        // TODO : implémenter la bataille
        else {
            ArrayList<Carte> cartesEnJeu = new ArrayList<Carte>();
            gagnantPli = bataille(cartesEnJeu);
        }
        /*
        else if (Math.random()<0.5) // dans cette version simplifiée, en cas de bataille on tire au sort
            gagnantPli = this.joueur1;
        else
            gagnantPli = this.joueur2;

        System.out.println(gagnantPli.getNom() + " gagne le pli");
        */
        // le pli est battu puis ramassé par le gagnant

        if (Math.random() < 0.5) {
            gagnantPli.ramasserUneCarte(cartePoséeJoueur1);
            gagnantPli.ramasserUneCarte(cartePoséeJoueur2);
        } else {
            gagnantPli.ramasserUneCarte(cartePoséeJoueur2);
            gagnantPli.ramasserUneCarte(cartePoséeJoueur1);
        }

    }
    // TODO : implanter la bataille...
    private Joueur bataille(ArrayList<Carte> cartesEnJeu){
        System.out.println("BATAILLE !");
        Carte cartePoseeCacheeJoueur1;
        Carte cartePoseeCacheeJoueur2;
        Carte cartePoseeJoueur1;
        Carte cartePoseeJoueur2;
        // Pose la carte face cachée et ajoute aux cartes en jeu et renvoie le gagnant si plus de carte
        if (joueur1.resteCarte()){
            cartePoseeCacheeJoueur1 = joueur1.poserUneCarte();
            cartesEnJeu.add(cartePoseeCacheeJoueur1);
            System.out.println(joueur1.getNom() + " pose une carte face cachée");
        } else {
            return joueur2;
        } if (joueur2.resteCarte()){
            cartePoseeCacheeJoueur2 = joueur2.poserUneCarte();
            cartesEnJeu.add(cartePoseeCacheeJoueur2);
            System.out.println(joueur2.getNom() + " pose une carte face cachée");
        } else {
            return joueur1;
        }

        // Pose la carte face découverte
        if (joueur1.resteCarte()){
            cartePoseeJoueur1 = joueur1.poserUneCarte();
            cartesEnJeu.add(cartePoseeJoueur1);
            System.out.println(joueur1.getNom() + " pose " + cartePoseeJoueur1.toString());
        } else {
            return joueur2;
        } if (joueur2.resteCarte()){
            cartePoseeJoueur2 = joueur2.poserUneCarte();
            cartesEnJeu.add(cartePoseeJoueur2);
            System.out.println(joueur2.getNom() + " pose " + cartePoseeJoueur2.toString());
        } else {
            return joueur1;
        }

        // Résultats
        if (cartePoseeJoueur1.supérieureA(cartePoseeJoueur2)){
            for (int i = 0 ; i < cartesEnJeu.size() ; i++){
                joueur1.ramasserUneCarte(cartesEnJeu.remove(0));
            }
            return joueur1;
        } else if (cartePoseeJoueur2.supérieureA(cartePoseeJoueur1)){
            for (int i = 0 ; i < cartesEnJeu.size() ; i++){
                joueur2.ramasserUneCarte(cartesEnJeu.remove(0));
            }
            return joueur2;
        } else {
            return bataille(cartesEnJeu);
        }



    }

}
