package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RubricaMethodsHBM {
    Session session = HBMsessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    public static List<Contatto> listNoPrint() {
        Contatto contatto;
        Session session = HBMsessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
        List<Contatto> contatti = query.getResultList();
        session.close();
        return contatti;
    }

    public static List<Contatto> listaHBM() {
        Contatto contatto;
        Session session = HBMsessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
        List<Contatto> contatti = query.getResultList();

        for (Contatto c : contatti) {
            System.out.println(c);
        }
        session.close();
        return contatti;
    }


    public static ArrayList<Contatto> cercaContattoHBM(String nome) {
        Contatto contatto;
        Session session = HBMsessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ArrayList<Contatto> trovati = new ArrayList<>();
        Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
        List<Contatto> contatti = query.getResultList();

        for (Contatto c : contatti) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                trovati.add(c);
            }
        }
        System.out.println(trovati);
        session.close();
        return trovati;
    }

    public static void inserisciContattoHBM(Contatto contatto) {
        Session session = HBMsessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(contatto);
        transaction.commit();
        session.close();

    }

    public static void modificaContattoHBM(String campo, int id, String valore) throws ClassNotFoundException, SQLException {
            }
    public static void eliminaContattoHBM(Contatto contatto) {
        Session session = HBMsessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(contatto);
        transaction.commit();
        session.close();
    }
}