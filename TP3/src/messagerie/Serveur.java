package messagerie;

import java.util.*;

public class Serveur {

    private String nom;
    private ArrayList<Message> listeMessages;

    public Serveur(String nom){
        this.nom = nom;
        this.listeMessages = new ArrayList<>();
    }

    public void posterMessage(Message message){
        this.listeMessages.add(message);
    }

    public ArrayList<Message> creerListeMsgClient(String client){
        ArrayList<Message> listeMsgClient = new ArrayList<>();
        for (Message m : listeMessages){
            if (m.getDestinataire().equals(client)){
                listeMsgClient.add(m);
            }
        }
        Collections.reverse(listeMsgClient);
        return listeMsgClient;
    }

    public static String saisirServeur(){

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Insérez le nom du serveur à rejoindre : ");

        return scanner.nextLine();

    }



}
