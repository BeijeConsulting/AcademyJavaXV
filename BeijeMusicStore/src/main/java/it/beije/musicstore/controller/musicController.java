package it.beije.musicstore.controller;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class musicController {

    @Autowired
    private AlbumService albumService;
//
    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private CanzoneService canzoneService;

    public musicController() {
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

    @RequestMapping(value = {"/ArtoAl"}, method = RequestMethod.POST)
    public String ArtoAl(HttpServletRequest request, @RequestParam(name = "artista", required = false) int artista, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Album> lista1 = albumService.findByIdArtista(artista);
        model.addAttribute("albums", lista1);
        return "home"; // /WEB-INF/views/home.jsp
    }

    @RequestMapping(value = {"/GtoAr"}, method = RequestMethod.POST)
    public String GtoAr(HttpServletRequest request, @RequestParam(name = "genere", required = false) String genere, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Artista> lista2 = artistaService.findByGenere(genere);
        model.addAttribute("artisti", lista2);
        return "home"; // /WEB-INF/views/home.jsp
    }

    @RequestMapping(value = {"/AltoC"}, method = RequestMethod.POST)
    public String AltoC(HttpServletRequest request, @RequestParam(name = "album", required = false) int album, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Canzone> lista3 = canzoneService.findByIdAlbum(album);
        model.addAttribute("canzoni1", lista3);
        return "home"; // /WEB-INF/views/home.jsp
    }

    @RequestMapping(value = {"/ArtoC"}, method = RequestMethod.POST)
    public String ArtoC(HttpServletRequest request, @RequestParam(name = "artistaC", required = false) int artista, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Canzone> lista4 = canzoneService.findByIdArtista(artista);
        model.addAttribute("canzoni2", lista4);
        return "home"; // /WEB-INF/views/home.jsp
    }

    @RequestMapping(value = {"/GtoAl"}, method = RequestMethod.POST)
    public String GtoAl(HttpServletRequest request, @RequestParam(name = "genere2", required = false) String genere, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Album> lista4 = albumService.findByGenere(genere);
        model.addAttribute("albums1", lista4);
        return "home"; // /WEB-INF/views/home.jsp
    }

    @RequestMapping(value = {"/GtoC"}, method = RequestMethod.POST)
    public String GtoC(HttpServletRequest request, @RequestParam(name = "genere3", required = false) String genere, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Canzone> lista5 = canzoneService.findByGenere(genere);
        model.addAttribute("canzoni3", lista5);
        return "home"; // /WEB-INF/views/home.jsp
    }

    @RequestMapping(value = {"/CtoAr"}, method = RequestMethod.POST)
    public String CtoAr(HttpServletRequest request, @RequestParam(name = "canzone", required = false) String canzone, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Artista> lista5 = artistaService.loadArtistaByCanzone(canzone);
        model.addAttribute("artisti1", lista5);
        return "home"; // /WEB-INF/views/home.jsp
    }

    @RequestMapping(value = {"/CtoAl"}, method = RequestMethod.POST)
    public String CtoAl(HttpServletRequest request, @RequestParam(name = "canzone1", required = false) String album, Model model) {
        List<Artista> Artisti = artistaService.findAll();
        model.addAttribute("artistiHome", Artisti);
        List<Album> Albums = albumService.findAll();
        model.addAttribute("albumsHome", Albums);
        List<Album> lista5 = albumService.loadAlbumByCanzone(album);
        model.addAttribute("albums2", lista5);
        return "home"; // /WEB-INF/views/home.jsp
    }

}
