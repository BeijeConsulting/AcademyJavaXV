package it.beije.musicstore.controller;


import javax.servlet.http.HttpServletRequest;

import it.beije.musicstore.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("Artista",artistaService.findByNome("Artista 1"));
        return "index";
    }
}
