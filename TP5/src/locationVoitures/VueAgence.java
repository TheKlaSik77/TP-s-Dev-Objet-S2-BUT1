package locationVoitures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class VueAgence {
    private Agence uneAgence;

    public VueAgence(Agence a){
        this.uneAgence = a;
    }

    public void selection(){

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int choix;
        System.out.print("Veuillez choisir votre critère de sélection\n\t1.Par Prix\n\t2.Par Marque\n\t3.Par Kilométrage\nVotre choix : ");
        choix = scanner.nextInt();
        System.out.println("------------------------------------------------------");
        switch (choix){
            case 1:
                System.out.print("Indiquez le prix maximal : ");
                choix = scanner.nextInt();
                ArrayList<Voiture> listeVoituresCriterePrix = uneAgence.selection(new CriterePrix(choix));
                System.out.println("------------------------------------------------------");
                System.out.println("Voici les voitures que nous vous proposons : ");
                for (Voiture v : listeVoituresCriterePrix){
                    System.out.println("\t\t" + v);
                }
                break;
            case 2:
                System.out.println("Voici les marques de l'agences");
                ArrayList<String> listeMarque = new ArrayList<>();
                for (Voiture v : uneAgence.getListeVoitures()){
                    boolean isNot = true;
                    for (String v2 : listeMarque){
                        if (v.getMarque().equals(v2)){
                            isNot = false;
                        }
                    }
                    if(isNot){
                        listeMarque.add(v.getMarque());
                    }
                }
                for (int i = 0 ; i < listeMarque.size() ; i++){
                    System.out.println("\t\t" + (i+1) + ". " + listeMarque.get(i));
                }
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                System.out.println("------------------------------------------------------");
                Critere critereMarque = new CritereMarque(listeMarque.get(choix-1));
                ArrayList<Voiture> listeVoituresCritereMarque = uneAgence.selection(critereMarque);
                System.out.println("Voici les voitures que nous vous proposons :");
                for (Voiture v : listeVoituresCritereMarque){
                    System.out.println("\t\t\t" + v);
                }
                break;
            case 3:
                // A Completer avec les km
                break;
        }
        // Pour l'extension, créer une boucle et utiliser intercritere. CAD : critere prix + critere km = intercritere 1
        // Pour ajouter 1 critere intercritere 1 + critere marque = intercritere 2
        // Etc ...


    }
}
