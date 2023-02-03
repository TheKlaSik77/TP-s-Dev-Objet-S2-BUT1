package bataille;

/*
 *  La classe Carte modélise les cartes d'un jeu de cartes.
 *
 *  Une carte possède une valeur et une couleur.
 *  Les valeurs sont  représentées par des int entre 2 et 14 (11 pour valet, 12 pour dame, 13 pour roi, 14 pour as).
 *  Les couleurs, représentées par un type String, peuvent être "coeur", "carreau", "trèfle", "pique".
 *
 *  Responsabilités détaillées de la classe Carte :
 *  - créer la nouvelle carte
 *  - dire si la carte est supérieure à une autre carte
 *  - donner une représentation affichable de la carte
 */
public class Carte {

    private int valeur;
    private String couleur;

    public Carte (int valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public boolean supérieureA(Carte c) {
        return this.valeur > c.valeur;
    }

    public String toString() {
        String valeurAffichable ;
        if (this.valeur == 14)
            valeurAffichable = "as";
        else if (this.valeur == 11)
            valeurAffichable = "valet";
        else if (this.valeur == 12)
            valeurAffichable = "dame";
        else if (this.valeur == 13)
            valeurAffichable = "roi";
        else
            valeurAffichable = Integer.toString(this.valeur);
        return valeurAffichable + " de " + this.couleur;
    }

    /**
        * Retourne :
        * un entier positif (de valeur absolue quelconque) si la valeur de la carte est strictement superieure
        * a la valeur de la carte c recue en parametre
        * un entier negatif (de valeur absolue quelconque) si la valeur de la carte est strictement inferieure
        * a la valeur de la carte c recue en parametre
        * zero si les deux cartes sont de meme valeur.
    */
    public int compareTo (Carte c) {

        if (this.supérieureA(c)){
            return 1;
        } else if (this.valeur == c.valeur){
            return 0;
        } else {
            return -1;
        }
    }

}
