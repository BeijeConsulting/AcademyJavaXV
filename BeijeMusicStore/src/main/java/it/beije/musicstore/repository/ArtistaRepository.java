package it.beije.musicstore.repository;

import it.beije.musicstore.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArtistaRepository  extends JpaRepository<Artista, Integer> {
    public Artista findByNome(String nome);

}

