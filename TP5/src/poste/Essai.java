package poste;

import poste.Lettre;

import java.util.ArrayList;

public class Essai {

    public static void main(String[] args) {
        Courrier c1 = new Lettre("Pierre");
        Courrier c2 = new Lettre("Paul");
        Courrier c3 = new Colis("Henri",1300,"Philippe");
        ArrayList<Courrier> boite = new ArrayList<>();
        boite.add(c1);
        boite.add(c2);
        boite.add(c3);

        // Ce code est censé afficher :
        // 0.5
        // 0.5
        // 3.0
        for (int i = 0 ; i < boite.size() ; i++){
            System.out.println(boite.get(i));
        }


    }




}
