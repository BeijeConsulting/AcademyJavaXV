package it.beije.magazzino.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.magazzino.model.Prodotto;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer>{

    public abstract List<Prodotto> findAll();
    public abstract Prodotto getById(Integer id);
    public abstract Prodotto getProdottoByType(String tipologia);
    public abstract Prodotto getProdottoByName(String nome);

}
