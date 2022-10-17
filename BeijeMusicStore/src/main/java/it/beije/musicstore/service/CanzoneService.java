package it.beije.musicstore.service;

import it.beije.musicstore.repository.CanzoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CanzoneService {

    @Autowired
    private CanzoneRepository canzoneRepository;
}
