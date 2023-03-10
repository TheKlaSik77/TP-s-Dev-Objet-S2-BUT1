package locationVoitures;

public class CritereKmMax implements Critere{

    private int kmMax;

    public CritereKmMax(int kmMax){
        this.kmMax = kmMax;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        if (v.getKilometrage() <= kmMax){
            return true;
        }
        return false;
    }
}