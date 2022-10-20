package it.beije.magazzino.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.service.ProdottoService;


@Controller
public class ProdottoController {
	
	@Autowired
	private ProdottoService prodottoService;
	
	@Autowired
	private ProdottoRepository prodottoRepository;

	public ProdottoController() {
		System.out.println("creo un oggetto ProdottoController...");
	}
	
	@RequestMapping(value = "/listaprodotti", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		System.out.println("test : " + locale);

		List<Prodotto> lista = prodottoService.findAll();
		System.out.println("lista : " + lista);
		model.addAttribute("lista", lista);
		
		return "lista_prodotti";
	}
	
	
	@RequestMapping(value = "/formprodotti", method = RequestMethod.GET)
	public String form() {
		System.out.println("GET login...");

		return "form_id";
	}
	
	
	@RequestMapping(value = "/formprodotti", method = RequestMethod.POST)
	public String form(HttpSession session,
			@RequestParam(name = "id", required = false) Integer id,
			Model model) {
		
		System.out.println("POST id...");
		
		System.out.println("id : " + id);
		
		if (id != null) {
			Prodotto prodotto = prodottoService.findById(id);
				
				model.addAttribute("prodotto", prodotto);
								
				return "prodotto_id";
			} 

		return "form_id";
	}
	
	@RequestMapping(value = "/nuovoprodotto", method = RequestMethod.GET)
	public String inserisci() {
		System.out.println("GET inserisci...");

		return "inserisci";
	}
	
	@RequestMapping(value = "/nuovoprodotto", method = RequestMethod.POST)
	public String inserisciPulsante(HttpSession session,
			@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "tipologia", required = false) String tipologia,
			@RequestParam(name = "quantita", required = false) Integer quantita,
			@RequestParam(name = "descrizione", required = false) String descrizione,
			Model model) {
		System.out.println("GET inserisciPulsante...");

		Prodotto prodotto = new Prodotto();
		
		prodotto.setDescrizione(descrizione);
		prodotto.setNome(nome);
		prodotto.setQuantita(quantita);
		prodotto.setTipologia(tipologia);
		
		prodottoRepository.save(prodotto);
		
		return "inserisci_pulsante";
	}
	
	@RequestMapping(value = "/aggiornaprodotto", method = RequestMethod.GET)
	public String aggiorna() {
		System.out.println("GET aggiorna...");

		return "update_form";
	}
	
	@RequestMapping(value = "/aggiornaprodotto", method = RequestMethod.POST)
	public String updatePulsante(HttpSession session,
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "tipologia", required = false) String tipologia,
			@RequestParam(name = "quantita", required = false) Integer quantita,
			@RequestParam(name = "descrizione", required = false) String descrizione,
			Model model) {
		System.out.println("GET updatePulsante...");
		
		Prodotto p = prodottoService.findById(id);
		
		p.setDescrizione(descrizione);
		p.setNome(nome);
		p.setQuantita(quantita);
		p.setTipologia(tipologia);
		
		prodottoRepository.save(p);
		
		return "update_pulsante";
	}
	
	@RequestMapping(value = "/eliminaprodotto", method = RequestMethod.GET)
	public String elimina() {
		System.out.println("GET elimina...");

		return "elimina_form";
	}
	
	@RequestMapping(value = "/eliminaprodotto", method = RequestMethod.POST)
	public String elimina(HttpSession session,
			@RequestParam(name = "id", required = false) Integer id,
			Model model) {
		
		Prodotto p = prodottoService.findById(id);
		prodottoRepository.delete(p);
		return "elimina_pulsante";
	}
	
	@RequestMapping(value = "/tipologiaprodotto", method = RequestMethod.GET)
	public String tipologia() {
		System.out.println("GET elimina...");

		return "tipologia_form";
	}
	
	@RequestMapping(value = "/tipologiaprodotto", method = RequestMethod.POST)
	public String tipologia(HttpSession session,
			@RequestParam(name = "tipologia", required = false) String tipologia,
			Model model) {
		System.out.println("POST tipologia...");
		
		List<Prodotto> prodotti = prodottoService.findByTipologia(tipologia);
		
		model.addAttribute("prodotti", prodotti);

		return "tipologia_pulsante";
	}
	
	@RequestMapping(value = "/tipologianome", method = RequestMethod.GET)
	public String tipologiaNome() {
		System.out.println("GET tipologianome...");

		return "tipologianome_form";
	}
	
	@RequestMapping(value = "/tipologianome", method = RequestMethod.POST)
	public String tipologiaNome(HttpSession session,
			@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "descrizione", required = false) String descrizione,
			Model model) {
		System.out.println("POST tipologia...");
		
		
		if (!nome.isEmpty() && descrizione.isEmpty())
		{
			List<Prodotto>prodotti = prodottoService.findByNome(nome);
			System.out.println(prodotti);
			model.addAttribute("prodotti", prodotti);
			return "tipologianome_pulsante";
		}
		
		if (nome.isEmpty() && !descrizione.isEmpty())
		{
			List<Prodotto>prodotti = prodottoService.findByDescrizione(descrizione);
			System.out.println(prodotti);
			model.addAttribute("prodotti", prodotti);
			return "tipologianome_pulsante";
		}
		
		if (!nome.isEmpty() && !descrizione.isEmpty())
		{
			List<Prodotto>prodotti = prodottoService.findByNomeAndDescrizione(nome,descrizione);
			System.out.println(prodotti);
			model.addAttribute("prodotti", prodotti);
			return "tipologianome_pulsante";
		}
		
		

		return "tipologianome_form";
	}
	

	
}
