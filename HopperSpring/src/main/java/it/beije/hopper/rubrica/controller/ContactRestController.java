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
import it.beije.hopper.rubrica.repository.ContactRepository;
import it.beije.hopper.rubrica.service.ContactService;

@RestController
@RequestMapping(value = "api")
public class ContactRestController {
	
	@Autowired
	public ContactService contactService;
	
	@Autowired
	public ContactRepository contactRepository;
	
	@GetMapping(value="/contacts")
	public List<Contact> orders() {
		
		List<Contact> prodotti = contactService.findAll();
		
		return prodotti;
	}
	
	@PostMapping(value = "/insertcontact")
	public Contact insertProduct(@RequestBody Contact contact) {
		System.out.println("POST insertContact : " + contact);
		
		contactService.save(contact);
		System.out.println("Contact post save : " + contact);
		
		return contact;
	}
	
	@PutMapping(value = "/contacts/{id}")					//NON VA
	public Contact updateContact(@PathVariable(name = "id") Integer id, @RequestBody Contact newData) {
		System.out.println("POST updateContact id : " + id + " : " + newData);
		
		if (id.compareTo(newData.getId()) == 0) {//OK modifico
			
			Contact contact = contactService.findById(id);
						
			BeanUtils.copyProperties(newData, contact, "id");
			
			contactService.save(contact);
			System.out.println("user with new data : " + contact);

			return contact;
		} else
			throw new IllegalArgumentException("id non corrispondenti");
	}
	
	@DeleteMapping(value = "/contats/{id}")			
	public String deleteContact(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE deleteContact : " + id);
		
		contactRepository.deleteById(id);
		
		return "{\"message\":\"rimosso contact " + id + "\"}";
	}

}
