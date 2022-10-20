package it.beije.magazzino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.magazzino.model.ContenutoSpedizione;
import it.beije.magazzino.repository.ContenutoSpedizioneRepository;

@Service
public class ContenutoSpedizioneService {

	@Autowired
	ContenutoSpedizioneRepository contenutoSapedizioneRepository;
	
	public List<ContenutoSpedizione> getBySpedId(Integer id){
		return contenutoSapedizioneRepository.findByIdSpedizione(id);
	}
}
