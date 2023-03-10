package poste;

import poste.Courrier;

public class Colis implements Courrier {

    private String expediteur;
    private int poids;
    private String destinataire;

    public Colis(String expediteur, int poids, String destinataire){
        this.expediteur = expediteur;
        this.poids = poids;
        this.destinataire = destinataire;
    }
    public String getExpediteur(){
        return this.expediteur;
    }
    public int getPoids(){
        return this.poids;
    }
    public String getDestinataire() {
        return this.destinataire;
    }

    public double coutAffranchissement(){
        int multiplicateur = this.poids / 500;
        return 1 + multiplicateur;
    }

    public boolean estCorrect() {
        return (getDestinataire() != null) && (getExpediteur() != null);
    }

    public String toString(){
        return this.getClass().getSimpleName() + " de " + getPoids() + " pour " + getDestinataire() + ". Cout du courrier : " + coutAffranchissement();
    }
}