package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.lang.reflect.Type;
import java.util.*;

public class RubricaJPA2 {


    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
    static EntityManager entityManager = getConnection();

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
                    contatti.add(c);
                    System.out.println("Vuoi inserire un altro utente (s/n): ");
                } while (scanner.nextLine().trim().equalsIgnoreCase("s"));


                for (Contatto c : contatti) {
                    entityManager.persist(c);
                }
                break;

            }
            case "2":
                Query query = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY cognome");
                contatti.clear();
                contatti = query.getResultList();
                for (Contatto c : contatti) {
                    System.out.println(c.toString());
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
                Contatto contatto = entityManager.find(Contatto.class, Integer.parseInt(temp));;

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
                Contatto contatto = entityManager.find(Contatto.class, Integer.parseInt(temp));;
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
        RubricaJPA2 rubrica = new RubricaJPA2();
        rubrica.scanner();

    }
}
