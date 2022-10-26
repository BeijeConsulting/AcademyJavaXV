package it.beije.magazzino.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.magazzino.model.Spedizione;

@Repository
public interface SpedizioneRepository extends JpaRepository<Spedizione, Integer>{

	
}
