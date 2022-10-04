package it.beije.hopper.ecommercedecataldo;

//Libreria per apertura e chiusura connessione al db
import static it.beije.hopper.gestorerubrica.Utilities.*;

//Bean JPA
import it.beije.hopper.ecommerce.Product;

//Librerie JPA
import javax.persistence.*;

//Strutture utili per ingresso e storage dati nel programma
import java.util.List;
import java.util.Scanner;

public class Ecommerce {
    static Scanner inpuTastiera;
    public static void main(String []args){
        visualizzaProdotti();
    }
    public static void visualizzaProdotti(){
        //Connessione al DB e query
        Query query = connessioneDB("hopper").createQuery("SELECT c FROM Product AS c");//Connessione al DB e query
        //Salvataggio query in ArrayList di oggetti Product
        List<Product> prodotti = query.getResultList();//Esecuzione query
        //Stampa dei risultati
        System.out.print("Ecco i prodotti disponibii");
        stampaRisultati(prodotti);
    }
    public static void registrazione(){
        inpuTastiera=new Scanner(System.in);//Istanziamento oggetto per input da terminale
        String email= null,password=null;//Dichiarazione variabili locali per la registrazione

        System.out.println("Registrazione nell'E-Commerce");
        System.out.println("Inserire la propria mail:" );
        email+=inpuTastiera.next();
        System.out.println("Inserire la propria una password:" );
        password+=inpuTastiera.next();

    }
}
