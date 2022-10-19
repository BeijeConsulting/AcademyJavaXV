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

    @Autowired
    private CanzoneService canzoneService;
    public MusicRestController() {
        System.out.println("creazione oggetto MusicController...");
    }
    /* Stampa dei dati presenti sul database */
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
    /* Inserimento dati nel database */
    /* Inserisce la canzone, data una canzone in input via metodo POST*/
    @PostMapping(value="/album/canzone")
    public Canzone insertSong(@RequestBody Canzone canzone){
        System.out.println("Inserimento dati tramite POST della canzone:"+canzone);
        canzoneService.save(canzone);
        System.out.println("Inserimento salvato con i senguenti dati:"+canzone);
        return canzone;
    }
    /* Inserisce l'album, dato un album in input via metodo POST*/
    @PostMapping(value="/album")
    public Album insertAlbum(@RequestBody Album album){
        System.out.println("Inserimento dati tramite POST dell'album:"+album);
        albumService.save(album);
        System.out.println("Inserimento salvato con i senguenti dati:"+album);
        return album;
    }
}
