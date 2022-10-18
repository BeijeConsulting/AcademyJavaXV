package it.beije.musicstore.controller;

import it.beije.musicstore.dto.request.AlbumRequestDto;
import it.beije.musicstore.dto.request.ArtistaRequestDto;
import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.AlbumService;
import it.beije.musicstore.service.ArtistaService;
import it.beije.musicstore.service.CanzoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RestMusicController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ArtistaService artistaService;
    @Autowired
    private CanzoneService canzoneService;

    public RestMusicController() {
        System.out.println("creo un oggetto RestController...");
    }

    @PostMapping(value = "/ArtoAl")
    public List<Album> ArtoAl(@RequestBody ArtistaRequestDto artista, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Album> lista1 = albumService.findByIdArtista(artista.getId());
        model.addAttribute("albums", lista1);
        return lista1; // /WEB-INF/views/home.jsp
    }

    @PostMapping(value = "/GtoAr")
    public List<Artista> GtoAr(@RequestBody  Artista artista, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Artista> lista2 = artistaService.findByGenere(artista.getGenere());
        model.addAttribute("artisti", lista2);
        return lista2; // /WEB-INF/views/home.jsp
    }


    @PostMapping(value = "/AltoC")
    public List<Canzone> AltoC(@RequestBody Album album, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Canzone> lista3 = canzoneService.findByIdAlbum(album.getId());
        model.addAttribute("canzoni1", lista3);
        return lista3; // /WEB-INF/views/home.jsp
    }


    @PostMapping(value = "/ArtoC")
    public List<Canzone> ArtoC(@RequestBody Artista artista, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Canzone> lista4 = canzoneService.findByIdArtista(artista.getId());
        model.addAttribute("canzoni2", lista4);
        return lista4; // /WEB-INF/views/home.jsp
    }

    @PostMapping(value = "/GtoAl")
    public List<Album> GtoAl(@RequestBody Album genere, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Album> lista4 = albumService.findByGenere(genere.getGenere());
        model.addAttribute("albums1", lista4);
        return lista4; // /WEB-INF/views/home.jsp
    }
    @PostMapping(value = "/GtoC")
    public List<Canzone> GtoC(@RequestBody Canzone canzone, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Canzone> lista5 = canzoneService.findByGenere(canzone.getGenere());
        model.addAttribute("canzoni3", lista5);
        return lista5; // /WEB-INF/views/home.jsp
    }
}
