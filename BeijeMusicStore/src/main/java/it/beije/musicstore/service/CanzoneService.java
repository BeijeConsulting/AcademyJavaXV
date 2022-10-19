package it.beije.musicstore.service;


import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.repository.ArtistaRepository;
import it.beije.musicstore.repository.CanzoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CanzoneService {

    @Autowired
    private CanzoneRepository canzoneRepository;


    public CanzoneService() {
        System.out.println("creo un oggetto canzoneService...");
    }

    public List<Canzone> findByAlbum(Integer id_album) {
        return canzoneRepository.findByAlbum(id_album);
    }

    public List<Canzone> findByArtista(Integer id_artista) {
        return (List<Canzone>) canzoneRepository.findByArtista(id_artista);
    }

    public List<Canzone> findByGenere(String genere) {
        return canzoneRepository.findByGenere(genere);
    }

    public List<String> getAllGeneri() {
        return canzoneRepository.getallGeneri();
    }

    public List<Canzone> getAll() {
        return canzoneRepository.findAll();
    }

    public void save(Canzone canzone) {
        canzoneRepository.save(canzone);
    }

    public Canzone findById(Integer id) {
        Optional<Canzone> c = canzoneRepository.findById(id);
        return c.orElse(null);
    }

    public void delete(Canzone canzone) {
        canzoneRepository.delete(canzone);
    }

}
