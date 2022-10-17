package it.beije.musicstore.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.service.ArtistaService;

@Controller
public class MusicController {
	
	@Autowired
	private ArtistaService artistaService;
    public MusicController() {
        System.out.println("creo un oggetto MusicController...");
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(HttpServletRequest request, Model model) {
        System.out.println("Hello Page Requested : " + request.getRequestURI());
        model.addAttribute("artista", artistaService.findByNome("Artista 1"));
        return "index";       
    }
    
    @RequestMapping(value = "/albumtramiteartista", method = RequestMethod.GET)
    public String albumByArtist(HttpServletRequest request) {
        	
        return "albumtramiteartista";
    }
    
    @RequestMapping(value = "/albumtramiteartista", method = RequestMethod.POST)
    public String albumByArtist(HttpServletRequest request, Model model, @RequestParam(name = "nome", required = false) String nomeArtista) {
        	     
        	System.out.println(artistaService.findByNome(nomeArtista));
        	List <Album> albums = artistaService.findByNome(nomeArtista).getAlbumArtista();
        	model.addAttribute("risultato", albums); 
        return "albumtramiteartista";
    }
    
    


}
