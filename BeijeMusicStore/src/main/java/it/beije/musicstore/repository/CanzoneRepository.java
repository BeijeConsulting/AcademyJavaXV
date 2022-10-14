package it.beije.musicstore.repository;

import it.beije.musicstore.model.Canzone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanzoneRepository  extends JpaRepository<Canzone, Integer>{

}
