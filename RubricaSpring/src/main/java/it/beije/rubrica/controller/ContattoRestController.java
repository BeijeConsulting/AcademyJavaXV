package it.beije.rubrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.rubrica.model.Contatto;
import it.beije.rubrica.model.Recapito;
import it.beije.rubrica.service.ContattoService;
import it.beije.rubrica.service.RecapitoService;

@RestController
@RequestMapping(value = "contatto")
public class ContattoRestController {
	@Autowired 
	ContattoService contattoService;
	@Autowired
	RecapitoService recapitoService;
	
	
	public ContattoRestController() {
		System.out.println("creo un oggetto ContattoRestController...");
	}
	
	@GetMapping(value="getbyid/{id}")
	public Contatto getContattoById(Model model,@PathVariable(value="id") Integer id) throws Exception {
		
		Contatto contatto=contattoService.getById(id);
		List<Recapito> recapiti=recapitoService.getByRubricaId(id);
		contatto.setRecapiti(recapiti);
		
		return contatto;	
	}
	
	@PostMapping(value="insert")
	public Contatto insert(@RequestBody Contatto contatto,Model model) {
		contattoService.save(contatto);
		return contatto;
	}
	
	@PutMapping(value="update/{id}")
	public Contatto update(@RequestBody Contatto newContatto,Model model,@PathVariable(value="id") Integer id) throws Exception {
		
		Contatto contatto=contattoService.getById(id);

		if(id.compareTo(newContatto.getId())==0) {
			contatto=contattoService.setContatto(contatto, newContatto);
			contattoService.save(contatto);
			return contatto;	
		}else throw new IllegalArgumentException("Id non corrispondenti");
	}
	
	@DeleteMapping(value="delete/{id}")
	public String delete(Model model,@PathVariable(value="id")Integer id) throws Exception {
		contattoService.deleteById(id);
		return "Il contatto "+id+" è stato rimosso";
	}
	
	
}
