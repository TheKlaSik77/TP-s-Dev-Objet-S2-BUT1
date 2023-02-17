package banque;

/**
 * Classe regroupant les méthodes et attributs d'un client possédant un compte dans la banque.
 */
public class Client {
    private String nom;
    private String adresse;

    public Client(String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
    }

    public void setAdresse(String nouvelleAdresse){
        this.adresse = nouvelleAdresse;
    }

    public String getNom(){
        return this.nom;
    }

    public String getAdresse(){
        return this.adresse;
    }

    public String toString(){
        return this.getNom() + "\nAdresse : " + this.getAdresse();
    }
}
