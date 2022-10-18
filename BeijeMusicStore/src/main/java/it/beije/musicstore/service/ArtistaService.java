package it.beije.musicstore.service;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    public Artista findByNome(String nome) {
       return artistaRepository.findByNome(nome);
    }
    public List<Artista> findByGenere(String genere) {
        return artistaRepository.findByGenere(genere);
    }
    public Artista findById(Integer id) {
        Optional<Artista> artista = artistaRepository.findById(id);
        return artista.get();
    }
    public Artista addArtista(Artista artista){
        return artistaRepository.save(artista);
    }

    public Artista addOnlyArtista(Artista artista){
        return artistaRepository.save(artista);
    }
}
