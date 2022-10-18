package it.beije.musicstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
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

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.ArtistaService;
import it.beije.musicstore.service.CanzoneService;

@RestController
@RequestMapping(value = "artist")
public class ArtistaRestController {
	
	@Autowired
	ArtistaService artistaService;
	@Autowired
	CanzoneService canzoneService;
	
	@GetMapping(value ="/artistbygenre")
	public List<Artista> artistbygenre(Model model) {
		List<Artista> artisti=artistaService.getByGenere("rap");
	
		model.addAttribute("artisti",artisti);
		return artisti;
	}
	
	@GetMapping(value ="/artistbysong")
	public List<Artista> artistbysong(Model model) throws Exception {
		
		Optional<Canzone> canzone=canzoneService.getCanzoniById(2);
		if(!canzone.isPresent())
			throw new Exception();
		Artista artista=artistaService.getByIdArtista(canzone.get().getArtistaId());
		
		List<Artista> artistaLista=new ArrayList<>();
		artistaLista.add(artista);
		
		model.addAttribute("artisti",artistaLista);
		return artistaLista;
	}
	
	@PostMapping(value="/insert")
	public Artista insertArtista(@RequestBody Artista artista,Model model) {
		
		artistaService.checkArtista(artista);
		artistaService.save(artista);
		model.addAttribute("artista", artista);
		return artista;
	}
	
	@PutMapping(value="/update/{id}")
	public Artista updateArtista(@PathVariable(name="id")Integer id,@RequestBody Artista newArtista ) throws Exception {
		
		if(id.compareTo(newArtista.getId())==0){
			Artista artista=artistaService.getByIdArtista(id);
			if(newArtista.getNome()!=null) {
				System.out.println(newArtista.getNome());
				artista.setNome(newArtista.getNome());
			}
			if(newArtista.getGenere()!=null) {
				System.out.println(newArtista.getGenere());
				artista.setGenere(newArtista.getGenere());
			}
			
//			BeanUtils.copyProperties(newArtista, artista,"id");
			
			artistaService.save(artista);
			return artista;
		} else
			throw new IllegalArgumentException("id non corrispondenti");		
	}
}
