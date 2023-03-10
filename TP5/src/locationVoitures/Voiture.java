package locationVoitures;

public class Voiture {

    private String marque;
    private String modele;
    private int kilometrage;
    private int prix;

    public Voiture(String marque, String modele, int kilometrage, int prix){
        this.marque = marque;
        this.modele = modele;
        this.kilometrage = kilometrage;
        this.prix = prix;
    }

    public String getMarque(){
        return marque;
    }
    public String getModele(){
        return modele;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public int getPrix() {
        return prix;
    }

    public String toString(){
        return getMarque() + " " + getModele() + " | kilométrage : " + getKilometrage() + " | prix : " + getPrix();
    }
}
