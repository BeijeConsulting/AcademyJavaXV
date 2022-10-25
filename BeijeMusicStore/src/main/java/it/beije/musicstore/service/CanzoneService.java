package it.beije.musicstore.service;


import it.beije.musicstore.model.Artista;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.repository.ArtistaRepository;
import it.beije.musicstore.repository.CanzoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanzoneService {

    @Autowired
    CanzoneRepository canzoneRepository;


    @Autowired
    AlbumService albumService;

    public CanzoneService(){
        System.out.println("Creating canzone Service...");
    }

    public List<Canzone> findAll(){
        return canzoneRepository.findAll();
    }

    public List<Canzone> findCanzoniFromAlbumId(Integer idAlbum){
        return canzoneRepository.findCanzoniFromAlbumId(idAlbum);
    }


    public List<Canzone> findCanzoniFromAlbumNome( String nome){
        List<Canzone> canzoni = findCanzoniFromAlbumId( albumService.findIdByAlbumNome(nome));
        return canzoni;
    }
}
