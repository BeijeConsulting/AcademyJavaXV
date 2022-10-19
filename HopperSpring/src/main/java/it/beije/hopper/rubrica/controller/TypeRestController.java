package it.beije.hopper.rubrica.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.rubrica.model.Contact;
import it.beije.hopper.rubrica.model.TypeContact;
import it.beije.hopper.rubrica.repository.ContactRepository;
import it.beije.hopper.rubrica.repository.TypeRepository;
import it.beije.hopper.rubrica.service.ContactService;
import it.beije.hopper.rubrica.service.TypeService;

@RestController
@RequestMapping(value = "api")
public class TypeRestController {
	
	@Autowired
	public TypeService typeService;
	
	@Autowired
	public TypeRepository typeRepository;
	
	@GetMapping(value="/types")
	public List<TypeContact> types() {
		
		List<TypeContact> types = typeService.findAll();
		
		return types;
	}
	
	@PostMapping(value = "/inserttype")
	public TypeContact insertType(@RequestBody TypeContact type) {
		System.out.println("POST insertType : " + type);
		
		typeService.save(type);
		System.out.println("Type post save : " + type);
		
		return type;
	}
	
	@PutMapping(value = "/types/{id}")					//NON VA
	public TypeContact updateType(@PathVariable(name = "id") Integer id, @RequestBody TypeContact newData) {
		System.out.println("POST updateType id : " + id + " : " + newData);
		
		if (id.compareTo(newData.getId()) == 0) {//OK modifico
			
			TypeContact type = typeService.findById(id);
						
			BeanUtils.copyProperties(newData, type, "id");
			
			typeService.save(type);
			System.out.println("type with new data : " + type);

			return type;
		} else
			throw new IllegalArgumentException("id non corrispondenti");
	}
	
	@DeleteMapping(value = "/types/{id}")			
	public String deleteType(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE deleteType : " + id);
		
		typeRepository.deleteById(id);
		
		return "{\"message\":\"rimosso type " + id + "\"}";
	}

}
