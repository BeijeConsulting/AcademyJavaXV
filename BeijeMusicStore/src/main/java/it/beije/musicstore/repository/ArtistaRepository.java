package it.beije.musicstore.repository;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
//

    public abstract List<Artista> findAll();
    public Artista findById(int id);

    public List<Artista> findByGenere(String genere);
    @Query(nativeQuery = true, value = "SELECT * FROM artista ar JOIN canzone c ON c.idArtista = ar.id WHERE c.titolo = :canzone")

    public abstract List<Artista> loadArtistaByCanzone(@Param("canzone") String canzone);

}
