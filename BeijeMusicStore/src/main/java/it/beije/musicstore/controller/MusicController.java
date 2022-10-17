package it.beije.musicstore.controller;


import javax.servlet.http.HttpServletRequest;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MusicController {

    @Autowired
    private ArtistaService artistaService;

    public MusicController() {
        System.out.println("creo un oggetto MusicController...");
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello(HttpServletRequest request, Model model) {
        System.out.println("Hello Page Requested : " + request.getRequestURI());
        model.addAttribute("artista", artistaService.findByNome("Artista 1"));
        System.out.println(artistaService.findByNome("Artista 1"));
        return "index";
    }

    @RequestMapping(value = "/findByGenere", method = RequestMethod.GET)
    public String findByGenere(HttpServletRequest request, Model model) {
        return "findByGenere";
    }

    @RequestMapping(value = "/findByGenere", method = RequestMethod.POST)
    public String findByGenere(HttpServletRequest request, Model model, @RequestParam(name = "genere", required = false) String genere) {
        int risultato = artistaService.findByGenere(genere).size();
        if (risultato >= 1) {
            model.addAttribute("risultato", artistaService.findByGenere(genere));
        } else {
            model.addAttribute("errore", risultato);
        }
        return "findByGenere";
    }

    @RequestMapping(value = "/findSongByArtist", method = RequestMethod.GET)
    public String findSongByArtist(HttpServletRequest request) {
        return "findSongByArtist";
    }

    @RequestMapping(value = "/findSongByArtist", method = RequestMethod.POST)
    public String findSongByArtist(HttpServletRequest request, Model model, @RequestParam(name = "nome", required = false) String nome) {
        List<Canzone> canzoni = new ArrayList<>();
        List<Album> album = artistaService.findByNome(nome).getAlbumArtista();
        for (Album a : album) {
            for (Canzone c : a.getCanzoni()) {
                canzoni.add(c);
            }

        }
        model.addAttribute("canzoni", canzoni);
        return "findSongByArtist";
    }
}
