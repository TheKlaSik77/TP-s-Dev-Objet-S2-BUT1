package monRepasChezMoi;


public class GPS {


    // Retourne l’adresse de là où je me trouve.
    public String maPosition() {
        // Ceci est un simulacre
        return "Coucou, je suis là!";
    }

    //  Retourne le temps en secondes pour rejoindre l'adresse reçue en paramètre à partir de ma position courante.
    public int tempsTrajet (String adressse) {
        // Ceci est un simulacre...
        return (int)(Math.random()*1000)+60;
    }

    // Méthode static qui retourne le temps en secondes pour aller de adresseDépart à adresseArrivée.
    public static int tempsTrajet (String adressseDépart, String adresseArrivée) {
        // Ceci est un simulacre...
        return (int)(Math.random()*1000)+60;
    }
}

