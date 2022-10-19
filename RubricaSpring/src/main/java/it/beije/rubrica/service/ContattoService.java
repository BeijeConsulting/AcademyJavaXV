package it.beije.rubrica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.rubrica.model.Contatto;
import it.beije.rubrica.repository.ContattoRepository;

@Service
public class ContattoService {

	@Autowired
	ContattoRepository contattoRepoisitory;

	public Contatto getById(Integer id) throws Exception {
		Optional<Contatto> contatto = contattoRepoisitory.findById(id);
		if (!contatto.isPresent()) {
			throw new Exception();
		}
		return contatto.get();
	}

	public void save(Contatto contatto) {
		contattoRepoisitory.save(contatto);
		
	}
	
	public Contatto setContatto(Contatto contatto,Contatto newContatto) {
		
		if(newContatto.getNome()!=null)
			contatto.setNome(newContatto.getNome());
		if(newContatto.getCognome()!=null)
			contatto.setCognome(newContatto.getCognome());
		if(newContatto.getEmail()!=null)
			contatto.setEmail(newContatto.getEmail());
		if(newContatto.getTelefono()!=null)
			contatto.setTelefono(newContatto.getTelefono());
		if(newContatto.getNote()!=null)
			contatto.setNote(newContatto.getNote());
		
		return contatto;
	}

	public void deleteById(Integer id) {
		contattoRepoisitory.deleteById(id);
		
	}

}
