package it.beije.magazzino.service;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService {

    @Autowired
    ProdottoRepository prodottoRepository;

    @Autowired
    ProdottoService prodottoService;

    //Costruttore per ProdottoService
    public ProdottoService(){
        System.out.println("DEBUG: ProdottoService has been instanced");
    }

    public List<Prodotto> loadAll(){
        return prodottoRepository.loadAll();
    }


}
