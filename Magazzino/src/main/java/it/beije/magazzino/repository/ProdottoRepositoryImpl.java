package it.beije.magazzino.repository;

import it.beije.magazzino.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdottoRepositoryImpl implements ProdottoRepositoryCustom{
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Prodotto> findByNomeAndDescrizione(String nome, String descrizione) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Prodotto> cq = cb.createQuery(Prodotto.class);

        Root<Prodotto> prodottoRoot = cq.from(Prodotto.class);
        List<Predicate> predicates = new ArrayList<>();

        if (nome != null) {
            predicates.add(cb.equal(prodottoRoot.get("nome"), nome));
        }
        if (descrizione != null) {
            predicates.add(cb.like(prodottoRoot.get("descrizione"), "%" + descrizione + "%"));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }

    @Override
        public List<Prodotto> findByTipologiaAndQuantita(String tipologia, Integer quantita) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Prodotto> cq = cb.createQuery(Prodotto.class);

        Root<Prodotto> prodottoRoot = cq.from(Prodotto.class);
        List<Predicate> predicates = new ArrayList<>();

        if (tipologia != null) {
            predicates.add(cb.like(prodottoRoot.get("tipologia"),"%"  + tipologia + "%"));
        }
        if (quantita != null) {
            predicates.add(cb.greaterThanOrEqualTo(prodottoRoot.get("quantita"),  quantita));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }

}
