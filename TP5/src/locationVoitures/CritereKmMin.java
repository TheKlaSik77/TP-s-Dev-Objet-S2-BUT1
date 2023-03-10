package locationVoitures;

public class CritereKmMin implements Critere{

    private int kmMin;

    public CritereKmMin(int kmMin){
        this.kmMin = kmMin;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        if (v.getKilometrage() >= kmMin){
            return true;
        }
        return false;
    }
}
