package banque;

/**
 * Classe regroupant les méthodes et attributs d'un compte dans la banque.
 */
public class Compte {
    private Client titulaire;
    private int numeroCompte;
    private long solde;
    private static int nbComptes = 0;

    public Compte(Client titulaire, long solde){
        this.titulaire = titulaire;
        nbComptes++;
        this.numeroCompte = nbComptes;
        this.solde = solde;
    }

    public Client getTitulaire(){
        return this.titulaire;
    }
    public int getNumeroCompte(){
        return this.numeroCompte;
    }

    public long getSolde(){
        return this.solde;
    }
    public String toString(){

        String soldeEnString = String.valueOf(this.solde);
        char[] tabCharSolde = soldeEnString.toCharArray();
        int soldeCentimes = Integer.parseInt(Character.toString(tabCharSolde[tabCharSolde.length-2]) + Character.toString(tabCharSolde[tabCharSolde.length-1]));
        long soldeEuro = this.solde / 100;

        return "Compte banquaire numéro : " + this.getNumeroCompte() + "\nTitulaire : " + this.getTitulaire().getNom() + "\nAdresse du titulaire : " + this.getTitulaire().getAdresse() + "\nSolde du compte : " + soldeEuro + "." + soldeCentimes + "€";
    }

    public void crediterCompte(long argentAjoute){
        this.solde += argentAjoute;
    }

    public void debiterCompte(long argentDebite){
        this.solde -= argentDebite;
    }




}
