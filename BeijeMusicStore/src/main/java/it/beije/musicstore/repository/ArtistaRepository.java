package it.beije.musicstore.repository;

import it.beije.musicstore.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer>{

    public abstract List<Artista> findByGenere(String genere);

    public abstract Optional<Artista> findById(Integer id);
}
