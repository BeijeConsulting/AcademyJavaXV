package it.beije.magazzino.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@RequestMapping(value = "/formprodotti", method = RequestMethod.GET)
	public String form() {
		System.out.println("GET login...");

		return "form_id";
	}
	
	
	@RequestMapping(value = "/formprodotti", method = RequestMethod.POST)
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
