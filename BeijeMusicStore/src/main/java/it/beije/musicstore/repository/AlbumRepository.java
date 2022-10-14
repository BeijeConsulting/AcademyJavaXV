package it.beije.musicstore.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.musicstore.model.Album;




@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>{
	
	public abstract List<Album> findByArtistaId(Integer id);
	public abstract List<Album> findByGenere(String genre);
	
}
