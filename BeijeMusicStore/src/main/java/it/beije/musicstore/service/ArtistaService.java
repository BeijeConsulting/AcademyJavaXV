package it.beije.musicstore.service;


import it.beije.musicstore.model.Artista;
import it.beije.musicstore.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    ArtistaRepository artistaRepository;


    public ArtistaService(){
        System.out.println("Creating Artista Service...");
    }


    public List<Artista> findByGenere(String genere){
        System.out.println("Find by genere called");
        return artistaRepository.findByGenere(genere);
    }

}
