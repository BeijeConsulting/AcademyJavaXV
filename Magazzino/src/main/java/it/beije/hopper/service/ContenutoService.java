package it.beije.hopper.service;

import it.beije.hopper.model.Contenuto;
import it.beije.hopper.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenutoService {

    @Autowired
    private ContenutoRepository contenutoRepository;

    public ContenutoService() {
        System.out.println("creo un oggetto ProductService...");
    }

    public List<Contenuto> findAll(){
        List<Contenuto> contenuti = contenutoRepository.findAll();
        return contenuti;
    }
    public List<Contenuto> findByIdSpedizione(int id){
        List<Contenuto> contenuti = contenutoRepository.findByIdSpedizione(id);
        return contenuti;
    }


}
