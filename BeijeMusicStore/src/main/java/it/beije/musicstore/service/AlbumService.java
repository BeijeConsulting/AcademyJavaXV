package it.beije.musicstore.service;


import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artista;
import it.beije.musicstore.repository.AlbumRepository;
import it.beije.musicstore.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ArtistaService artistaService;
    public AlbumService(){
        System.out.println("Creating Album Service...");
    }

    public List<Album> findAlbumByIdArtista(Integer idArtista){
        return albumRepository.findAlbumByIdArtista(idArtista);
    }

    // TODO: join artista and album --> search there
    public List<Album> findAlbumByNomeArtista(String nome){
        Artista artista = artistaService.findArtistaByNome(nome);
        List<Album> result = findAlbumByIdArtista(artista.getId());
        return result;
    }


    public List<Album> findAllAlbums(){
        return albumRepository.findAll();
    }


    public Integer findIdByAlbumNome(String nomeAlbum){
        return albumRepository.findIdByAlbumNome(nomeAlbum);
    }
}
