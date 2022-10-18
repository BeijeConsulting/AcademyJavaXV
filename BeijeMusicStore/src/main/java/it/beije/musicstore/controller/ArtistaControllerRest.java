package it.beije.musicstore.controller;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.ArtistaService;
import org.springframework.beans.BeanUtils;
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
            a.setData(LocalDateTime.now());
        }
        artista.getAlbumArtista().get(0).getCanzoni().get(0).setData(LocalDateTime.now());
        for (Album a : artista.getAlbumArtista()) {
            for (Canzone c : a.getCanzoni()) {
                System.out.println(artista1.getId());
                c.setIdArtista(artista1.getId());
            }
        }
        return artistaService.addArtista(artista);
    }

}
