package it.beije.musicstore.repository;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

//    public abstract List<Artista> findByGenere(String genere);
//
//    public abstract List<Artista> findAll();
//
//    //Bad solution --> make a new Genere table..
//    @Query(nativeQuery = true, value="SELECT DISTINCT(  a.genere) FROM artista a")
//    public abstract List<String> listOfGenere();
//
//
//    public abstract List<Artista> findByNomeAndGenere(String nome, String genere);
//
//
//    public abstract List<Artista> findArtistaByGenere(String nome);


    //SELECT h_alb.titolo, h_art.*  FROM hopper.album as
    // h_alb JOIN hopper.artista as h_art WHERE h_alb.id_artista = h_art.id ;

    public abstract List<Album> findAlbumByIdArtista(Integer idArtista);

}
