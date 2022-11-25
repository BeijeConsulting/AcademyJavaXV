package it.beije.magazzino.controller;

import it.beije.magazzino.model.ContenutoSpedizione;
import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.service.ContenutoSpedizioneService;
import it.beije.magazzino.service.SpedizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.*;

/*@Controller
public class SpedizioneController {

    @Autowired
    SpedizioneService spedizioneService;

    @Autowired
    ContenutoSpedizioneService contenutoSpedizioneService;

    @RequestMapping(value = "/spedizioni", method = RequestMethod.GET)
    public String spedizioni(HttpSession session,
                             Model model) {

        List<Spedizione> lista = spedizioneService.findAll();
        System.out.println("lista : " + lista);
        model.addAttribute("ListaSpedizioni", lista);

        return "list_spedizioni";
    }

    @RequestMapping(value = "/spedizione_by_id", method = RequestMethod.GET)
    public String spedizioneById(HttpSession session,
                                 @RequestParam(name = "id", required = true) Integer id, Model model) {
        System.out.println("test : " + id);

        Optional<Spedizione> spedizione = spedizioneService.findById(id);

        List<Spedizione> lista = new ArrayList<>();
        spedizione.ifPresent(lista::add);
        System.out.println("lista : " + lista);
        model.addAttribute("ListaSpedizioni", lista);

        Optional<ContenutoSpedizione> contenuto = contenutoSpedizioneService.findBySpedizione_Id(id);
        model.addAttribute("contenutoSpedizione", contenuto.get());

        return "list_spedizioni";
    }

    @RequestMapping(path = "/add_spedizione", method = RequestMethod.POST)
    public String saveSpedizione(@RequestParam(name = "id", required = false) Integer id,
                                 @RequestParam(name = "codice", required = false) Integer codice,
                                 @RequestParam(name = "destinatario", required = false) String destinatario,
                                 @RequestParam(name = "data_spedizione", required = false) LocalDate data_spedizione,
                                 @RequestParam(name = "data_ricezione", required = false) LocalDate data_recezione,
                                 @RequestParam(name = "contenuto", required = false) HashMap<Integer, Integer> contenuto,

                                 Model model) {

        Spedizione spedizione = new Spedizione();
        spedizione.setCodice(codice);
        spedizione.setDestinatario(destinatario);
        spedizione.setDataSpedizione(data_spedizione);
        spedizione.setDataRicezione(data_recezione);
        List<ContenutoSpedizione> contenutoSpedizioneList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : contenuto.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            ContenutoSpedizione contenutoSpedizione = new ContenutoSpedizione();
            contenutoSpedizione.setProdotto_id(entry.getKey());
            contenutoSpedizione.setQuantita(entry.getValue());
            contenutoSpedizioneList.add(contenutoSpedizione);
        }
        spedizione.setContenutoSpedizioneList(contenutoSpedizioneList);
        spedizioneService.save(spedizione);

        model.addAttribute("success", "Created successfully.");
        model.addAttribute("spedizione", spedizione);

        return "add_spedizione";
    }
}*/
