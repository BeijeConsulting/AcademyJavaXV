package it.beije.magazzino.service;

import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.ContenutoSpedizioneRepository;
import it.beije.magazzino.repository.SpedizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class SpedizioneService {

    @Autowired
    SpedizioneRepository spedizioneRepository;

    @Autowired
    ContenutoSpedizioneService contenutoSpedizioneService;

    public List<Spedizione> findAllSpedizioni() {
        return spedizioneRepository.findAll();
    }

    public Spedizione findSpedizioneById(Integer id) {
        if (spedizioneRepository.findById(id).isPresent()) {
            Optional<Spedizione> spedizione = spedizioneRepository.findById(id);
            return spedizione.get();
        } else {
            return null;
        }
    }

    public void addSpedizione(Spedizione spedizione) {
        spedizione.setDataSpedizione(LocalDateTime.now());
        spedizione.setDataSpedizione(LocalDateTime.now().plus(Period.ofDays(2)));
        spedizione.setCodice();
        spedizioneRepository.save(spedizione);
    }

}
