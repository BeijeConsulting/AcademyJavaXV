package it.beije.magazzino.service;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService {

    @Autowired
    private ProdottoRepository prodottoRepository;

    public ProdottoService(){
        System.out.println("Creazione oggetto ProdottoService ");
    }
    public List<Prodotto> findAll(){
        return prodottoRepository.findAll();
    }

    public Prodotto findById(int id){
        return prodottoRepository.findById(id);
    }

    public Prodotto save(Prodotto prodotto){
        return prodottoRepository.save(prodotto);
    }

    public List<Prodotto> findByTipologia(String tipologia){
        return prodottoRepository.findByTipologia(tipologia);
    }

    public List<Prodotto> findByNomeOrDescrizione(String nome, String descrizione){
        return prodottoRepository.findByNomeOrDescrizione(nome,descrizione);
    }
}
