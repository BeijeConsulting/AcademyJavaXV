package it.beije.musicstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.musicstore.model.Album;




@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM album WHERE id_artist = :id_artist")//JDBC
	public abstract List<Album> loadByArtist(@Param("id_artist") int id_artist);
	
	@Query(nativeQuery = true, value = "SELECT * FROM album")//JDBC
	public abstract List<Album> loadAllAlbum();
	
	@Query(nativeQuery = true, value = "SELECT * FROM album WHERE title = :title")//JDBC
	public abstract Album loadIdAlbumByTitle(@Param("title") String title);
	
	@Query(nativeQuery = true, value = "SELECT * FROM album WHERE genre = :genre")//JDBC
	public abstract List<Album> loadAlbumByGenre(@Param("genre") String genre);
	
	@Query(nativeQuery = true, value = "SELECT * FROM album WHERE id = :id")//JDBC
	public abstract Album loadById(@Param("id") int id);
	
}
