package it.beije.musicstore.controller;

import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.CanzoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rest")
public class CanzoneControllerRest {

    @Autowired
    CanzoneService canzoneService;

    @GetMapping(value = "/getCanzone/{id}")
    public Canzone getCanzone(@PathVariable(name = "id") Integer id) {
        return canzoneService.getCanzoneById(id);
    }

    @PutMapping(value = "updateCanzone/{id}")
    public Canzone updateCanzone(@PathVariable(name = "id") Integer id, @RequestBody Canzone newCanzone) {
        if (canzoneService.getCanzoneById(id) != null) {
            Canzone canzone = canzoneService.getCanzoneById(id);
            BeanUtils.copyProperties(newCanzone, canzone, "id");
            return canzoneService.save(canzone);
        } else {
            throw new IllegalArgumentException("id non corrispondenti");
        }
    }
}
