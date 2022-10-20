package it.beije.magazzino.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.magazzino.model.ContenutoSpedizione;

@Repository
public interface ContenutoSpedizioneRepository extends JpaRepository<ContenutoSpedizione, Integer> {

	public abstract List<ContenutoSpedizione> findByIdSpedizione(Integer id);
}
