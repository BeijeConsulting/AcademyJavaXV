package it.beije.musicstore.controller;

import it.beije.musicstore.dto.request.AlbumRequestDto;
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

@Controller
public class HomeMusicController {

    @Autowired
    private AlbumService albumService;
//
    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private CanzoneService canzoneService;

    public HomeMusicController() {
        System.out.println("creo un oggetto HelloController...");
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        System.out.println("Hello Page Requested : " + request.getRequestURI());

        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);

        return "home"; // /WEB-INF/views/home.jsp

    }



}
