package it.beije.magazzino.controller;

import javax.servlet.http.HttpServletRequest;

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
	ProdottoService prodottoService;
	
	@RequestMapping(value="prodottobyid",method=RequestMethod.GET)
	public String prodottobyid(HttpServletRequest request,Model model) throws Exception {
		
		Prodotto prodotto=prodottoService.getById(1);
		model.addAttribute("prodotto",prodotto);
		return "prodottobyid";
	}
}
