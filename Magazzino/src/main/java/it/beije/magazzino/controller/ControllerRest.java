package it.beije.magazzino.controller;


import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
public class ControllerRest {

    public ControllerRest(){
        System.out.println("DEBUG: ControllerRest has been instanced");
    }

    @Autowired
    private ProdottoRepository prodottoRepository;
    @Autowired
    private ProdottoService prodottoService;


    @GetMapping(value = "/all")
    public List<Prodotto> getAllProductsRest(){
        System.out.println("/all get REST");

        List<Prodotto> lista = prodottoService.findAll();
        System.out.println("Lista REST: " + lista + "\n");

        return lista;
    }
    @GetMapping(value = "/detail/{id}")
    public  Prodotto showDetailRest(@PathVariable(name = "id") Integer id){

        System.out.println("/detail get REST");
        Prodotto prodotto = prodottoService.findById(id);

        System.out.println("Prodotto:" + prodotto);
        return prodotto;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public Prodotto addProdottoRest(@RequestBody Prodotto prodotto){
        System.out.println("/add POST REST");
        prodottoService.save(prodotto);
        System.out.println("Prodotto salvato come:" + prodotto);
        return prodotto;

    }

    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public Prodotto updateProdottoRest(@RequestBody Prodotto newProdotto, @PathVariable Integer id){
        System.out.println("/update POST REST");
        Prodotto prodotto = prodottoService.findById(id);

       if(newProdotto.getNome() != null) prodotto.setNome(newProdotto.getNome());
       if(newProdotto.getTipologia() != null) prodotto.setTipologia(newProdotto.getTipologia());
       if(newProdotto.getDescrizione() != null) prodotto.setDescrizione(newProdotto.getDescrizione());
       if(newProdotto.getQuantita() >= 0) prodotto.setQuantita(newProdotto.getQuantita());

        prodottoRepository.save(prodotto);
        System.out.println("Prodotto aggiornato come:" + prodotto);

        return prodotto;

    }
    @DeleteMapping(value = "delete/{id}")
    public void deleteProdottoRest(@PathVariable Integer id){
        System.out.println("/delete DELETE REST");
        prodottoRepository.deleteById(id);

    }

    @GetMapping(value = "/findbytipo/{tipologia}")
    public List<Prodotto> findByTipoRest(@PathVariable(name ="tipologia") String tipologia){
        System.out.println("/findbytipo GET REST");

        List <Prodotto> listaProdotti = prodottoRepository.findProdottoByTipologia(tipologia);

        return listaProdotti;
    }


}
