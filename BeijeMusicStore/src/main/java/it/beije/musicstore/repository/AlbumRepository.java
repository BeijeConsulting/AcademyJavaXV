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
}
