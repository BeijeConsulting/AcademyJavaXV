package it.beije.musicstore.service;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    public Album findByAlbum(String nomeAlbum){
        return albumRepository.findByAlbum(nomeAlbum);
    }
    public Album save(Album album){return albumRepository.save(album);}
}
