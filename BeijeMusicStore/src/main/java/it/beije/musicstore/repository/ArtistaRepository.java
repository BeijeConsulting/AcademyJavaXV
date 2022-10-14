package it.beije.musicstore.repository;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer>{

    public abstract List<Artista> findByGenere(String genere);

    public abstract Optional<Artista> findById(Integer id);

    @Query(nativeQuery = true, value = "SELECT DISTINCT genere FROM artista")//JDBC
    public abstract List<String> getallGeneri();

    public abstract Artista findByCanzoniContaining(Canzone canzone);
}
