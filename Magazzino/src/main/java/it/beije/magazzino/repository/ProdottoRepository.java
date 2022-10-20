package it.beije.magazzino.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.magazzino.model.Prodotto;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer>{
	
	public abstract List<Prodotto> findAll();
	public abstract Optional<Prodotto> findById(Integer id);
	public abstract void save(Prodotto prodotto);
	public abstract void save(Prodotto prodotto, Integer id);
	public abstract void delete(Prodotto prodotto);

}
