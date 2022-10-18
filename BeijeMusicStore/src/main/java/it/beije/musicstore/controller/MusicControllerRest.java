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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class MusicControllerRest {

    @Autowired
    private AlbumService albumService;
//
    @Autowired
    private ArtistaService artistaService;
    
    @Autowired
    private CanzoneService canzoneService;
   
    public MusicControllerRest() {
        System.out.println("creo un oggetto HelloController...");
    }

   
    
 
//  @GetMapping(value = "/test_rest2")
//	public List<User> testRest() {
//		System.out.println("GET test_rest2...");
//
//		List<User> lista = userService.loadLastClients(LocalDate.now().minusMonths(1));
//		System.out.println("lista : " + lista);
//		
//		return lista;
//	}

 
  @PostMapping(value = "/ArtoAl")
  public  List<Album> ArtoAl( @RequestBody Artista artista) {      
      List<Album> lista1 = albumService.findByIdArtista(artista.getId());
     
   
      return lista1; // /WEB-INF/views/home.jsp
  }

  @PostMapping(value = "/GtoAr")
  public List<Artista> GtoAr(@RequestBody Artista genere) {
     
      List<Artista> lista2 = artistaService.findByGenere(genere.getGenere());
     
      return lista2; // /WEB-INF/views/home.jsp
  }

  @PostMapping(value = "/AltoC")
  public List<Canzone> AltoC(@RequestBody Album album) {
      
      List<Canzone> lista3 = canzoneService.findByIdAlbum(album.getId());
   
      return lista3; // /WEB-INF/views/home.jsp
  }

  @PostMapping(value = "/ArtoC")
  public List<Canzone> ArtoC(@RequestBody Artista artista) {
     
      List<Canzone> lista4 = canzoneService.findByIdArtista(artista.getId());
     
      return lista4; // /WEB-INF/views/home.jsp
  }

  @PostMapping(value = "/GtoAl")
  public List<Album> GtoAl(@RequestBody Artista artista) {
      
      List<Album> lista4 = albumService.findByGenere(artista.getGenere());
    
      return lista4; // /WEB-INF/views/home.jsp
  }

  @PostMapping(value = "/GtoC")
  public List<Canzone> GtoC(@RequestBody Artista artista) {
      
      List<Canzone> lista5 = canzoneService.findByGenere(artista.getGenere());
 
      return lista5; // /WEB-INF/views/home.jsp
  }

  @PostMapping(value = "/CtoAr")
  public List<Artista> CtoAr(@RequestBody Canzone canzone) {
      
      List<Artista> lista5 = artistaService.loadArtistaByCanzone(canzone.getTitolo());
    
      return lista5; // /WEB-INF/views/home.jsp
  }

  @PostMapping(value = "/CtoAl")
  public List<Album> CtoAl(@RequestBody Canzone canzone) {
      
      List<Album> lista5 = albumService.loadAlbumByCanzone(canzone.getTitolo());
     
      return lista5; // /WEB-INF/views/home.jsp
  }


   
}
