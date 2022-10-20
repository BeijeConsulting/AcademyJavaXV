package it.beije.magazzino.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.service.ProdottoService;


@RestController
@RequestMapping(value="/prodotto")
public class ProdottoRestController {
	@Autowired
	ProdottoService prodottoService;
	
	@GetMapping(value ="/prodottobyid/{id}")
	public Prodotto prodottobyid(@PathVariable Integer id) throws Exception {
	
		Prodotto prodotto=prodottoService.getById(id);
		
		return prodotto;
	}
}
