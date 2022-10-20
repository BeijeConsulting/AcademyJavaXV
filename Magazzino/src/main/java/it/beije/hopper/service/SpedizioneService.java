package it.beije.hopper.service;

import it.beije.hopper.model.Product;
import it.beije.hopper.model.Spedizione;
import it.beije.hopper.repository.ProductRepository;
import it.beije.hopper.repository.SpedizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpedizioneService {

    @Autowired
    private SpedizioneRepository spedizioneRepository;

    public SpedizioneService() {
        System.out.println("creo un oggetto ProductService...");
    }

    public List<Spedizione> findAll(){
        List<Spedizione> spedizioni = spedizioneRepository.findAll();
        return spedizioni;
    }

    public Spedizione findById(int id){
        Spedizione spedizione = spedizioneRepository.findById(id);
        return spedizione;
    }
}
