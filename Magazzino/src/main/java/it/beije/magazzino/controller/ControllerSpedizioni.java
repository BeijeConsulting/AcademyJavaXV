package it.beije.magazzino.controller;

import it.beije.magazzino.ProductCriteria;
import it.beije.magazzino.model.ContenutoSpedizione;
import it.beije.magazzino.model.Product;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.service.ContenutoSpedizioneService;
import it.beije.magazzino.service.ProductService;
import it.beije.magazzino.service.SpedizioneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControllerSpedizioni {

    @Autowired
    SpedizioneService spedizioneService;

    @Autowired
    ContenutoSpedizioneService contenutoSpedizioneService;

    @Autowired
    ProductService productService;

    // - Pagina che restituisce la lista di tutte le spedizioni
    @GetMapping(value = "findAllSpedizioni")
    public String findAllSpedizioni(Model model) {
        model.addAttribute("spedizioniList", SpedizioniCriteria.allSpedizioniCriteria());
        return "listAllSpedizioni";
    }

    //- Pagina che restituisce il dettaglio della spedizione e del relativo contenuto
    @GetMapping(value = "findSpedizioneById")
    public String findSpedizioneById(Model model) {
        model.addAttribute("spedizioniList", SpedizioniCriteria.allSpedizioniCriteria());
        return "findSpedizioneById";
    }

    @PostMapping(value = "findSpedizioneById")
    public String findSpedizioneById(Model model, @RequestParam(name = "id") Integer id) {
        if (spedizioneService.findSpedizioneById(id) != null) {
            model.addAttribute("spedizioneTrovata", spedizioneService.findSpedizioneById(id));
            model.addAttribute("spedizioniList", SpedizioniCriteria.allSpedizioniCriteria());
            return "findSpedizioneById";
        } else {
            model.addAttribute("error", "Id errato");
            model.addAttribute("spedizioniList", SpedizioniCriteria.allSpedizioniCriteria());
            return "findSpedizioneById";
        }
    }

    //- Pagina per la creazione di una nuova spedizione tramite selezione del relativo contenuto
    @GetMapping(value = "addSpedizione")
    public String addSpedizione(Model model) {
        return "addSpedizione";
    }

    @PostMapping(value = "addSpedizione")
    public String addSpedizione(Model model, @RequestParam(name = "name") String nome, @RequestParam(name = "indirizzo") String indirizzo) {
        Spedizione spedizione = new Spedizione();
        spedizione.setDestinatario(nome);
        spedizione.setIndirizzo(indirizzo);
        spedizioneService.addSpedizione(spedizione);
        BeanUtils.copyProperties(spedizione, spedizione);
        spedizione.setCodice();
        spedizioneService.addSpedizione(spedizione);
        model.addAttribute("spedizione", spedizione.getId());
        return "addSpedizioneCont";
    }

    @PostMapping(value = "addSpedizioneCont")
    public String addSpedizione(Model model, @RequestParam(name = "idProdotto") Integer idProdotto, @RequestParam(name = "quantita") Integer quantita, @RequestParam(name = "id") Integer id) {
        ContenutoSpedizione contenuto = new ContenutoSpedizione();
        contenuto.setSpedizioneId(id);
        contenuto.setQuantita(quantita);
        contenuto.setProdottoId(idProdotto);
        model.addAttribute("spedizione", contenuto.getSpedizioneId());
        contenutoSpedizioneService.addContenuto(contenuto);
        List<Product> productList = ProductCriteria.allProductsCriteria();
        model.addAttribute("productList", productList);
        return "addSpedizioneCont";
    }

    @GetMapping(value = "findSpedizioneByProduct")
    public String findSpedizioneByProduct(Model model) {
        List<Product> listaProdotti = ProductCriteria.allProductsCriteria();
        model.addAttribute("list", listaProdotti);
        return "findSpedizioneByProduct";
    }

    @PostMapping(value = "findSpedizioneByProduct")
    public String findSpedizioneByProduct(Model model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("spedizioneTrovata", SpedizioniCriteria.productByIdCriteria(id));
        return "findSpedizioneByProduct";
    }
}
