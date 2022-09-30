package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;
import it.beije.hopper.Recapito;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rubrica$2 {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static EntityManager getConnection() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
        return entityManagerFactory.createEntityManager();
    }

    public void scanner() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\n\n\tInserisci opzione: " +
                "\n1/ Inserisci nuovo contatto nella rubrica " +
                "\n2/ Vedi la rubrica completa " +
                "\n3/ Cerca tramite referenza " +
                "\n4/ Aggiorna un contatto " +
                "\n5/ Cancella un contatto " +
                "\n6/ Esci dal sistema ");
        List<Contatto> contatti = new ArrayList<>();
        List<Recapito> recapiti = new ArrayList<>();
        String line = scanner.nextLine().trim();  // Read user input
        switch (line) {
            case "1": {
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();

                do {
                    Contatto c = new Contatto();
                    System.out.println("Inserisci Nome: ");
                    c.setNome(scanner.nextLine() + " ");
                    System.out.println("Inserisci cognome: ");
                    c.setCognome(scanner.nextLine() + " ");
                    System.out.println("Inserisci Note: ");
                    c.setNote(scanner.nextLine() + " ");

                    recapiti.clear();
                    System.out.println("Vuoi inserire un recapito dell'utente (s/n): ");
                    String risposta = scanner.nextLine().trim();
                    while (risposta.equalsIgnoreCase("s")) {
                        Recapito recapito = new Recapito();
                        System.out.println("Inserisci Recapito: ");
                        recapito.setRecapito(scanner.nextLine() + " ");
                        System.out.println("Inserisci il tipo: ");
                        recapito.setTipo(scanner.nextLine() + " ");
                        System.out.println("Inserisci la descrizione: ");
                        recapito.setDesc(scanner.nextLine() + " ");
                        recapiti.add(recapito);
                        System.out.println("Vuoi inserire un recapito dell'utente (s/n): ");
                        risposta = scanner.nextLine().trim();

                    }
                    entityManager.persist(c);
                    for (Recapito recapito : recapiti) {
                        recapito.setContatto(c);
                        entityManager.persist(recapito);
                    }
                    System.out.println("Vuoi inserire un altro utente (s/n): ");
                } while (scanner.nextLine().trim().equalsIgnoreCase("s"));
                entityManager.getTransaction().commit();
                break;

            }
            case "2":
                Query query = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY cognome");
                contatti.clear();
                contatti = query.getResultList();
                for (Contatto c : contatti) {
                    System.out.println(c.toString());
                }
                System.out.println("Inserisci id dell'utente che voi vedere: ");
                String risposta = scanner.nextLine().trim();
                query = entityManager.createQuery("SELECT r FROM Recapito as r WHERE rubrica_id=" + Integer.parseInt(risposta));
                recapiti.clear();
                recapiti = query.getResultList();
                for (Recapito r : recapiti) {
                    System.out.println(r.toString());
                }
                break;

            case "3": {
                System.out.println("Inserisci Referenza del contatto: ");
                String temp = scanner.nextLine();
                Query query3 = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY cognome");
                contatti.clear();
                contatti = query3.getResultList();

                for (Contatto c : contatti) {
                    if (c.toString().toLowerCase().contains(temp.trim().toLowerCase())) {
                        System.out.println(c.toString());
                    }
                }
                System.out.println("Inserisci id dell'utente che voi vedere: ");
                String risposta2 = scanner.nextLine().trim();
                query = entityManager.createQuery("SELECT r FROM Recapito as r WHERE r.rubrica_id=" + Integer.parseInt(risposta2));
                recapiti.clear();
                recapiti = query.getResultList();
                for (Recapito r : recapiti) {
                    System.out.println(r.toString());
                }
                break;
            }
            case "4": {
                System.out.println("Vuoi prima cercare il contatto che vuoi aggiornare(S/N): ");
                String temp = scanner.nextLine();
                Query query3 = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY cognome");
                contatti.clear();
                contatti = query3.getResultList();
                if (temp.equalsIgnoreCase("s")) {
                    System.out.println("Inserisci Referenza del contatto che vuoi aggiornare: ");
                    temp = scanner.nextLine();
                    for (Contatto c : contatti) {
                        if (c.toString().toLowerCase().contains(temp.trim().toLowerCase())) {
                            System.out.println(c.toString());
                        }
                    }
                } else {
                    for (Contatto c : contatti) {
                        System.out.println(c.toString());
                    }
                }
                System.out.println("Inserisci ID del contatto che vuoi aggiornare: ");
                temp = scanner.nextLine();
                Contatto contatto = entityManager.find(Contatto.class, Integer.parseInt(temp));
                ;

                System.out.println("Inserisci Nome: ");
                contatto.setNome(scanner.nextLine() + " ");
                System.out.println("Inserisci cognome: ");
                contatto.setCognome(scanner.nextLine() + " ");
                System.out.println("Inserisci Telefono: ");
                contatto.setTelefono(scanner.nextLine() + " ");
                System.out.println("Inserisci Email: ");
                contatto.setEmail(scanner.nextLine() + " ");
                System.out.println("Inserisci Note: ");
                contatto.setNote(scanner.nextLine() + " ");
                entityManager.persist(contatto);
                break;
            }
            case "5": {
                System.out.println("Vuoi prima cercare il contatto che vuoi eliminare(S/N): ");
                String temp = scanner.nextLine();
                Query query3 = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY cognome");
                contatti.clear();
                contatti = query3.getResultList();
                if (temp.equalsIgnoreCase("s")) {
                    System.out.println("Inserisci Referenza del contatto che vuoi eliminare: ");
                    temp = scanner.nextLine();
                    for (Contatto c : contatti) {
                        if (c.toString().toLowerCase().contains(temp.trim().toLowerCase())) {
                            System.out.println(c.toString());
                        }
                    }
                } else {
                    for (Contatto c : contatti) {
                        System.out.println(c.toString());
                    }
                }
                System.out.println("Inserisci ID del contatto che vuoi eliminare: ");
                temp = scanner.nextLine();
                Contatto contatto = entityManager.find(Contatto.class, Integer.parseInt(temp));
                ;
                entityManager.remove(contatto);
                break;
            }
            case "6": {
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
        Rubrica$2 rubrica = new Rubrica$2();
        rubrica.scanner();

    }
}
