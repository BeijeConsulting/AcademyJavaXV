package it.beije.magazzino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.magazzino.model.Prodotto;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer>{

}
