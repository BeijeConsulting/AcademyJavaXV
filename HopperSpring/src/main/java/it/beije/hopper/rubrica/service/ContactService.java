package it.beije.hopper.rubrica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.rubrica.model.Contact;
import it.beije.hopper.rubrica.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	public ContactRepository contactRepository;

	
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	public Contact save(Contact item) {
		return contactRepository.save(item);
	}

	public Contact findById(Integer id) {
		Optional<Contact> u = contactRepository.findById(id);
		
		if (!u.isPresent()) throw new IllegalArgumentException("Item non trovato con id " + id);

		return u.get();
	}

}
