package it.beije.hopper.gestorerubrica;

import it.beije.hopper.ecommerce.Product;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.logging.Level;

import java.util.List;

public class Utilities {
    public static EntityManager connessioneDB(String db){//Apertura connessione Database
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//Istruzione per impedire logging di Hibernate
        return  Persistence.createEntityManagerFactory(db).createEntityManager();//Ritorno connessione al DB tramite JPA
    }
    public static void chiusuraConnessioneDB(EntityManager db){//Chiusura della connessione al Database
        db.close();
    }
    public static void stampaRisultati(List<Product> prodotti){//Stampa lista data in ingresso
        for (Product c : prodotti){
            System.out.print("\n\t");
            System.out.print(c.toString());
        }
        System.out.print("\n");
    }
}
