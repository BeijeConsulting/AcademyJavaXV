package it.beije.magazzino.repository;

import it.beije.magazzino.model.Prodotto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer>, ProdottoRepositoryCustom, JpaSpecificationExecutor<Prodotto> {
   Optional<Prodotto> findById(Integer id);

    List<Prodotto> findByTipologia(String tipologia);

    List<Prodotto> findByNomeOrDescrizione(String nome, String descrizione);

    static Specification<Prodotto> morethatQuantita(Integer quantita) {
        return (prodottoRoot, cq, cb) -> cb.greaterThanOrEqualTo(prodottoRoot.get("quantita"), quantita);
    }

    static Specification<Prodotto> nomeContains(String nome) {
        return (prodottoRoot, cq, cb) -> cb.like(prodottoRoot.get("nome"), "%" + nome + "%");
    }
}
