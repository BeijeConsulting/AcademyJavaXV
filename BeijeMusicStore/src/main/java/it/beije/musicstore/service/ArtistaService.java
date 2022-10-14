package it.beije.musicstore.service;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    public ArtistaService() {
        System.out.println("creo un oggetto ArtistaService...");
    }

    public Artista findById(int id){
        Artista artista = artistaRepository.findById(id);
        return artista;
    }

    public List<Artista> loadArtistaByCanzone(String canzone){
        List<Artista> artista = artistaRepository.loadArtistaByCanzone(canzone);
        return artista;
    }

//    public List<Artista> loadProduct() {
////		User user = new User();
////		user.setEmail(username);
////		user.setFirstName("Pippo");
////		user.setLastName("Rossi");
//
////		Optional<User> u = userRepository.findById(1);
////		User user = u.isPresent() ? u.get() : new User();
//
//        List<Artista> artisti = artistaRepository.findAll();
//
//        System.out.println("loadProduct : " + artisti);
//
//        return artisti;
//    }

    public List<Artista> findAll(){
        return artistaRepository.findAll();
    }

    public List<Artista> findByGenere(String genere){
        List<Artista> artisti = artistaRepository.findByGenere(genere);
        return artisti;
    }
}
