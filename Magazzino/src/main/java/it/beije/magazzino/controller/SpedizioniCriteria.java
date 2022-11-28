package it.beije.magazzino.controller;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.model.Spedizione;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class SpedizioniCriteria {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("magazzino");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction entityTransaction = entityManager.getTransaction();

    public static List<Spedizione> allSpedizioniCriteria() {
        EntityManager entityManagerNuovo = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManagerNuovo.getCriteriaBuilder();
        CriteriaQuery<Spedizione> q = cb.createQuery(Spedizione.class);
        Root<Spedizione> c = q.from(Spedizione.class);
        q.select(c);
        List<Spedizione> spedizioni = entityManagerNuovo.createQuery(q).getResultList();
        return spedizioni;
    }

    public static Spedizione productByIdCriteria(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Spedizione> q = cb.createQuery(Spedizione.class);
        Root<Spedizione> c = q.from(Spedizione.class);
        q.select(c).where(cb.equal(c.get("id"), id));
        Spedizione spedizione = entityManager.createQuery(q).getSingleResult();
        return spedizione;
    }
}
