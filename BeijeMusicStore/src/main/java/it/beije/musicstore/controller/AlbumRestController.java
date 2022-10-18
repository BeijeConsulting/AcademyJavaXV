package it.beije.musicstore.controller;

import com.sun.xml.bind.util.AttributesImpl;
import it.beije.musicstore.model.Album;
import it.beije.musicstore.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
public class AlbumRestController {

    @Autowired
    private AlbumService albumService;


    public AlbumRestController() {
        System.out.println("creo un oggetto MusicController...");
    }

    @GetMapping(value = "/album_by_artista/{id}")
    public List albumByArtistaRest(@PathVariable(name = "id") Integer id) {
        System.out.println("GET getUser : " + id);

        List<Album> lista = albumService.findByArtista(id);



        return lista;
    }

    @GetMapping(value = "/album_by_genere/{genere}")
    public List albumByGenereRest(@PathVariable(name = "genere") String genere) {
        System.out.println("GET getUser : " + genere);

        List<Album> lista = albumService.findByGenere(genere);


        return lista;
    }

    @GetMapping(value = "/album_by_id/{id}")
    public List albumByIdRest(@PathVariable(name = "id") Integer id) {
        System.out.println("test : " + id);

        Optional<Album> art = albumService.findById(id);

        List<Album> lista = new ArrayList<>();
        art.ifPresent(lista::add);

        return lista;
    }
}