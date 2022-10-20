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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.service.ProdottoService;

@RestController
@RequestMapping(value = "magazzino")
public class ProdottoRestController {
	
	@Autowired
	public ProdottoService prodottoService;
	
	@Autowired
	public ProdottoRepository prodottoRepository;
	
	public ProdottoRestController() {
		System.out.println("creo un oggetto UserRestController");
	}
	
	@GetMapping(value = "/prodotto/{id}")
	public Prodotto getProdotto(@PathVariable(name = "id") Integer id) {
		System.out.println("GET getProdotto : " + id);
		
		Prodotto prodotto = prodottoService.findById(id);
		System.out.println("prodotto : " + prodotto);
		
		return prodotto;
	}

}
