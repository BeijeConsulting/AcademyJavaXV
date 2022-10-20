package it.beije.magazzino.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.service.ProdottoService;


@RestController
@RequestMapping(value = "api")
public class ProdottoRestController {

	@Autowired
	public ProdottoService ProdottoService;
	
	@Autowired
	public ProdottoRepository ProdottoRepository;
	
	public ProdottoRestController() {
		System.out.println("creo un oggetto ProdottoRestController");
	}
	
	@GetMapping(value ="get")
	public List<Prodotto> prodotti(){
		List<Prodotto> prodotti=ProdottoService.getAll();	
		return prodotti;
	}

	@GetMapping(value ="byid/{id}")
	public Prodotto prodottobyid(@PathVariable Integer id) throws Exception {
	
		Prodotto prodotto=ProdottoService.findById(id);
		
		return prodotto;
	}
	
	
	@PostMapping(value = "insert")
	public Prodotto insertedProdotto(HttpServletRequest request,Model model,@RequestBody Prodotto Prodotto){

		Prodotto prodotto=new Prodotto();
		prodotto.setName(Prodotto.getName());
		prodotto.setTipo(Prodotto.getTipo());
		prodotto.setQuantity(Prodotto.getQuantity());
		prodotto.setDesc(Prodotto.getDesc());
		
		ProdottoService.insert(prodotto);
		
		return prodotto;
	}
		
	@PutMapping(value = "update/{id}")
	public Prodotto updatedProdotto(HttpServletRequest request, Model model, @RequestBody Prodotto Prodotto,@PathVariable Integer id) throws Exception {

		Prodotto prodotto =ProdottoService.findById(id);
		if(Prodotto.getName()!=null)
			prodotto.setName(Prodotto.getName());
		if(Prodotto.getTipo()!=null)
			Prodotto.setTipo(Prodotto.getTipo());
			Prodotto.setQuantity(Prodotto.getQuantity());
		if(Prodotto.getDesc()!=null)
			prodotto.setDesc(Prodotto.getDesc());

		ProdottoService.insert(Prodotto);

		return Prodotto;
	}
	
	
	
	@DeleteMapping(value = "delete/{id}")
	public String deletedProdotto(HttpServletRequest request, Model model, @PathVariable Integer id) throws Exception {
		
		ProdottoService.delete(id);
		return "Prodotto eliminato dal magazzino";
	}
		
		
	}
	



