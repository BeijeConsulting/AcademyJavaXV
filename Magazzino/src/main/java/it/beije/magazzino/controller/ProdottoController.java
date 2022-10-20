package it.beije.magazzino.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.service.ProdottoService;


@Controller
public class ProdottoController {
	
	@Autowired
	private ProdottoService prodottoService;

	public ProdottoController() {
		System.out.println("creo un oggetto ProdottoController...");
	}
	
	@RequestMapping(value = "/listaprodotti", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		System.out.println("test : " + locale);

		List<Prodotto> lista = prodottoService.findAll();
		System.out.println("lista : " + lista);
		model.addAttribute("lista", lista);
		
		return "lista_prodotti";
	}

}
