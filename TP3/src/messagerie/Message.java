package messagerie;

public class Message {

    private String expediteur;
    private String destinataire;
    private String contenu;

    public Message(String expediteur, String destinataire, String contenu){
        this.expediteur = expediteur;
        this.destinataire = destinataire;
        this.contenu = contenu;
    }

    public String getExpediteur(){
        return this.expediteur;
    }

    public String getContenu(){
        return this.contenu;
    }

    public String getDestinataire(){
        return this.destinataire;
    }

    public String toString(){

        return "------------------------------------------------------------\nMessage de " + this.expediteur + "\n\n" + contenu;

    }
}
