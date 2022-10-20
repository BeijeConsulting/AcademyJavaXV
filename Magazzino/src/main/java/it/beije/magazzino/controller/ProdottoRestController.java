package it.beije.magazzino.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.service.ProdottoService;


@RestController
@RequestMapping(value="/prodotto")
public class ProdottoRestController {
	@Autowired
	ProdottoService prodottoService;
	
	@GetMapping(value ="/byid/{id}")
	public Prodotto prodottobyid(@PathVariable Integer id) throws Exception {
	
		Prodotto prodotto=prodottoService.getById(id);
		
		return prodotto;
	}
	
	@GetMapping(value ="/get")
	public List<Prodotto> prodotti(){
		List<Prodotto> prodotti=prodottoService.getAll();	
		return prodotti;
	}
	
	@PostMapping(value = "/insert")
	public Prodotto insertedProdotto(HttpServletRequest request,Model model,@RequestBody Prodotto newProdotto){

		Prodotto prodotto=new Prodotto();
		prodotto.setNome(newProdotto.getNome());
		prodotto.setTipologia(newProdotto.getTipologia());
		prodotto.setQuantita(newProdotto.getQuantita());
		prodotto.setDescrizione(newProdotto.getDescrizione());
		
		prodottoService.insert(prodotto);
		
		return prodotto;
	}
	
	@PutMapping(value = "/update/{id}")
	public Prodotto updatedProdotto(HttpServletRequest request, Model model, @RequestBody Prodotto newProdotto,@PathVariable Integer id) throws Exception {

		Prodotto prodotto =prodottoService.getById(id);
		if(newProdotto.getNome()!=null)
			prodotto.setNome(newProdotto.getNome());
		if(newProdotto.getTipologia()!=null)
			prodotto.setTipologia(newProdotto.getTipologia());
		if(newProdotto.getQuantita()!=null)
			prodotto.setQuantita(newProdotto.getQuantita());
		if(newProdotto.getDescrizione()!=null)
			prodotto.setDescrizione(newProdotto.getDescrizione());

		prodottoService.insert(prodotto);

		return prodotto;
	}
	
	@DeleteMapping(value = "delete/{id}")
	public String deletedProdotto(HttpServletRequest request, Model model, @PathVariable Integer id) throws Exception {
		
		prodottoService.delete(id);
		return "Prodotto eliminato";
	}
	
	
}
