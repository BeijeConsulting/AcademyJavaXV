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

    public Canzone getCanzoneById (Integer id) {
        Optional<Canzone> canzone = canzoneRepository.findById(id);
        return canzone.get();
    }
}
