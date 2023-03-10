package monRepasChezMoi;

import java.util.ArrayList;
import java.util.Collection;

public class MonRepasChezMoi {

    private ArrayList<Commande> listeCommandesCentral;

    public MonRepasChezMoi (ArrayList<Commande> listeCommandesCentral){
        this.listeCommandesCentral = listeCommandesCentral;
    }

    public ArrayList<Commande> getListeCommandesCentral(){
        return this.listeCommandesCentral;
    }
    public void ajouterCommande(Commande c){
        listeCommandesCentral.add(c);
    }

    public ArrayList<Commande> lister5CommandesLesPlusProches (Livreur livreur, int tempsMax){
        ArrayList<Commande> listeInfTempsMax = new ArrayList<Commande>();
        for (int i = 0 ; i < this.listeCommandesCentral.size() ; i++){
            int tempsTrajetI = GPS.tempsTrajet(livreur.getPosition().maPosition(),listeCommandesCentral.get(i).getAdresseDepart());
            if (tempsTrajetI <= tempsMax){
                listeInfTempsMax.add(this.listeCommandesCentral.get(i));
                System.out.println(this.listeCommandesCentral.get(i) + " : " + tempsTrajetI);
            }
        }
        return listeInfTempsMax;
    }
}
