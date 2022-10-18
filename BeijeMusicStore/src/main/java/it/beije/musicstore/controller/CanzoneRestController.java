package it.beije.musicstore.controller;

import java.util.List;

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

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.CanzoneService;


@RestController
@RequestMapping(value = "song")
public class CanzoneRestController {

	@Autowired
	CanzoneService canzoneService;
	
	@GetMapping(value = "/songbyalbum")
	public List<Canzone> songbyalbum(Model model) {
		
		List<Canzone> canzoni=canzoneService.getCanzoniByAlbum(1);
		model.addAttribute("canzoni",canzoni);
		return canzoni;
	}
	
	@GetMapping(value = "/songbyartist")
	public List<Canzone> songbyartist(Model model) {	
		
		List<Canzone> canzoni=canzoneService.getCanzoniByArtist(2);
		model.addAttribute("canzoni",canzoni);
		return canzoni;
	}
	
	@GetMapping(value = "/songbygenre")
	public List<Canzone> songbygenre(Model model) {
		
		List<Canzone> canzoni=canzoneService.getCanzoniByGenere("rock");
		model.addAttribute("canzoni",canzoni);
		return canzoni;
	}
	
	@PostMapping(value="insert")
	public Canzone insert(@RequestBody Canzone canzone,Model model){
		
		canzoneService.checkCanzone(canzone);
		canzoneService.insert(canzone);
		model.addAttribute("album",canzone);
		return canzone;
	}
	
	@PutMapping(value="update/{id}")
	public Canzone update(@RequestBody Canzone newCanzone,Model model,@PathVariable(value="id")Integer id) throws Exception {
		if(id.compareTo(newCanzone.getId())==0) {
			Canzone canzone = canzoneService.getCanzoniById(id);
			if(newCanzone.getArtistaId()!=null)
				canzone.setArtistaId(newCanzone.getArtistaId());
			if(newCanzone.getDataDiUscita()!=null)
				canzone.setDataDiUscita(newCanzone.getDataDiUscita());
			if(newCanzone.getGenere()!=null)
				canzone.setGenere(newCanzone.getGenere());
			if(newCanzone.getTitolo()!=null)
				canzone.setTitolo(newCanzone.getTitolo());
			if(newCanzone.getAlbumId()!=null)
				canzone.setAlbumId(newCanzone.getAlbumId());
			
			canzoneService.insert(canzone);
			
			return canzone;
		}
		else throw new IllegalArgumentException("Id non corrispondenti");
	}

}
