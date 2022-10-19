package it.beije.musicstore.controller;

import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.service.CanzoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "api")
public class CanzoneRestController {

	@Autowired
	private CanzoneService canzoneService;

	public CanzoneRestController() {
		System.out.println("creo un oggetto MusicController...");
	}
	

	@GetMapping(value = "/canzoni_by_album/{album}")
	public List canzoniByAlbum(HttpSession session,
					   @PathVariable(name = "album") Integer id) {
		System.out.println("id_album : " + id);

		List<Canzone> lista = canzoneService.findByAlbum(id);

		return lista;
	}

	@RequestMapping(value = "/canzoni_by_artista/{id_artista}")
	public List canzoniByArtista(HttpSession session,
								  @PathVariable(name = "id_artista") Integer id) {
		System.out.println("id_artista : " + id);

		List<Canzone> lista = canzoneService.findByArtista(id);

		return lista;
	}

	@RequestMapping(value = "/canzone_by_genere/{genere}")
	public List<Canzone> canzoneByGenere(HttpSession session,
										 @RequestParam(name = "genereCanzoni") String genere) {
		System.out.println("test : " + genere);

		List<Canzone> lista =  canzoneService.findByGenere(genere);

		return lista;
	}

	@PostMapping(value = "/canzone")
	public Canzone insertCanzone(@RequestBody Canzone canzone) {
		System.out.println("POST insertCanzone : " + canzone);

		canzoneService.save(canzone);
		System.out.println("canzone post save : " + canzone);

		return canzone;
	}

	@PutMapping(value = "/canzone/{id}")
	public Canzone updateCanzone(@PathVariable(name = "id") Integer id, @RequestBody Canzone newData) {
		System.out.println("POST updateCanzone id : " + id + " : " + newData);

		if (id.compareTo(newData.getId()) == 0) {//OK modifico

			Canzone canzone = canzoneService.findById(id);

			canzone.setAlbum_id(newData.getAlbum_id());
			canzone.setGenere(newData.getGenere());
			canzone.setData(newData.getData());
			canzone.setTitolo(newData.getTitolo());

			BeanUtils.copyProperties(newData, canzone, "id");

			canzoneService.save(canzone);
			System.out.println("canzone with new data : " + canzone);

			return canzone;
		} else
			throw new IllegalArgumentException("id non corrispondenti");
	}

	@DeleteMapping(value = "/canzone/{id}")
	public String deleteCanzone(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE deleteCanzone : " + id);

		Canzone c = canzoneService.findById(id);
		canzoneService.delete(c);

		return "{\"message\":\"rimosso canzone " + id + "\"}";
	}
}
