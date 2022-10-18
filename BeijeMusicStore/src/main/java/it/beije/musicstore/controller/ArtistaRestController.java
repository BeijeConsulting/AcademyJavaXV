package it.beije.musicstore.controller;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "api")
public class ArtistaRestController {

    @Autowired
    private ArtistaService artistaService;

    public ArtistaRestController() {
        System.out.println("creo un oggetto MusicController...");
    }


    @GetMapping(value = "/artista_by_genere/{genere}")
    public List artistaById(@PathVariable(name = "gemere") String genere) {
        System.out.println("GET genere : " + genere);

        List<Artista> lista = artistaService.findByGenere(genere);
        return lista;
    }


    @GetMapping(value = "/artista_by_id/{id}")
    public List artistaById(@PathVariable(name = "id") Integer id) {
        System.out.println("GET : " + id);

        Optional<Artista> artista = artistaService.findById(id);
        List<Artista> lista = new ArrayList<>();
        artista.ifPresent(lista::add);
        return lista;
    }

}
