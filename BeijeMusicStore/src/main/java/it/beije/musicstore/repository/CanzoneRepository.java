package it.beije.musicstore.repository;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CanzoneRepository extends JpaRepository<Canzone, Integer>{

    @Query(nativeQuery = true, value = "SELECT * FROM canzone WHERE album_id = :album_id")//JDBC
    public abstract List<Canzone> findByAlbum(@Param("album_id") int album_id);

    @Query(nativeQuery = true, value = "SELECT * FROM canzone WHERE artista_id = :artista_id")//JDBC
    public abstract List<Canzone> findByArtista(@Param("artista_id") int artista_id);

    public abstract List<Canzone> findByGenere(String genere);

    public abstract Artista findArtistaById(Integer id);

    @Query(nativeQuery = true, value = "SELECT DISTINCT genere FROM canzone")//JDBC
    public abstract List<String> getallGeneri();
}
