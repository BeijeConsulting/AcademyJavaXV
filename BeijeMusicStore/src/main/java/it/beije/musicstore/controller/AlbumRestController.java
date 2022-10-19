package it.beije.musicstore.controller;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.service.AlbumService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
public class AlbumRestController {

    @Autowired
    private AlbumService albumService;


    public AlbumRestController() {
        System.out.println("creo un oggetto MusicController...");
    }

    @GetMapping(value = "/album_by_artista/{id}")
    public List albumByArtistaRest(@PathVariable(name = "id") Integer id) {
        System.out.println("GET getUser : " + id);

        List<Album> lista = albumService.findByArtista(id);



        return lista;
    }

    @GetMapping(value = "/album_by_genere/{genere}")
    public List albumByGenereRest(@PathVariable(name = "genere") String genere) {
        System.out.println("GET getUser : " + genere);

        List<Album> lista = albumService.findByGenere(genere);


        return lista;
    }

    @GetMapping(value = "/album_by_id/{id}")
    public List albumByIdRest(@PathVariable(name = "id") Integer id) {
        System.out.println("test : " + id);

        Optional<Album> art = albumService.findById(id);

        List<Album> lista = new ArrayList<>();
        art.ifPresent(lista::add);

        return lista;
    }


    @PostMapping(value = "/album")
    public Album insertAlbum(@RequestBody Album album) {
        System.out.println("POST insertAlbum : " + album);

        albumService.save(album);
        System.out.println("album post save : " + album);

        return album;
    }

    @PutMapping(value = "/album/{id}")
    public Album updateAlbum(@PathVariable(name = "id") Integer id, @RequestBody Album newData) {
        System.out.println("POST updateAlbum id : " + id + " : " + newData);

        if (id.compareTo(newData.getId()) == 0) {//OK modifico

            Optional<Album> album = albumService.findById(id);

            Album a;
            if (album.isPresent())
                a = album.get();
            else throw new IllegalArgumentException("id non valido");

            a.setData(newData.getData());
            a.setGenere(newData.getGenere());
            a.setTitolo(newData.getTitolo());
            a.setCanzoni(newData.getCanzoni());

            BeanUtils.copyProperties(newData, album, "id");

            albumService.save(a);
            System.out.println("album with new data : " + album);

            return a;
        } else
            throw new IllegalArgumentException("id non corrispondenti");
    }

    @DeleteMapping(value = "/album/{id}")
    public String deleteAlbum(@PathVariable(name = "id") Integer id) {
        System.out.println("DELETE deleteAlbum : " + id);

        Optional<Album> c = albumService.findById(id);
        albumService.delete(c.get());

        return "{\"message\":\"rimosso album " + id + "\"}";
    }

}