package it.beije.magazzino.repository;

import it.beije.magazzino.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {



    public abstract Optional<Prodotto> findById(Integer id);

    public abstract List<Prodotto> findAll();

    public abstract List<Prodotto> findProdottoByTipologia(String tipo);

    public abstract List<Prodotto> findProdottoByNomeOrDescrizione(String nome, String descrizione);


}
