//CREATE SCHEMA `magazzino` ;
//CREATE TABLE `magazzino`.`prodotto` (
//		  `id` INT NOT NULL AUTO_INCREMENT,
//		  `nome` VARCHAR(45) NOT NULL,
//		  `tipologia` VARCHAR(45) NOT NULL,
//		  `quantita` VARCHAR(45) NOT NULL,
//		  `descrizione` VARCHAR(45) NOT NULL,
//		  PRIMARY KEY (`id`));
//ALTER TABLE `magazzino`.`prodotto` 
//CHANGE COLUMN `quantita` `quantita` INT NOT NULL ;


package it.beije.magazzino.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.service.ProdottoService;

@RestController
public class ProdottoRestController {
	
	@Autowired
	public ProdottoService prodottoService;
	
	@Autowired
	public ProdottoRepository prodottoRepository;
	
	public ProdottoRestController() {
		System.out.println("creo un oggetto ProdottoRestController");
	}
	
	@GetMapping(value="/prodotti")
	public List<Prodotto> prodotti() {
		System.out.println("ENTRATO IN PRODOTTI");
		
		List<Prodotto> prodotti = prodottoRepository.findAll();
		
		return prodotti;
	}
	
	
	@GetMapping(value = "/prodotto/{id}")
	public Prodotto getProdotto(@PathVariable(name = "id") Integer id) {
		System.out.println("GET getProdotto : " + id);
		
		Prodotto prodotto = prodottoService.findById(id);
		System.out.println("prodotto : " + prodotto);
		
		return prodotto;
	}
	
	@PostMapping(value = "/insertprodotto")
	public Prodotto insertUser(@RequestBody Prodotto prodotto) {
		System.out.println("POST insertProdotto : " + prodotto);
		
		prodottoService.save(prodotto);
		System.out.println("prodotto post save : " + prodotto);
		
		return prodotto;
	}
	
	@PutMapping(value = "/prodotto/{id}")
	public Prodotto updateProdotto(@PathVariable(name = "id") Integer id, @RequestBody Prodotto newData) {
		System.out.println("POST updateProdotto id : " + id + " : " + newData);
		
		if (id.compareTo(newData.getId()) == 0) {//OK modifico
			
			Prodotto prodotto = prodottoService.findById(id);
			
			
			BeanUtils.copyProperties(newData, prodotto, "id");
			
			prodottoService.save(prodotto);
			System.out.println("prodotto with new data : " + prodotto);

			return prodotto;
		} else
			throw new IllegalArgumentException("id non corrispondenti");
	}
	
	@DeleteMapping(value = "/prodotto/{id}")
	public String deleteUser(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE deleteProdotto : " + id);
		
		prodottoRepository.deleteById(id);
		
		return "{\"message\":\"rimosso prodotto " + id + "\"}";
	}
	
	

}