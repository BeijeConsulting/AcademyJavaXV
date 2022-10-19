package it.beije.hopper.rubrica.controller;

import it.beije.hopper.rubrica.model.Contatto;
import it.beije.hopper.rubrica.service.ContattoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "api")
public class ContattoRestController {

    @Autowired
    private ContattoService contattoService;

    public ContattoRestController() {
        System.out.println("creo un oggetto MusicController...");
    }

    @GetMapping(value = "/contatto/{id}")
    public Optional<Contatto> getUser(@PathVariable(name = "id") Integer id) {
        System.out.println("GET getUser : " + id);

        Optional<Contatto> user = contattoService.findById(id);
        System.out.println("user : " + user.get());

        return user;
    }


    @PostMapping(value = "/contatto")
    public Contatto insertContatto(@RequestBody Contatto contatto) {
        System.out.println("POST insertContatto : " + contatto);

        contattoService.save(contatto);
        System.out.println("contatto post save : " + contatto);

        return contatto;
    }

    @PutMapping(value = "/contatto/{id}")
    public Contatto updateContatto(@PathVariable(name = "id") Integer id, @RequestBody Contatto newData) {
        System.out.println("POST updateContatto id : " + id + " : " + newData);

        if (id.compareTo(newData.getId()) == 0) {//OK modifico

            Optional<Contatto> contattoOptional = contattoService.findById(id);
            Contatto contatto;
            if (contattoOptional.isPresent())
                contatto = contattoOptional.get();
            else throw new IllegalArgumentException("id non valido");

            contatto.setCognome(newData.getCognome());
            contatto.setNome(newData.getNome());
            contatto.setNote(newData.getNote());
            contatto.setEmail(newData.getEmail());
            contatto.setTelefono(newData.getTelefono());

            BeanUtils.copyProperties(newData, contatto, "id");

            contattoService.save(contatto);
            System.out.println("contatto with new data : " + contatto);

            return contatto;
        } else
            throw new IllegalArgumentException("id non corrispondenti");
    }

    @DeleteMapping(value = "/contatto/{id}")
    public String deleteContatto(@PathVariable(name = "id") Integer id) {
        System.out.println("DELETE deleteContatto : " + id);

        Optional<Contatto> c = contattoService.findById(id);
        contattoService.delete(c.get());

        return "{\"message\":\"rimosso contatto " + id + "\"}";
    }
}
