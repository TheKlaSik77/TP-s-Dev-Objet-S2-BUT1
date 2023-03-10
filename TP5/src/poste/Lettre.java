package poste;

public class Lettre implements Courrier {

    private String destinataire;

    public Lettre(String destinataire){
        this.destinataire = destinataire;
    }
    public String getDestinataire() {
        return this.destinataire;
    }

    public double coutAffranchissement(){
        return 0.5;
    }

    public boolean estCorrect() {
        return getDestinataire() != null;
    }

    public String toString(){
        return this.getClass().getSimpleName() + " pour " + getDestinataire() + ". Cout du courrier : " + coutAffranchissement();
    }
}
