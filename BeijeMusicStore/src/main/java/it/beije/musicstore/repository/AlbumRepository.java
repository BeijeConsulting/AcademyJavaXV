package it.beije.musicstore.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.musicstore.model.Album;




@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>{
	
	public abstract List<Album> findByArtistaId(Integer Artistaid);
	public abstract List<Album> findByGenere(String genre);
	public abstract Optional<Album> findById(Integer id);
}
