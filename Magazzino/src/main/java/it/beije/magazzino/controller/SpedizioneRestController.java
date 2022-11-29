package it.beije.magazzino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.service.ProdottoService;
import it.beije.magazzino.service.SpedizioneService;

@Controller
public class SpedizioneRestController {
	
	@Autowired
	private SpedizioneService spedizioneService;
	
	@Autowired
	private ProdottoService prodottoService;
	
	public SpedizioneRestController() {
		System.out.println("creo un oggetto SpedizioneRestController...");
	}
	
	
@GetMapping(value="/spedizioni")
	
	public ResponseEntity<List<Spedizione>> prodotti() {
		System.out.println("ENTRATO IN PRODOTTI");
		
		//List<Prodotto> prodotti = prodottoRepository.findAll();			//namedQuery
		List<Spedizione> spedizioni = spedizioneService.gottaCatchEmAll();		//criteriaQuery
		System.out.println(spedizioni);
		
		return ResponseEntity.ok(spedizioni);
	}

}
