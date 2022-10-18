package it.beije.musicstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import it.beije.hopper.ecommerce.model.Order;
import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.AlbumService;
import it.beije.musicstore.service.CanzoneService;


@RestController
@RequestMapping(value = "album")
public class AlbumRestController {

	@Autowired
	AlbumService albumService;
	@Autowired
	CanzoneService canzoneService;
	
	@GetMapping(value ="/albumbyartist/{id}")
	public List<Album> albumbyartist(@PathVariable(name="id") Integer id) {
		
		
		List<Album> album=albumService.getAlbumByArtistaId(id);
		
		return album;
	}
	
	
	@GetMapping(value = "albumbygenre/{genere}")
	public List<Album> albumbygenre(@PathVariable(name="genere")String genere,Model model) {
		System.out.println(genere);
		List<Album> album=albumService.getAlbumByGenere(genere.toString());
		model.addAttribute("album",album);
		return album;
	}
	
	@GetMapping(value = "albumbysong")
	public List<Album> albumbysong(HttpServletRequest request,Model model) throws Exception {
		System.out.println("Hello Page Requested : " + request.getRequestURI());
		
		Canzone canzone=canzoneService.getCanzoniById(2);
		
		
		
		Album album=albumService.getAlbumById(canzone.getAlbumId());
		
	
		List<Album> albumList=new ArrayList<>();
		albumList.add(album);
		model.addAttribute("album",albumList);
		
		return albumList;
	}
	
	@PostMapping(value="insert")
	public Album insert(@RequestBody Album album,Model model){
		
		albumService.checkAlbum(album);
		albumService.insert(album);
		model.addAttribute("album",album);
		return album;
	}
	
	@PutMapping(value="update/{id}")
	public Album update(@RequestBody Album newAlbum,Model model,@PathVariable(value="id")Integer id) throws Exception {
		if(id.compareTo(newAlbum.getId())==0) {
			Album album = albumService.getAlbumById(id);
			if(newAlbum.getArtistaId()!=null)
				album.setArtistaId(newAlbum.getArtistaId());
			if(newAlbum.getDataDiUscita()!=null)
				album.setDataDiUscita(newAlbum.getDataDiUscita());
			if(newAlbum.getGenere()!=null)
				album.setGenere(newAlbum.getGenere());
			if(newAlbum.getTitolo()!=null)
				album.setTitolo(newAlbum.getTitolo());
			
			albumService.insert(album);
			
			return album;
		}
		else throw new IllegalArgumentException("Id non corrispondenti");
	}
	
	
	
	
}
