package monRepasChezMoi;

import java.util.ArrayList;

public class Livreur {

    private String nom;
    private GPS position;
    private Commande commandeEnCours;
    private boolean disponible;

    public Livreur (String nom, GPS position){
        this.nom = nom;
        this.position = position;
        this.commandeEnCours = null;
        this.disponible = true;
    }

    public GPS getPosition(){
        return this.position;
    }

    public String toString(){
        if (disponible){
            return "Le livreur " + this.nom + " se trouvant " + position.maPosition() + " est disponible.";
        } else {
            return "Le livreur " + this.nom + " se trouvant " + position.maPosition() + " porte la commande : \n\t-" + commandeEnCours;
        }

    }
    /**
     * Choisi au hasard parmi la liste de commande, une commande
     */
    public void choisirCourse(ArrayList<Commande> listeCommandesStandard, ArrayList<Commande> listeCommandesProches){
        int n = (int)(Math.random() * listeCommandesProches.size());
        this.commandeEnCours = listeCommandesProches.remove(n);
        for (int i = 0 ; i < listeCommandesStandard.size() ; i++){
            if(listeCommandesStandard.get(i).getAdresseDepart().equals(this.commandeEnCours.getAdresseDepart()) && listeCommandesStandard.get(i).getAdresseArrivee().equals(this.commandeEnCours.getAdresseArrivee()) && listeCommandesStandard.get(i).getDescription().equals(this.commandeEnCours.getDescription())){
                listeCommandesStandard.remove(i);
                break;
            }
        }
        this.disponible = false;
        System.out.println(this);
    }

    public void terminerCourse(){
        System.out.println("La commande : \n\t-" + this.commandeEnCours + "\na été livrée");
        this.commandeEnCours = null;
        this.disponible = true;
    }
}
