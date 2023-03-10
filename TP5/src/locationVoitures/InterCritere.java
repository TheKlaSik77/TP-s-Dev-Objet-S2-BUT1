package locationVoitures;

public class InterCritere implements Critere{

    private Critere c1;
    private Critere c2;

    public InterCritere(Critere c1, Critere c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        if (this.c1.estSatisfaitPar(v) && (this.c2.estSatisfaitPar(v))){
            return true;
        }
        return false;
    }
}
