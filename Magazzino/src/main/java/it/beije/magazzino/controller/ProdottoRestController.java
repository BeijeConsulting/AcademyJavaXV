package it.beije.magazzino.controller;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.service.ProdottoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "api")
public class ProdottoRestController {

    @Autowired
    private ProdottoService prodottoService;

    public ProdottoRestController() {
        System.out.println("creo un oggetto ProdottoRestController...");
    }


    @GetMapping(value = "/prodotti")
    public List<Prodotto> prodotti() {

        List<Prodotto> lista = prodottoService.findAll();
        System.out.println("lista : " + lista);
        return lista;
    }

    @GetMapping(value = "/prodotto_by_id/{id}")
    public List<Prodotto> prodottoById(@PathVariable(name = "id") Integer id) {
        System.out.println("GET : " + id);

        Optional<Prodotto> prodotto = prodottoService.findById(id);
        List<Prodotto> lista = new ArrayList<>();
        prodotto.ifPresent(lista::add);
        return lista;
    }


    @GetMapping(value = "/prodotti_by_tipologia/{tipologia}")
    public List<Prodotto> prodottoByTipologia(@PathVariable(name = "tipologia") String tipologia) {
        System.out.println("test : " + tipologia);

        List<Prodotto> lista = prodottoService.findByTipologia(tipologia);
        System.out.println("lista : " + lista);

        return lista;
    }

    @GetMapping(value = "/prodotti_by_nome_or_descrizione/{nome}/{descrizione}")
    public List<Prodotto> prodottoByNomeOrDescrizione(
                                  @PathVariable(name = "nome", required = true) String nome,
                                  @RequestParam(name = "descrizione", required = true) String descrizione) {
        System.out.println("test : " + nome);

        List<Prodotto> lista = prodottoService.findByNomeOrDescrizione(nome, descrizione);
        System.out.println("lista : " + lista);

        return lista;
    }

    @PostMapping(value = "/prodotto")
    public Prodotto insertProdotto(@RequestBody Prodotto prodotto) {
        System.out.println("POST insertProdotto : " + prodotto);

        prodottoService.save(prodotto);
        System.out.println("prodotto post save : " + prodotto);

        return prodotto;
    }

    @PutMapping(value = "/prodotto/{id}")
    public Prodotto updateProdotto(@PathVariable(name = "id") Integer id, @RequestBody Prodotto newData) {
        System.out.println("POST updateProdotto id : " + id + " : " + newData);

        if (id.compareTo(newData.getId()) == 0) {//OK modifico

            Optional<Prodotto> prodotto = prodottoService.findById(id);

            Prodotto a;
            if (prodotto.isPresent())
                a = prodotto.get();
            else throw new IllegalArgumentException("id non valido");

            a.setNome(newData.getNome());
            a.setTipologia(newData.getTipologia());
            a.setQuantita(newData.getQuantita());
            a.setDescrizione(newData.getDescrizione());

            BeanUtils.copyProperties(newData, prodotto, "id");

            prodottoService.save(a);
            System.out.println("prodotto with new data : " + prodotto);

            return a;
        } else
            throw new IllegalArgumentException("id non corrispondenti");
    }

    @DeleteMapping(value = "/prodotto/{id}")
    public String deleteProdotto(@PathVariable(name = "id") Integer id) {
        System.out.println("DELETE deleteProdotto : " + id);

        Optional<Prodotto> c = prodottoService.findById(id);
        prodottoService.delete(c.get());

        return "{\"message\":\"rimosso prodotto " + id + "\"}";
    }

}
