package it.beije.musicstore.service;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public AlbumService() {
        System.out.println("creo un oggetto AlbumService...");
    }

    public List<Album> findByIdArtista(int id){
        List<Album> albums = albumRepository.findByIdArtista(id);
        return albums;
    }

    public List<Album> findByGenere(String genere){
        List<Album> albums = albumRepository.findByGenere(genere);
        return albums;
    }

    public List<Album> findAll(){
        return albumRepository.findAll();
    }
}
