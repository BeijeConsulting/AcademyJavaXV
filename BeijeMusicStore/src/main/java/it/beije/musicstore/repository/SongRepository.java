package it.beije.musicstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import it.beije.musicstore.model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM canzone WHERE id_album = :id_album")//JDBC
	public abstract List<Song> loadByAlbum(@Param("id_album") int id_album);
	
	@Query(nativeQuery = true, value = "SELECT * FROM canzone WHERE id_artist = :id_artist")//JDBC
	public abstract List<Song> loadByArtist(@Param("id_artist") int id_artist);
	
}
