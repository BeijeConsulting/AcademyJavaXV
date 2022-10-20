package it.beije.magazzino.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.magazzino.model.Prodotto;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer>{

	List<Prodotto> findByTipologia(String tipologia);

	List<Prodotto> findByNome(String nome);

	List<Prodotto> findByNomeAndDescrizione(String nome, String descrizione);

	List<Prodotto> findByDescrizione(String descrizione);



	


}
