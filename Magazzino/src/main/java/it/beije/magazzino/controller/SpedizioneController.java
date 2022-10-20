package it.beije.magazzino.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.magazzino.model.ContenutoSpedizione;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.service.ContenutoSpedizioneService;
//import it.beije.magazzino.service.SpedizioneService;
import it.beije.magazzino.service.SpedizioneService;

@Controller
public class SpedizioneController {

	@Autowired SpedizioneService spedizioneService;
	@Autowired ContenutoSpedizioneService contenutoSpedizioneService;
	
	@RequestMapping(value = "getspedizioni", method = RequestMethod.GET)
	public String getspedizione(HttpServletRequest request, Model model) throws Exception {

		List<Spedizione> spedizione = spedizioneService.getAll();
		model.addAttribute("spedizione", spedizione);
		return "spedizione";
	}
	
	@RequestMapping(value="idspedizione",method=RequestMethod.GET)
	public String idSpedizione(HttpServletRequest request, Model model) throws Exception {
		
		
		return "idspedizione";
	}
	
	@RequestMapping(value="spedizionecontenuto",method=RequestMethod.GET)
	public String getspedizioneContenuto(HttpServletRequest request, Model model,@RequestParam(value="id") Integer id) throws Exception {
		
		List<ContenutoSpedizione> contenuto=contenutoSpedizioneService.getBySpedId(id);
		Spedizione spedizione=spedizioneService.getById(id);
		System.out.println(contenuto);
		spedizione.setContenuto(contenuto);
		model.addAttribute("spedizione",spedizione);
		return "spedizionecontenuto";
	}
	
	@RequestMapping(value="idprodotto",method=RequestMethod.GET)
	public String idProdotto(HttpServletRequest request, Model model) throws Exception {
		
		
		return "idprodotto";
	}
	
	@RequestMapping(value="spedizioneprodotto",method=RequestMethod.GET)
	public String getspedizioneProdotto(HttpServletRequest request, Model model,@RequestParam(value="id") Integer id) throws Exception {
	
		List<ContenutoSpedizione> contenuto=contenutoSpedizioneService.getByContId(id);
		System.out.println(contenuto);
		List<Spedizione>spedizione=new ArrayList<>();
		
		spedizione.add(spedizioneService.getById(contenuto.get(0).getId()));
		
		model.addAttribute("spedizione",spedizione);
		return "spedizione";
		
	}
	
	
}
