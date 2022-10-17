package it.beije.musicstore.service;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.repository.CanzoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanzoneService {
    @Autowired
    private CanzoneRepository canzoneRepository;

    public CanzoneService() {
        System.out.println("creo un oggetto CanzoneService...");
    }

    public List<Canzone> findByIdArtista(int id){
        List<Canzone> canzoni = canzoneRepository.findByIdArtista(id);
        return canzoni;
    }

    public List<Canzone> findByGenere(String genere){
        List<Canzone> canzoni = canzoneRepository.findByGenere(genere);
        return canzoni;
    }



    public List<Canzone> findByIdAlbum(int id){
        List<Canzone> canzoni = canzoneRepository.findByIdAlbum(id);
        return canzoni;
    }

    public List<Canzone> findAll(){
        return canzoneRepository.findAll();
    }
}
