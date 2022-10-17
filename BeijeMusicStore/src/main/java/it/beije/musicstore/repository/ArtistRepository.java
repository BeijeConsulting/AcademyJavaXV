package it.beije.musicstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.musicstore.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{

	//public abstract Artist findByName(String name);
	//public abstract List<Product> findAll();
	
	//public abstract List<Artist> findByGenre(String genre);
	
	@Query(nativeQuery = true, value = "SELECT * FROM artista WHERE genre = :genre")//JDBC
	public abstract List<Artist> loadByGenre(@Param("genre") String genre);
	
	@Query(nativeQuery = true, value = "SELECT * FROM artista WHERE name = :name")//JDBC
	public abstract Artist loadByName(@Param("name") String name);
	
	@Query(nativeQuery = true, value = "SELECT * FROM artista")//JDBC
	public abstract List<Artist> loadAllArtist();
	
	
//	@Query(nativeQuery = true, value = "SELECT * FROM artista")//JDBC
//	public abstract List<Artist> loadByGenre();
	
}
