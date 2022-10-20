package it.beije.magazzino.controller;

import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.service.SpedizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class RestControllerSpedizioni {

    @Autowired
    SpedizioneService spedizioneService;

    // - Servizio REST che restituisce la lista di tutte le spedizioni
    @GetMapping(value = "findAllSpedizioni")
    public List<Spedizione> findAllSpedizioni() {
        return spedizioneService.findAllSpedizioni();
    }

    @GetMapping(value = "findSpedizioneById/{id}")
    public Spedizione findSpedizioneById(@PathVariable(name = "id")Integer id){
        return spedizioneService.findSpedizioneById(id);
    }
}
