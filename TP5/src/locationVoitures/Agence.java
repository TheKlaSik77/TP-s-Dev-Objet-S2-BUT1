package locationVoitures;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Agence {

    private ArrayList<Voiture> listeVoitures;

    public Agence(){
        this.listeVoitures = new ArrayList<>();
    }

    public void ajoute(Voiture v){
        this.listeVoitures.add(v);
    }
    public ArrayList<Voiture> selection(Critere critere){

        ArrayList<Voiture> voituresCorrespondantes = new ArrayList<>();
        for (Voiture v : this.listeVoitures){
            if (critere.estSatisfaitPar(v)){
                voituresCorrespondantes.add(v);
            }
        }
        return voituresCorrespondantes;
    }
    public ArrayList<Voiture> getListeVoitures(){
        return this.listeVoitures;
    }
}
