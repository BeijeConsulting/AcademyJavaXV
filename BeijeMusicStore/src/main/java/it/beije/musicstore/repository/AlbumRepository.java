package it.beije.musicstore.repository;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.service.AlbumService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    public abstract List<Album> findByIdArtista(int id);
    public abstract List<Album> findByGenere(String genere);
    public abstract List<Album> findAll();
//

}
