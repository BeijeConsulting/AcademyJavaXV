package it.beije.musicstore.repository;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {



    //SELECT h_alb.titolo, h_art.*  FROM hopper.album as
    // h_alb JOIN hopper.artista as h_art WHERE h_alb.id_artista = h_art.id ;

    public abstract List<Album> findAlbumByIdArtista(Integer idArtista);

    public abstract List<Album> findAll();


    //SELECT * FROM canzone c JOIN album a WHERE c.id_album=:idAlbum")

    //SELECT id FROM album as a WHERE a.titolo="Want Some?";
    @Query(nativeQuery = true, value="SELECT id FROM album a WHERE a.titolo=:nomeAlbum")
    public abstract Integer findIdByAlbumNome(@Param("nomeAlbum") String nomeAlbum);

}
