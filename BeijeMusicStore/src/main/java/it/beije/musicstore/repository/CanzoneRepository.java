package it.beije.musicstore.repository;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Canzone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanzoneRepository extends JpaRepository<Canzone, Integer> {

    public abstract List<Canzone> findByIdArtista(int id);
    public abstract List<Canzone> findByIdAlbum(int id);
    public abstract List<Canzone> findAll();
}
