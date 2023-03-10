package monRepasChezMoi;

public class Commande {

    private String adresseDepart;
    private String adresseArrivee;
    private String description;


    public Commande (String adresseDepart, String adresseArrivee, String description){
        this.adresseDepart = adresseDepart;
        this.adresseArrivee = adresseArrivee;
        this.description = description;

    }

    public String getAdresseDepart(){
        return this.adresseDepart;
    }
    public String getAdresseArrivee(){
        return this.adresseArrivee;
    }
    public String getDescription(){
        return this.description;
    }

    public String toString (){
        return "Adresse du restaurant de départ : " + adresseDepart + "\nAdresse de livraison : " + adresseArrivee + "\nDétails de la commande : " + description;
    }
}
