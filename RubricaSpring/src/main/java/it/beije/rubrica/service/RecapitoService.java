package it.beije.rubrica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.rubrica.model.Recapito;
import it.beije.rubrica.repository.RecapitoRepository;

@Service
public class RecapitoService {

	@Autowired
	RecapitoRepository recapitoRepository;
	
	public Recapito getById(Integer id) throws Exception {
		Optional<Recapito> recapito=recapitoRepository.findById(id);
		if(!recapito.isPresent())
			throw new Exception();
		return recapito.get();
	}
	
	public List<Recapito> getByRubricaId(Integer id){
		return recapitoRepository.findByRubricaId(id);
	}
	
	
	
}
