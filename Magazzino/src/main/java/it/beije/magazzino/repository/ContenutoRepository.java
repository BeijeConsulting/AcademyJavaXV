package it.beije.magazzino.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import it.beije.magazzino.model.ContenutoProdotto;
import it.beije.magazzino.model.Product;
import it.beije.magazzino.model.Spedizione;


@Repository
public interface ContenutoRepository extends JpaRepository<ContenutoProdotto, Integer>{
	

	
	 

	public abstract List<ContenutoProdotto> findBySpedizioneId(Integer id);
	
}
