package it.beije.musicstore.repository;

import it.beije.musicstore.model.Canzone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanzoneRepository extends JpaRepository<Canzone, Integer> {

    public abstract List<Canzone> findCanzoneById_album(Integer id_album);

    public abstract List<Canzone> findCanzonesById_album(Integer id_album);

    public abstract List<Canzone> findCanzonesById_artista(Integer id_artista);
}
