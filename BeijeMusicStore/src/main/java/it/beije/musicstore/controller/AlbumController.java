package it.beije.musicstore.controller;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;


    public AlbumController() {
        System.out.println("creo un oggetto MusicController...");
    }


    @RequestMapping(value = "/album_by_artista", method = RequestMethod.GET)
    public String albumByArtista(HttpSession session,
                                 @RequestParam(name = "id_artista_for_album", required = true) Integer artista_id, Model model) {
        System.out.println("id_artista : " + artista_id);

        List<Album> lista = albumService.findByArtista(artista_id);
        System.out.println("lista : " + lista);
        model.addAttribute("listaAlbum", lista);

        return "list";
    }

    @RequestMapping(value = "/album_by_genere", method = RequestMethod.GET)
    public String albumByGenere(HttpSession session,
                                @RequestParam(name = "genereAlbum", required = true) String genere, Model model) {
        System.out.println("test : " + genere);

        List<Album> lista = albumService.findByGenere(genere);
        System.out.println("lista : " + lista);
        model.addAttribute("listaAlbum", lista);


        return "list";
    }

    @RequestMapping(value = "/album_by_id", method = RequestMethod.GET)
    public String albumById(HttpSession session,
                            @RequestParam(name = "album_id", required = true) Integer id, Model model) {
        System.out.println("test : " + id);

        Optional<Album> art = albumService.findById(id);

        List<Album> lista = new ArrayList<>();
        art.ifPresent(lista::add);
        System.out.println("lista : " + lista);
        model.addAttribute("listaAlbum", lista);

        //TODO
        return "list";
    }


}