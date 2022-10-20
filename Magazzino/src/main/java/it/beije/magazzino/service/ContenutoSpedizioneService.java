package it.beije.magazzino.service;

import it.beije.magazzino.model.ContenutoSpedizione;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.ContenutoSpedizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContenutoSpedizioneService {

    @Autowired
    ContenutoSpedizioneRepository contenutoSpedizioneRepository;
    @Autowired
    SpedizioneService spedizioneService;

    public void addContenuto(ContenutoSpedizione contenutoSpedizione){
        contenutoSpedizioneRepository.save(contenutoSpedizione);
    }
    public Spedizione findByProductId(Integer id) {
        ContenutoSpedizione contenutoSpedizione = contenutoSpedizioneRepository.findSpedizioneByProdottoId(id);
        return spedizioneService.findSpedizioneById(contenutoSpedizione.getSpedizioneId());
    }
}
