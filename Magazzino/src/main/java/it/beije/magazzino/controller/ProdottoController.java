package it.beije.magazzino.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.service.ProdottoService;

@Controller
public class ProdottoController {

	@Autowired
	ProdottoService prodottoService;

	@RequestMapping(value = "prodottobyid", method = RequestMethod.GET)
	public String prodottobyid(HttpServletRequest request, Model model) throws Exception {

		Prodotto prodotto = prodottoService.getById(1);
		model.addAttribute("prodotto", prodotto);
		return "prodottobyid";
	}

	@RequestMapping(value = "getprodotti", method = RequestMethod.GET)
	public String getprodotti(HttpServletRequest request, Model model) throws Exception {

		List<Prodotto> prodotti = prodottoService.getAll();
		model.addAttribute("prodotti", prodotti);
		return "prodotti";
	}

	@RequestMapping(value = "insertprodotto", method = RequestMethod.GET)
	public String insertprodotto(HttpServletRequest request, Model model) throws Exception {

		return "insertprodotto";
	}

	@RequestMapping(value = "inprodotto", method = RequestMethod.POST)
	public String insertedProdotto(HttpServletRequest request, Model model, @RequestParam(name = "nome") String nome,
			@RequestParam(name = "tipologia") String tipologia, @RequestParam(name = "quantita") Integer quantita,
			@RequestParam(name = "descrizione") String descrizione) {

		Prodotto prodotto = new Prodotto();
		prodotto.setNome(nome);
		prodotto.setTipologia(tipologia);
		prodotto.setQuantita(quantita);
		prodotto.setDescrizione(descrizione);

		prodottoService.insert(prodotto);

		String stringa="insert";
		model.addAttribute("insert",stringa);
		return "insertedprodotto";
	}

	@RequestMapping(value = "updateprodotto", method = RequestMethod.GET)
	public String updateprodotto(HttpServletRequest request, Model model) throws Exception {

		List<Prodotto> prodotti = prodottoService.getAll();
		model.addAttribute("prodotti", prodotti);

		return "updateprodotto";
	}

	@RequestMapping(value = "upprodotto", method = RequestMethod.POST)
	public String updatedProdotto(HttpServletRequest request, Model model, @RequestParam(name = "id") Integer id,
			@RequestParam(name = "nome") String nome, @RequestParam(name = "tipologia") String tipologia,
			@RequestParam(name = "quantita") Integer quantita, @RequestParam(name = "descrizione") String descrizione) throws Exception {

		Prodotto prodotto =prodottoService.getById(id);
		if(nome!=null)
			prodotto.setNome(nome);
		if(tipologia!=null)
			prodotto.setTipologia(tipologia);
		if(quantita!=null)
			prodotto.setQuantita(quantita);
		if(descrizione!=null)
			prodotto.setDescrizione(descrizione);

		prodottoService.insert(prodotto);

		model.addAttribute("prodotto", prodotto);
		String stringa="update";
		model.addAttribute("update",stringa);
		return "insertedprodotto";
	}
	
	@RequestMapping(value = "deleteprodotto", method = RequestMethod.GET)
	public String deleteprodotto(HttpServletRequest request, Model model) throws Exception {

		List<Prodotto> prodotti = prodottoService.getAll();
		
		model.addAttribute("prodotti", prodotti);

		return "deleteprodotto";
	}
	
	@RequestMapping(value = "delprodotto", method = RequestMethod.POST)
	public String deletedProdotto(HttpServletRequest request, Model model, @RequestParam(name = "id") Integer id) throws Exception {
		
		prodottoService.delete(id);
		
		String stringa="delete";
		model.addAttribute("delete",stringa);
		return "insertedprodotto";
	}
}
