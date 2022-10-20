package it.beije.magazzino.controller;


import javax.servlet.http.HttpServletRequest;
import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class ProdottoController {
	
	@Autowired
	private ProdottoService ProdottoService;
	
	

	public ProdottoController() {
		System.out.println("creo un oggetto ProdottoController...");
	}
	
	@RequestMapping(value = "/findprodotto", method = RequestMethod.GET)
	public String findprodotto(HttpServletRequest request, Model model) throws Exception {

		return "findprodotto";
	}
	


	@RequestMapping(value = "/insertprodotto", method = RequestMethod.GET)
	public String insertprodotto(HttpServletRequest request, Model model) throws Exception {

		return "insert";
	}
	
	@RequestMapping(value = "/in", method = RequestMethod.POST)
	public String insertedProdotto(HttpServletRequest request, Model model, @RequestParam(name = "nome") String nome,
			@RequestParam(name = "tipologia") String tipologia, @RequestParam(name = "quantita") Integer quantita,
			@RequestParam(name = "descrizione") String descrizione) {

		Prodotto prodotto = new Prodotto();
		prodotto.setName(nome);
		prodotto.setTipo(tipologia);
		prodotto.setQuantity(quantita);
		prodotto.setDesc(descrizione);

		ProdottoService.insert(prodotto);

		String stringa="insert";
		model.addAttribute("insert",stringa);
		return "inserito";
	}


	@RequestMapping(value = "/prodotti", method = RequestMethod.GET)
	public String getprodotti(HttpServletRequest request, Model model) throws Exception {

		List<Prodotto> prodotti = ProdottoService.getAll();
		model.addAttribute("prodotti", prodotti);
		return "list";
	}

	
	@RequestMapping(value = "/TrovatoProdotto", method = RequestMethod.GET)
	public String prodottobyid(HttpServletRequest request, Model model,@RequestParam(name="id")Integer id) throws Exception {

		Prodotto prodotto=ProdottoService.findById(id);
		model.addAttribute("prodotto",prodotto);
		return "Eccoprodotto";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateprodotto(HttpServletRequest request, Model model) throws Exception {

		List<Prodotto> prodotti = ProdottoService.getAll();
		model.addAttribute("prodotti", prodotti);

		return "updatep";
	}
	
	@RequestMapping(value = "/changeprodotto", method = RequestMethod.POST)
	public String updatedProdotto(HttpServletRequest request, Model model, @RequestParam(name = "id") Integer id,
			@RequestParam(name = "nome") String nome, @RequestParam(name = "tipologia") String tipologia,
			@RequestParam(name = "quantita") Integer quantita, @RequestParam(name = "descrizione") String descrizione) throws Exception {

		Prodotto prodotto =ProdottoService.findById(id);
		if(nome!=null)
			prodotto.setName(nome);
		if(tipologia!=null)
			prodotto.setTipo(tipologia);
		if(quantita!=null)
			prodotto.setQuantity(quantita);
		if(descrizione!=null)
			prodotto.setDesc(descrizione);

		ProdottoService.insert(prodotto);

		model.addAttribute("prodotto", prodotto);
		String stringa="update";
		model.addAttribute("update",stringa);
		return "inserito";
	}

	@RequestMapping(value = "/deleteprodotto", method = RequestMethod.GET)
	public String deleteprodotto(HttpServletRequest request, Model model) throws Exception {

		List<Prodotto> prodotti = ProdottoService.getAll();
		
		model.addAttribute("prodotti", prodotti);

		return "deleteprodotto";
	}
	
	@RequestMapping(value = "deletedprodotto", method = RequestMethod.POST)
	public String deletedProdotto(HttpServletRequest request, Model model, @RequestParam(name = "id") Integer id) throws Exception {
		
		ProdottoService.delete(id);
		
		String stringa="delete";
		model.addAttribute("delete",stringa);
		return "insertedprodotto";
	}
}