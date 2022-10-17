package it.beije.musicstore.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.musicstore.model.Artista;


@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer>{
	
	public abstract List<Artista> findByGenere(String genere);
	public abstract Optional<Artista> findById(Integer id); 
	
}
