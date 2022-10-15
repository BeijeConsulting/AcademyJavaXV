package it.beije.musicstore.controller;


import it.beije.musicstore.model.Artista;
import it.beije.musicstore.service.ArtistaService;
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
public class MainController {

    @Autowired
    private ArtistaService artistaService;

    public MainController() {
        System.out.println("creo un oggetto MainController....");
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        System.out.println("Hello Page Requested : " + request.getRequestURI());


//        System.out.println(artists);
        return "welcome"; // /WEB-INF/  views/beije.jsp
    }


    @RequestMapping(value={ "/artistibygenre-form" })
    public String artistForm(HttpSession session, Model model, HttpServletRequest request){
        List<Artista> artists = artistaService.findAll();
        model.addAttribute("artists", artists);
        System.out.println("artists:" + artists);
        List<String> listGenere = artistaService.listOfGenere();
        model.addAttribute("listGenere", listGenere);
        System.out.println("listGenere:" + listGenere);
        return "artisti-by-genere-form";
    }


    @RequestMapping(value={ "/artistibygenre" }, method=RequestMethod.GET)
    public String artist(HttpSession session, Model model, HttpServletRequest request,
                        @RequestParam(name ="artistGenere", required=false) String artistGenere){
        System.out.println("Artist Genere :" + artistGenere);
        List<Artista> artists = artistaService.findArtistaByGenere(artistGenere);
        model.addAttribute( "artists", artists);
        return "artisti-by-genere";
    }
//
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String hello(HttpServletRequest request) {
//        System.out.println("Hello Page Requested : " + request.getRequestURI());
//
//        return "hello";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login() {
//        System.out.println("GET login...");
//
//        return "login";
//    }


}
