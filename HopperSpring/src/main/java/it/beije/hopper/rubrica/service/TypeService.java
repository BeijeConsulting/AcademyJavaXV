package it.beije.hopper.rubrica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.rubrica.model.Contact;
import it.beije.hopper.rubrica.model.TypeContact;
import it.beije.hopper.rubrica.repository.ContactRepository;
import it.beije.hopper.rubrica.repository.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
	public TypeRepository typeRepository;

	
	public List<TypeContact> findAll() {
		return typeRepository.findAll();
	}

	public TypeContact save(TypeContact item) {
		return typeRepository.save(item);
	}

	public TypeContact findById(Integer id) {
		Optional<TypeContact> u = typeRepository.findById(id);
		
		if (!u.isPresent()) throw new IllegalArgumentException("Type non trovato con id " + id);

		return u.get();
	}

}
