package it.beije.musicstore.controller;


import javax.servlet.http.HttpServletRequest;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.AlbumService;
import it.beije.musicstore.service.ArtistaService;
import it.beije.musicstore.service.CanzoneService;
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
    @Autowired
    private AlbumService albumService;
    public MusicController() {
        System.out.println("creo un oggetto MusicController...");
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello(HttpServletRequest request, Model model) {
        System.out.println("Hello Page Requested : " + request.getRequestURI());
        model.addAttribute("Artista",artistaService.findByNome("Artista 1"));
        return "index";
    }
    @RequestMapping(value = "/findSongByAlbum", method = RequestMethod.GET)
    public String findSongByAlbum (HttpServletRequest request){
        return "findSongByAlbum";
    }
    @RequestMapping(value = "/findSongByAlbum", method = RequestMethod.POST)
    public String findSongByAlbum (HttpServletRequest request, Model model, @RequestParam(name = "nomeAlbum", required = false)String nomeAlbum){
        System.out.println(albumService.findByAlbum(nomeAlbum));
        List<Canzone> canzoni = albumService.findByAlbum(nomeAlbum).getCanzoni();
        model.addAttribute("canzoni", canzoni);
        return "findSongByAlbum";
    }
}
