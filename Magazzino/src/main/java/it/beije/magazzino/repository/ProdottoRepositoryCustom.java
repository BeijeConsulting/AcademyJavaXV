package it.beije.magazzino.repository;

import it.beije.magazzino.model.Prodotto;

import java.util.List;

public interface ProdottoRepositoryCustom {
    List<Prodotto> findByNomeAndDescrizione(String nome, String descrizione);

}
