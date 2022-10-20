package it.beije.musicstore.service;

import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.repository.CanzoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CanzoneService {

    @Autowired
    private CanzoneRepository canzoneRepository;

    public Canzone getCanzoneById(Integer id) {
        Optional<Canzone> canzone = canzoneRepository.findById(id);
        return canzone.get();
    }

    public Canzone save(Canzone canzone) {
        return canzoneRepository.save(canzone);
    }

    public boolean deleteCanzone(Integer id) {
        boolean status;
        if (canzoneRepository.findById(id).isPresent()) {
            status = true;
            canzoneRepository.deleteById(id);
        } else {
            status = false;
        }
        return status;
    }
}
