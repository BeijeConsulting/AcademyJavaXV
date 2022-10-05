package it.beije.hopper.ecommercedecataldo;

//Libreria per apertura e chiusura connessione al db
import static it.beije.hopper.gestorerubrica.Utilities.*;

//Bean JPA
import it.beije.hopper.ecommerce.Product;
import it.beije.hopper.ecommerce.User;

//Librerie JPA
import javax.persistence.*;

//Strutture utili per input e storage dati nel programma
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Ecommerce {
    public static void main(String []args){
        visualizzaProdottiDisponibili();
    }
    public static void visualizzaProdottiDisponibili(){
        //Connessione al DB e query
        Query query = connessioneDB("hopper").createQuery("SELECT c FROM Product AS c");//Connessione al DB e query
        //Salvataggio query in ArrayList di oggetti Product
        List<Product> prodotti = query.getResultList();//Esecuzione query
        //Stampa dei risultati
        System.out.print("Ecco i prodotti disponibii nel negozio");
        stampaRisultati(prodotti);
    }
    public static void creaOrdine(){

    }


}
