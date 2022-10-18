package it.beije.musicstore.controller;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.AlbumService;
import it.beije.musicstore.service.ArtistaService;

import it.beije.musicstore.service.CanzoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class MusicRestController {
    @Autowired
    private ArtistaService artistaService;
    @Autowired
    private AlbumService albumService;

    public MusicRestController() {
        System.out.println("creazione oggetto MusicController...");
    }

    /* Restituisce la canzone, dato l'album in input via metodo GET*/
    @GetMapping(value="/album/canzone/nomeAlbum/{nomeAlbum}")
    public Album findSongByAlbum(@PathVariable(name="nomeAlbum") String nomeAlbum){
        return albumService.findByAlbum(nomeAlbum);
    }

    /* Restituisce l'artista, dato il genere in input via metodo GET*/
    @GetMapping(value="/genere/{genere}")
    public List<Artista> findByGenere(@PathVariable(name="genere") String genere){
        return artistaService.findByGenere(genere);
    }

    /* Restituisce l'album, dato l'artista in input via metodo GET */
    @GetMapping(value="/album/artista/nomeArtista/{nomeArtista}")
    public List<Album> albumByArtist(@PathVariable(name="nomeArtista") String nomeArtista){
        return artistaService.findByNome(nomeArtista).getAlbumArtista();
    }

}
