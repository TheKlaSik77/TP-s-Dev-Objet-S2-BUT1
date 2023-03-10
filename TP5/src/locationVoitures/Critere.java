package locationVoitures;

public interface Critere {

    /**
     * @param v la voiture dont on teste la conformité au critere
     * @return true si et seulement si la voiture est conforme au critere (on dit que v satisfait le critère)
     */
    public boolean estSatisfaitPar(Voiture v);
}
