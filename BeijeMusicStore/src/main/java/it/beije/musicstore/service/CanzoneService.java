package it.beije.musicstore.service;

import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.repository.CanzoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanzoneService {
    @Autowired
    private CanzoneRepository canzoneRepository;
    public List<Canzone> findByIdAlbum(Integer id){
        return canzoneRepository.findByIdAlbum(id);
    }

}
