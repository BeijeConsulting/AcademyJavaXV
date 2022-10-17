package it.beije.musicstore.repository;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.service.AlbumService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    public abstract List<Album> findByIdArtista(int id);
    public abstract List<Album> findByGenere(String genere);
    @Query(nativeQuery = true, value = "SELECT * FROM album al JOIN canzone c ON c.idAlbum = al.id WHERE c.titolo = :canzone")

    public abstract List<Album> loadAlbumByCanzone(@Param("canzone") String canzone);

    public abstract List<Album> findAll();
//

}
