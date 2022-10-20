package it.beije.magazzino.controller;


import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        List<Prodotto> lista = prodottoService.loadAll();
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


}
