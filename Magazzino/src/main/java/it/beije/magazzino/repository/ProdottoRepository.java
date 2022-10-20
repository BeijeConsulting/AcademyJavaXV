package it.beije.magazzino.repository;

import it.beije.magazzino.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {

    public abstract Prodotto findById(int id);
    public abstract List<Prodotto> findAll();

}
