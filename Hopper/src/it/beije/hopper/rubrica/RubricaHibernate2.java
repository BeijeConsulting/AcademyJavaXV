package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubricaHibernate2 {

    public static Session getConnection() {
        Session session = HBMsessionFactory.openSession();
        System.out.println("session is open? " + session.isOpen());
        Transaction transaction = session.beginTransaction();
        return session;
    }

    public void scanner() {
        Session session = getConnection();
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\n\n\tInserisci opzione: \n1/ Inserisci nuovo contatto nella rubrica \n2/ Vedi la rubrica completa \n3/ Cerca tramite referenza \n4/ Esci dal sistema ");
        List<Contatto> contattoList = new ArrayList<>();
        String line = scanner.nextLine().trim();  // Read user input
        switch (line) {
            case "1": {

                do {
                    Contatto c = new Contatto();
                    System.out.println("Inserisci Nome: ");
                    c.setNome(scanner.nextLine() + " ");
                    System.out.println("Inserisci cognome: ");
                    c.setCognome(scanner.nextLine() + " ");
                    System.out.println("Inserisci Telefono: ");
                    c.setTelefono(scanner.nextLine() + " ");
                    System.out.println("Inserisci Email: ");
                    c.setEmail(scanner.nextLine() + " ");
                    System.out.println("Inserisci Note: ");
                    c.setNote(scanner.nextLine() + " ");
                    contattoList.add(c);
                    System.out.println("Vuoi inserire un altro utente (s/n): ");
                } while (scanner.nextLine().trim().equalsIgnoreCase("s"));


                for (Contatto c : contattoList) {
                    session.save(c);
                }
                break;

            }
            case "2":
                Query<Contatto> query = session.createQuery("SELECT DISTINCT c FROM Contatto as c");
                contattoList.clear();
                contattoList = query.getResultList();
                for (Contatto c : contattoList) {
                    System.out.println(c.toString());
                }
                break;

            case "3": {
                System.out.println("Inserisci Referenza del contatto: ");
                String temp = scanner.nextLine();
                Query<Contatto> query3 = session.createQuery("SELECT DISTINCT c FROM Contatto as c");
                contattoList.clear();
                contattoList = query3.getResultList();

                for (Contatto c : contattoList) {
                    if (c.toString().toLowerCase().contains(temp.trim().toLowerCase())) {
                        System.out.println(c.toString());
                    }
                }
                break;
            }
            case "4": {
                System.out.println(":D");
                System.exit(1);
                break;
            }
            default: {
                System.out.println("Parametro sbagliato, inserisci un valore valido");

                break;
            }
        }
        scanner();

    }

    public static void main(String[] args) {
        RubricaHibernate2 rubrica = new RubricaHibernate2();
        rubrica.scanner();

    }
}
