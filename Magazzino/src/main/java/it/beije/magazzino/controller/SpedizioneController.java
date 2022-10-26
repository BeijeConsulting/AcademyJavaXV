package it.beije.magazzino.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.repository.SpedizioneRepository;
import it.beije.magazzino.service.ProdottoService;
import it.beije.magazzino.service.SpedizioneService;

//CREATE TABLE `magazzino`.`spedizione` (
//		  `id` INT NOT NULL AUTO_INCREMENT,
//		  `codice` VARCHAR(45) NOT NULL,
//		  `destinatario` VARCHAR(45) NOT NULL,
//		  `indirizzo` VARCHAR(45) NOT NULL,
//		  `data_spedizione` DATE NOT NULL,
//		  `data_ricezione` DATE NOT NULL,
//		  PRIMARY KEY (`id`));

@Controller
public class SpedizioneController {
	
	@Autowired
	private SpedizioneService spedizioneService;
	
	@Autowired
	private ProdottoService prodottoService;
	
	@Autowired
	private SpedizioneRepository spedizioneRepository;
	
	@Autowired
	private ProdottoRepository prodottoRepository;
	
	public SpedizioneController() {
		System.out.println("creo un oggetto SpedizioneController...");
	}
	
	@RequestMapping(value = "/listaspedizioni", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		System.out.println("test : " + locale);

		List<Spedizione> lista = spedizioneService.findAll();
		System.out.println("lista : " + lista);
		model.addAttribute("lista", lista);
		
		return "spedizioni";
	}
	
	@RequestMapping(value = "/formspedizione", method = RequestMethod.GET)
	public String form() {
		System.out.println("GET form spedizione prodotti...");

		return "form_id";
	}
	
	
	@RequestMapping(value = "/formspedizione", method = RequestMethod.POST)
	public String form(HttpSession session,
			@RequestParam(name = "id", required = false) Integer id,
			Model model) {
		
		System.out.println("POST id...");
		
		System.out.println("id : " + id);
		
		
		
		if (id != null) {
			Prodotto prodotto = prodottoService.findById(id);
				
				model.addAttribute("prodotto", prodotto);
								
				return "prodotto_id";
			} 

		return "form_id";
	}

}
