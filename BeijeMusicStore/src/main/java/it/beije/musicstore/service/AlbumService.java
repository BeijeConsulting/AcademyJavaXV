package it.beije.musicstore.service;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;


    public AlbumService() {
        System.out.println("creo un oggetto AlbumService...");
    }

    public List<Album> findByArtista(int artista_id) {
        return albumRepository.findByArtista(artista_id);
    }

    public List<Album> findByGenere(String genere) {
        return albumRepository.findByGenere(genere);
    }

    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    public List<String> getAllGeneri() {
        return albumRepository.getallGeneri();
    }

    public Optional<Album> findById(Integer id) {
        return albumRepository.findById(id);
    }

    public void save(Album album) {
        albumRepository.save(album);
    }

    public void delete(Album album) {
        albumRepository.delete(album);
    }
    //public List<album> findByCanzone(String canzone) {
    // return AlbumRepository.findByCanzone(canzone);
    //}

}
