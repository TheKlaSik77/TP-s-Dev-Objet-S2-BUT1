package locationVoitures;

public class Lancement {
    public static void main(String[] args) {
        Agence a = new Agence();
        Voiture v1 = new Voiture("Ford", "GT", 500, 550);
        Voiture v2 = new Voiture("Ford", "Fiesta", 3500, 35);
        Voiture v3 = new Voiture("Renault", "Clio", 28550,20);

        a.ajoute(v1);
        a.ajoute(v2);
        a.ajoute(v3);

        Critere c1 = new CriterePrix(40);
        Critere c2 = new CritereMarque("Ford");

        //System.out.println(a.selection(c1));

        InterCritere c3 = new InterCritere(c1,c2);
        //System.out.println(a.selection(c3));

        Critere c4 = new CritereKmMin(1000);
        Critere c5 = new CritereKmMax(28550);

        InterCritere c6 = new InterCritere(c4,c5);
        //System.out.println(a.selection(c6));

        VueAgence vueAgence = new VueAgence(a);
        vueAgence.selection();

    }
}
