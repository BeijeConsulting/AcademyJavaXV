package it.beije.musicstore.repository;

import it.beije.musicstore.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CanzoneRepository extends JpaRepository<Artista, Integer>{

}
