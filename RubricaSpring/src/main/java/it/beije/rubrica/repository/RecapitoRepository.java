package it.beije.rubrica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.rubrica.model.Recapito;

@Repository
public interface RecapitoRepository extends JpaRepository<Recapito, Integer>{


	public Optional<Recapito> findById(Integer id);
	public List<Recapito> findByRubricaId(Integer id);
}
