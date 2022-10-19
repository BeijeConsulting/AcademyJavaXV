package it.beije.rubrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.rubrica.model.Recapito;
import it.beije.rubrica.service.RecapitoService;

@RequestMapping(value="recapito")
@RestController
public class RecapitoRestController {

	
	public RecapitoRestController() {
		System.out.println("creo un oggetto RecapitoRestController...");
	}
	
	@Autowired
	RecapitoService recapitoService;
	
	@GetMapping(value="getbyid/{id}")
	public Recapito getByid(@PathVariable(value="id")Integer id) throws Exception {
		Recapito recapito=recapitoService.getById(id);
		return recapito;
	}
}
