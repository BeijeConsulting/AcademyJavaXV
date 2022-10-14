package it.beije.musicstore.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.musicstore.model.Canzone;


@Repository
public interface CanzoneRepository extends JpaRepository<Canzone, Integer>{
	
	public abstract List<Canzone> findByAlbumId(Integer album);
	public abstract List<Canzone> findByArtistaId(Integer artist);
	public abstract List<Canzone> findByGenere(String genere);
}
