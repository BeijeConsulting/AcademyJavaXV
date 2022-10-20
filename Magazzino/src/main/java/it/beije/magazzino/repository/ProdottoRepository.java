package it.beije.magazzino.repository;

import it.beije.magazzino.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto,Integer>{

    public abstract List<Prodotto> findBynome(String nome);
    public abstract List<Prodotto> findtipologia(String tipologia);
    public abstract Optional<Prodotto> findById(Integer id);


}