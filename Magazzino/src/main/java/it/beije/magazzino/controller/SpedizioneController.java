package it.beije.magazzino.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	//Inserimento
	@RequestMapping(value = "insertspedizione", method = RequestMethod.GET)
	public String insertspedizione(HttpServletRequest request, Model model) throws Exception {
		return "insertspedizione";
	}

	@RequestMapping(value = "inspedizione", method = RequestMethod.POST)
	public String insertedProdotto(HttpServletRequest request, Model model, @RequestParam(name = "codice") String codice,
			@RequestParam(name = "destinatario") String destinatario, @RequestParam(name = "indirizzo") String indirizzo,
			@RequestParam(name = "dataSpedizione") String dataSpedizione,@RequestParam(name = "dataRicezione") String dataRicezione) {

		
		LocalDate date = LocalDate.parse(dataSpedizione);
		LocalDateTime dataDiSpedizione = date.atStartOfDay();
		
		LocalDate date2 = LocalDate.parse(dataRicezione);
		LocalDateTime dataDiRicezione = date2.atStartOfDay();
		
		Spedizione spedizione = new Spedizione();
		spedizione.setCodice(codice);
		spedizione.setDestinatario(destinatario);
		spedizione.setIndirizzo(indirizzo);
		spedizione.setDataSpedizione(dataDiSpedizione);
		spedizione.setDataRicezione(dataDiRicezione);
		
		
		spedizioneService.insert(spedizione);
		model.addAttribute("spedizione", spedizione);
		return "insertedprodotto";
	}
	
	
}
