package it.beije.musicstore.controller;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "rest")
public class ArtistaControllerRest {

    @Autowired
    ArtistaService artistaService;

    @GetMapping(value = "artista/{id}")
    public Artista getArtista(@PathVariable(name = "id") Integer id) {
        return artistaService.findById(id);
    }

    @PostMapping(value = "addArtista")
    public Artista addArtista(@RequestBody Artista artista) {
        Artista artista1 = new Artista();
        artista1.setNome(artista.getNome());
        artista1.setGenere(artista.getGenere());
        artistaService.addOnlyArtista(artista1);
        artista.setId(artista1.getId());
        for (Album a : artista.getAlbumArtista()) {
            for (Canzone c : a.getCanzoni()) {
                c.setIdArtista(artista1.getId());
            }
        }
        return artistaService.addArtista(artista);
    }

    @DeleteMapping(value = "artista/{id}")
    public boolean deleteArtista(@PathVariable(name = "id") Integer id){
    return artistaService.deleteArtista(id);
    }

}
