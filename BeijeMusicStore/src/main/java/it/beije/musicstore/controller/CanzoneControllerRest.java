package it.beije.musicstore.controller;

import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.CanzoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest")
public class CanzoneControllerRest {

    @Autowired
    CanzoneService canzoneService;

    @GetMapping(value = "/getCanzone/{id}")
    public Canzone getCanzone(@PathVariable(name = "id") Integer id) {
        return canzoneService.getCanzoneById(id);
    }
}
