package it.beije.musicstore.repository;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>{


    public abstract List<Album> findByGenere(String genere);

    @Query(nativeQuery = true, value = "SELECT * FROM album WHERE artista_id = :artista_id")//JDBC
    public abstract List<Album> findByArtista(@Param("artista_id") int artista_id);

    @Query(nativeQuery = true, value = "SELECT DISTINCT genere FROM album")//JDBC
    public abstract List<String> getallGeneri();

}
