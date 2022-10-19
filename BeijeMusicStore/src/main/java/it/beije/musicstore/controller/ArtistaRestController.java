package it.beije.musicstore.controller;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.service.ArtistaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "api")
public class ArtistaRestController {

    @Autowired
    private ArtistaService artistaService;

    public ArtistaRestController() {
        System.out.println("creo un oggetto MusicController...");
    }


    @GetMapping(value = "/artista_by_genere/{genere}")
    public List artistaById(@PathVariable(name = "gemere") String genere) {
        System.out.println("GET genere : " + genere);

        List<Artista> lista = artistaService.findByGenere(genere);
        return lista;
    }


    @GetMapping(value = "/artista_by_id/{id}")
    public List artistaById(@PathVariable(name = "id") Integer id) {
        System.out.println("GET : " + id);

        Optional<Artista> artista = artistaService.findById(id);
        List<Artista> lista = new ArrayList<>();
        artista.ifPresent(lista::add);
        return lista;
    }

    @PostMapping(value = "/artista")
    public Artista insertArtista(@RequestBody Artista artista) {
        System.out.println("POST insertArtista : " + artista);

        artistaService.save(artista);
        System.out.println("artista post save : " + artista);

        return artista;
    }

    @PutMapping(value = "/artista/{id}")
    public Artista updateArtista(@PathVariable(name = "id") Integer id, @RequestBody Artista newData) {
        System.out.println("POST updateArtista id : " + id + " : " + newData);

        if (id.compareTo(newData.getId()) == 0) {//OK modifico

            Optional<Artista> artista = artistaService.findById(id);

            Artista a;
            if (artista.isPresent())
                a = artista.get();
            else throw new IllegalArgumentException("id non valido");

            a.setNome(newData.getNome());
            a.setGenere(newData.getGenere());
            a.setAlbums(newData.getAlbums());
            a.setCanzoni(newData.getCanzoni());

            BeanUtils.copyProperties(newData, artista, "id");

            artistaService.save(a);
            System.out.println("artista with new data : " + artista);

            return a;
        } else
            throw new IllegalArgumentException("id non corrispondenti");
    }

    @DeleteMapping(value = "/artista/{id}")
    public String deleteArtista(@PathVariable(name = "id") Integer id) {
        System.out.println("DELETE deleteArtista : " + id);

        Optional<Artista> c = artistaService.findById(id);
        artistaService.delete(c.get());

        return "{\"message\":\"rimosso artista " + id + "\"}";
    }

}
