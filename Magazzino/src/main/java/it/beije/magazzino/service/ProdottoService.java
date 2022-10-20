package it.beije.magazzino.service;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Prodotto findById(Integer id){
        Optional<Prodotto> prodotto = prodottoRepository.findById(id);
        if(!prodotto.isPresent()) throw new IllegalArgumentException("Prodotto non trovato id: " + id);

        return prodotto.get();
    }


}
