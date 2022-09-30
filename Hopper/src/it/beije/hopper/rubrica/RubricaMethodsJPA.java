package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;
import it.beije.hopper.Recapito;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class RubricaMethodsJPA {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction entityTransaction = entityManager.getTransaction();

    public static List<Contatto> listJPA() {
        Contatto contatto;
        Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
        List<Contatto> contatti = query.getResultList();
        for (Contatto c : contatti) {
            System.out.println(c);
        }
//        entityManager.close();
        return contatti;
    }

    public static void inserisciContattoJPA(Contatto contatto) {
        entityTransaction.begin();
        entityManager.persist(contatto);
        entityTransaction.commit();
    }

    public static void newInserisciContattoJPA(Contatto contatto, ArrayList<Recapito> recapiti) {
        entityTransaction.begin();
        entityManager.persist(contatto);
        entityTransaction.commit();
        for (Recapito r : recapiti) {
            r.setRubrica_id(contatto.getId());
            entityTransaction.begin();
            entityManager.persist(r);
            entityTransaction.commit();
        }
    }

    public static ArrayList<Contatto> cercaContattoJPA(String valore) {
        Contatto contatto = null;
        ArrayList<Contatto> trovati = new ArrayList<>();
        Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
        List<Contatto> contatti = query.getResultList();

        for (Contatto c : contatti) {
            if (c.getNome().equalsIgnoreCase(valore) || c.getCognome().equalsIgnoreCase(valore) || c.getTelefono().equalsIgnoreCase(valore) || c.getEmail().equalsIgnoreCase(valore) || c.getNote().equalsIgnoreCase(valore)) {
                trovati.add(c);
            }
        }
        System.out.println(trovati);
        return trovati;
    }

    public static void modificaContattoJPA(String campo, String valore, int id) {
        entityTransaction.begin();
        Contatto contatto = null;
        Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
        List<Contatto> contatti = query.getResultList();
        contatto = entityManager.find(Contatto.class, id);
        switch (campo.toLowerCase()) {
            case "nome": {
                contatto.setNome(valore);
                entityManager.persist(contatto);
                entityTransaction.commit();
                break;
            }
            case "cognome": {
                contatto.setCognome(valore);
                entityManager.persist(contatto);
                entityTransaction.commit();
                break;
            }
            case "telefono": {
                contatto.setTelefono(valore);
                entityManager.persist(contatto);
                entityTransaction.commit();
                break;
            }
            case "email": {
                contatto.setEmail(valore);
                entityManager.persist(contatto);
                entityTransaction.commit();
                break;
            }
            case "note": {
                contatto.setNote(valore);
                entityManager.persist(contatto);
                entityTransaction.commit();
                break;
            }
            default: {
                System.out.println("Campo errato");
                break;
            }
        }
    }

    public static void eliminaContattoJPA(int id) {
        entityTransaction.begin();
        Contatto contatto = entityManager.find(Contatto.class, id);
        entityManager.remove(contatto);
        entityTransaction.commit();
    }

}
