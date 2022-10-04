package it.beije.hopper.gestorerubrica;


import it.beije.hopper.Contatto;
import static it.beije.hopper.gestorerubrica.Utilities.*;

import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;




public class GestoreRubrica {
    static Scanner s; //Si utilizza una variabile statica dato che si ha bisogno della sua disponibilità oltre il solo metodo main
    public static void main(String[] args){
        System.out.println("GESTORE DEI CONTATTI: RUBRICA \n");
        menu();
    }
    public static void menu(){//Menu' Scelta delle azioni possibili in un gestore di rubrica
        int scelta=2;
        s = new Scanner(System.in);
        while(scelta!=0){
            System.out.println("Azioni Disponibili:");
            System.out.println("\t1. Visualizza i contatti\n" + "\t2. Cerca un contatto\n" + "\t3. Inserisci un nuovo contatto\n" +
                "\t4. Modifica contatto esistente\n" + "\t5. Cancella Contatto\n" + "\t6.Trova contatti duplicati\n" + "\t7.Unisci i contatti\n"
                + "\t8.Esporta su un file XML\n" + "\t9.Esporta su un file CSV\n" + "\t10.Importa da un file CSV\n" + "\t11.Importa da un file XML\n"+
                    " Per uscire dal programma premere 0\n ");
            System.out.println("Inserisci la tua scelta:");
            scelta = Integer.parseInt(s.next());
            switch (scelta) {
                default:
                    System.out.println("Scelta non valida, selezionare una scelta nel menu'");
                    break;
                case 0:
                    System.out.println("Ciao Ciao ");
                    break;
                case 1:
                    visualizzaContatti();
                    break;
                case 2:
                    cercaContatto();
                    break;
                case 3:
                    System.out.println("Inserisci nuovo contatto");
                    nuovoContatto();
                    break;
                case 4:
                    System.out.println("Modifica contatto");
                    break;
                case 5:
                    System.out.println("Cancella contatto");
                    break;
                case 6:
                    System.out.println("Trova contatti duplicati");
                    break;
                case 7:
                    System.out.println("Unisci i contatti");
                    break;
                case 8:
                    System.out.println("Esporta su file XML");
                    break;
                case 9:
                    System.out.println("Esporta su file CSV");
                    break;
                case 10:
                    System.out.println("Importa da un file CSV");
                    break;
                case 11:
                    System.out.println("Importa da un file XML");
                    break;
            }
        }
        s.close();
    }
    public static void visualizzaContatti() {//Visualizzazione dei contatti presenti nel DB
        System.out.println("Visualizzazione dei contatti\n\t");
        //SELECT JPQL
        Query query = connessioneDB("hopper").createQuery("SELECT c FROM Contatto as c");//Connessione al DB e query
        List<Contatto> contatti = query.getResultList();//Esecuzione query
        stampaRisultati(contatti);
        chiusuraConnessioneDB(connessioneDB("hopper"));//Chiusura connessione al DB
    }
    public static void cercaContatto(){//Manca solamente input per ricerca contatti
        int u=4;
        s = new Scanner(System.in);
        while(u!=0) {
            System.out.println("Ricerca contatto nel DB");
            System.out.println("\tSelezionare criteri di ricerca");
            System.out.println("\t\t1.Per Nome e Cognome"+"\n\t\t2.Per Nome Cognome e Email"+ "\n\t\t3.Per Nome Cognome e Telefono"+
                    "\n\t\t4.Per contatto completo\n"+"\nPremere 0 per uscire dal programma\n");
            System.out.println("Inserisci la tua scelta:");
            u = Integer.parseInt(s.next());
            switch (u){
                default:
                    System.out.println("Scelta errata");
                    break;
                case 1:
                    //Ricerca per nome e cognome
                    ricercaDato("Pippo","Verdi");
                    break;
                case 2:
                    //Ricerca per nome cognome e mail
                    ricercaDatoEmail("Pippo","Verdi","r.bianchi@beije.it");
                    break;
                case 3:
                    //Ricerca per nome cognome e telefono
                    ricercaDatoTelefono("Pippo","Verdi","325235252");
                    break;
                case 4:
                    //Ricerca per nome cognome telefono e mail
                    ricercaDatoCompleto("Pippo","Verdi","325235252","r.bianchi@beije.it");
            }
        }
    }
    public static void nuovoContatto(){
        Contatto nuovoContatto=new Contatto();
        boolean esito=inserimentoDati(nuovoContatto);
    }
    /*------------------------------------------------------METODI-UTILITA'----------------------------------------------------------*/
    public static void ricercaDato(String nome, String cognome){//Ricerca dati forniti in ingresso
        StringBuilder querystr= new StringBuilder("SELECT c FROM Contatto AS c WHERE")//Creazione query con dati forniti in ingresso
                .append(" c.cognome like").append("'").append(cognome).append("'")
                .append("AND c.nome like").append("'").append(nome).append("'");
        Query query = connessioneDB("hopper").createQuery(querystr.toString());//Connessione al DB e query
        List<Contatto> contatti = query.getResultList();//Esecuzione query
        System.out.println("Ecco i risultati della ricerca");
        for (Contatto c : contatti){
            System.out.println(c.toString());
        }
        chiusuraConnessioneDB(connessioneDB("hopper"));//Chiusura connessione al DB
    }
    public static void ricercaDatoEmail(String nome, String cognome, String email){//Ricerca dati forniti in ingresso
        StringBuilder querystr= new StringBuilder("SELECT c FROM Contatto AS c WHERE")//Creazione query con dati forniti in ingresso
                .append(" 1c.cognome like").append("'").append(cognome).append("'")
                .append("AND c.nome like").append("'").append(nome).append("'")
                .append("AND c.email like").append("'").append(email).append("'");
        Query query = connessioneDB("hopper").createQuery(querystr.toString());//Connessione al DB e query
        List<Contatto> contatti = query.getResultList();//Esecuzione query
        System.out.println("Ecco i risultati della ricerca");
        stampaRisultati(contatti);
        chiusuraConnessioneDB(connessioneDB("hopper"));//Chiusura connessione al DB
    }
    public static void ricercaDatoTelefono(String nome, String cognome, String telefono){//Ricerca dati forniti in ingresso
        StringBuilder querystr= new StringBuilder("SELECT c FROM Contatto AS c WHERE")//Creazione query con dati forniti in ingresso
            .append(" c.cognome like").append("'").append(cognome).append("'")
            .append("AND c.nome like").append("'").append(nome).append("'")
            .append("AND c.telefono like").append("'").append(telefono).append("'");
        Query query = connessioneDB("hopper").createQuery(querystr.toString());//Connessione al DB e query
        List<Contatto> contatti = query.getResultList();//Esecuzione query
        stampaRisultati(contatti);
        chiusuraConnessioneDB(connessioneDB("hopper"));//Chiusura connessione al DB
    }
    public static void ricercaDatoCompleto(String nome, String cognome, String telefono,String email){//Ricerca dati forniti in ingresso
        StringBuilder querystr= new StringBuilder("SELECT c FROM Contatto AS c WHERE ")//Creazione query con dati forniti in ingresso
                .append("c.cognome like").append("'").append(cognome).append("'")
                .append("AND c.nome like").append("'").append(nome).append("'")
                .append("AND c.telefono like").append("'").append(telefono).append("'")
                .append("AND c.email like").append("'").append(email).append("'");
        Query query = connessioneDB("hopper").createQuery(querystr.toString());//Connessione al DB e query
        List<Contatto> contatti = query.getResultList();//Esecuzione query
        System.out.println("Ecco i risultati della ricerca");
        stampaRisultati(contatti);
        chiusuraConnessioneDB(connessioneDB("hopper"));//Chiusura connessione al DB
    }
    public static void stampaRisultati(List<Contatto> contatti){//Stampa lista data in ingresso
        for (Contatto c : contatti){
            System.out.println(c.toString());
        }
    }
    public static boolean inserimentoDati(Contatto c){
        connessioneDB("hopper").getTransaction().begin();
        s = new Scanner(System.in);
        /*Popolazione campi dell'oggetto Contatto*/
        System.out.println("Inserisci il nome del contatto:");//Nome
        c.setNome(s.next());
        System.out.println("Inserisci il cognome del contatto:");//Cognome
        c.setCognome(s.next());
        System.out.println("Inserisci il numero di telefono del contatto:");//Telefono
        c.setTelefono(s.next());
        System.out.println("Inserisci il Email del contatto:");//Email
        c.setEmail(s.next());
        System.out.println("Inserisci eventuali note sul contatto:");//Note
        c.setNote(s.next());
        s.close();//Chiusura input da tastiera
        connessioneDB("hopper").persist(c);//Mette in scrittura il nuovo contatto sul db
        connessioneDB("hopper").getTransaction().commit();//Esegue l'aggiunta del contatto nel db
        chiusuraConnessioneDB(connessioneDB("hopper"));//Chiusura della connessione al db
        return true;
    }
}

