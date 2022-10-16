package it.beije.musicstore.repository;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Canzone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanzoneRepository extends JpaRepository<Canzone, Integer> {



    //SELECT h_alb.titolo, h_art.*  FROM hopper.album as
    // h_alb JOIN hopper.artista as h_art WHERE h_alb.id_artista = h_art.id ;
    public abstract List<Canzone> findAll();


    @Query(nativeQuery = true, value="SELECT * FROM canzone c JOIN album a WHERE c.id_album=:idAlbum")
    public abstract List<Canzone> findCanzoniFromAlbumId(@Param("idAlbum") Integer idAlbum);


}
