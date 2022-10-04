package it.beije.hopper.gestorerubrica;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.logging.Level;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;
public class Utilities {
    public static EntityManager connessioneDB(String db){//Apertura connessione Database
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//Istruzione per impedire logging di Hibernate
        return  Persistence.createEntityManagerFactory(db).createEntityManager();//Ritorno connessione al DB tramite JPA
    }
    public static void chiusuraConnessioneDB(EntityManager db){//Chiusura della connessione al Database
        db.close();
    }
}
