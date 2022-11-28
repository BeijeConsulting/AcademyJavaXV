package it.beije.hopper.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import it.beije.hopper.model.Contenuto;
import it.beije.hopper.model.Product;
import it.beije.hopper.model.Spedizione;
import it.beije.hopper.service.ContenutoService;
import it.beije.hopper.service.ProductService;
import it.beije.hopper.service.SpedizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class MyRestController {

	public MyRestController() {
		System.out.println("creo un oggetto MyRestController...");
	}
	@Autowired
	private ProductService productService;

	@Autowired
	private SpedizioneService spedizioneService;

	@Autowired
	private ContenutoService contenutoService;


	@GetMapping(value = "/restListP")
	public List<Product> restListP() {
		System.out.println("GET restListP...");

		List<Product> lista = productService.findAll();
		System.out.println("lista : " + lista);

		return lista;
	}

	@GetMapping(value = "/restListS")
	public List<Spedizione> restListS() {
		System.out.println("GET restListS...");

		List<Spedizione> lista = spedizioneService.findAll();
		System.out.println("lista : " + lista);

		return lista;
	}

	@GetMapping(value = "/restInfoP/{id}")
	public Product restInfoP(@PathVariable(name = "id") Integer id) {
		System.out.println("GET restInfoP...");

		Product prodotto = productService.findById(id);
		System.out.println("info prodotto : " + prodotto);

		return prodotto;
	}

	@GetMapping(value = "/restInfoS/{id}")
	public Spedizione restInfoS(@PathVariable(name = "id") Integer id) {
		System.out.println("GET restInfoS...");

		Spedizione spedizione = spedizioneService.findById(id);
		System.out.println("info spedizione : " + spedizione);

		return spedizione;
	}

	@PostMapping(value = "/restNewP")
	public Product restNewP(@RequestBody Product prodotto, Model model) {
		System.out.println("POST restNewP...");

		productService.saveProduct(prodotto);
		System.out.println("nuovo prodotto : " + prodotto);

		return prodotto;
	}

	@PostMapping(value = "/restEditP")
	public Product restEditP(@RequestBody Product prodotto, Model model) {
		System.out.println("POST restEditP...");
		Product p = productService.findById(prodotto.getId());

		if(prodotto.getNome() != null){
			p.setNome(prodotto.getNome());
		}
		if(prodotto.getTipo() != null){
			p.setTipo(prodotto.getTipo());
		}
		if(prodotto.getQuantita() != null){
			p.setQuantita(prodotto.getQuantita());
		}
		if(prodotto.getDescrizione() != null){
			p.setDescrizione(prodotto.getDescrizione());
		}

		productService.saveProduct(p);
		System.out.println("prodotto modificato : " + p);

		return p;
	}

	@DeleteMapping(value = "/restDeleteP/{id}")
	public Product restDeleteP(@PathVariable(name = "id") Integer id) {
		System.out.println("GET restDeleteP...");

		Product prodotto = productService.findById(id);
		productService.deleteProduct(prodotto);
		System.out.println("info prodotto : " + prodotto);

		return prodotto;
	}

	@GetMapping(value = "/restListPbyTipo/{tipo}")
	public List<Product> restListPbyTipo(@PathVariable(name = "tipo") String tipo) {
		System.out.println("GET restDeleteP...");

		List<Product> list = productService.listByTipo(tipo);
		System.out.println("Lista prodotti per tipo : " + list);

		return list;
	}

	@GetMapping(value = "/restFindPbyNome_Desc/{nome}/{descrizione}")
	public List<Product> restFindPbyNome_Desc(@PathVariable(name = "nome") String nome,
											  @PathVariable(name = "descrizione") String descrizione,
											  Model model) {
		System.out.println("GET restDeleteP...");
		List<Product> prodotti = new ArrayList<>();

		if((!nome.isEmpty()) && (!descrizione.isEmpty())){
			System.out.println(nome+" AND "+descrizione);
			prodotti = productService.findByNomeAndDescrizione(nome, descrizione);
		}else if(!nome.isEmpty() | !descrizione.isEmpty()){
			System.out.println("OR");
			prodotti = productService.findByNomeOrDescrizione(nome, descrizione);
		}else{
			model.addAttribute("error", "Devi inserire almeno un nome o una descrizione");
		}

		return prodotti;
	}
}
