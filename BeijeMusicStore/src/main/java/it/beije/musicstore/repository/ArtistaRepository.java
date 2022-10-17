package it.beije.musicstore.repository;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {

    Artista findByNome(String nome);
    List<Artista> findByGenere(String genere);


}
