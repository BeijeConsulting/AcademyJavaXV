package it.beije.magazzino.controller;

import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.service.SpedizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*@RestController
@RequestMapping(value = "api")
public class SpedizioneRestController {
    @Autowired
    private SpedizioneService spedizioneService;

    public SpedizioneRestController() {
        System.out.println("creo un oggetto SpedizioneRestController...");
    }


    @GetMapping(value = "/prodotti")
    public List<Spedizione> prodotti() {

        List<Spedizione> lista = spedizioneService.findAll();
        System.out.println("lista : " + lista);
        return lista;
    }

    @GetMapping(value = "/spedizione_by_id/{id}")
    public List<Spedizione> spedizioneById(@PathVariable(name = "id") Integer id) {
        System.out.println("GET : " + id);

        Optional<Spedizione> spedizione = spedizioneService.findById(id);
        List<Spedizione> lista = new ArrayList<>();
        spedizione.ifPresent(lista::add);
        return lista;
    }
    
}*/
