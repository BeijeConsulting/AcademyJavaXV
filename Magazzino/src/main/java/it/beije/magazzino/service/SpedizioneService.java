package it.beije.magazzino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.SpedizioneRepository;

@Service
public class SpedizioneService {

	@Autowired
	SpedizioneRepository spedizioneRepository;

	public List<Spedizione> getAll() {
		return spedizioneRepository.findAll();
	}

	public Spedizione getById(Integer id) throws Exception {
		Optional<Spedizione> spedizione = spedizioneRepository.findById(id);
		if (!spedizione.isPresent())
			throw new Exception();
		return spedizione.get();
	}

	public void insert(Spedizione spedizione) {
		spedizioneRepository.save(spedizione);
	}
}
