package it.beije.magazzino.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.magazzino.model.ContenutoSpedizione;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.service.ContenutoSpedizioneService;
import it.beije.magazzino.service.SpedizioneService;

@RequestMapping(value="spedizione")
@RestController
public class SpedizioneRestController {

	@Autowired SpedizioneService spedizioneService;
	@Autowired ContenutoSpedizioneService contenutoSpedizioneService;
	
	@GetMapping(value="/get")
	public List<Spedizione> get(){
		List<Spedizione> spedizione=spedizioneService.getAll();
		return spedizione;
	}
	
	@GetMapping(value="/contenuto/{id}")
	public Spedizione getspedizioneContenuto(HttpServletRequest request, Model model,@PathVariable Integer id) throws Exception {
		
		List<ContenutoSpedizione> contenuto=contenutoSpedizioneService.getBySpedId(id);
		Spedizione spedizione=spedizioneService.getById(id);
		spedizione.setContenuto(contenuto);
		return spedizione;
	}
	
	@GetMapping(value="prodotto/{id}")
	public Spedizione getspedizioneProdotto(HttpServletRequest request, Model model,@PathVariable Integer id) throws Exception {
	
		List<ContenutoSpedizione> contenuto=contenutoSpedizioneService.getByContId(id);
		System.out.println(contenuto);
		Spedizione spedizione=spedizioneService.getById(contenuto.get(0).getId());
		
		return spedizione;
	}
	
}
