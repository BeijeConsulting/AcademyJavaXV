package it.beije.magazzino.controller;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.service.ProdottoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoService;

    public ProdottoController() {
        System.out.println("creo un oggetto ProdottoController...");
    }


    @RequestMapping(value = "/prodotto_by_id", method = RequestMethod.GET)
    public String prodottoById(HttpSession session,
                               @RequestParam(name = "id", required = true) Integer id, Model model) {
        System.out.println("test : " + id);

        Optional<Prodotto> art = prodottoService.findById(id);

        List<Prodotto> lista = new ArrayList<>();
        art.ifPresent(lista::add);
        System.out.println("lista : " + lista);
        model.addAttribute("ProdottoLista", lista);

        return "list";
    }

    @RequestMapping(value = "/prodotti", method = RequestMethod.GET)
    public String prodotti(HttpSession session,
                           Model model) {

        List<Prodotto> lista = prodottoService.findAll();
        System.out.println("lista : " + lista);
        model.addAttribute("ProdottoLista", lista);

        return "list";
    }

    @RequestMapping(value = "/update_prodotto", method = RequestMethod.GET)
    public String prodottoUpdate(HttpSession session,
                               @RequestParam(name = "id", required = true) Integer id, Model model) {
        System.out.println("test : " + id);

        Optional<Prodotto> prodotto = prodottoService.findById(id);
        if (prodotto.isPresent()){
            model.addAttribute("prodotto", prodotto.get());

            return "update";
        } else {
            model.addAttribute("message", "Errore");
            return "list";
        }

    }

    @RequestMapping(path = "/add_prodotto", method = RequestMethod.GET)
    public String pageCreateProdotto(
                               Model model) {
        return "add_prodotto";
    }

    @RequestMapping(path = "/add_prodotto", method = RequestMethod.POST)
    public String saveProdotto(@RequestParam(name = "id", required = false) Integer id,
                               @RequestParam(name = "nome", required = false) String nome,
                               @RequestParam(name = "tipologia", required = false) String tipologia,
                               @RequestParam(name = "quantita", required = false) Integer quantita,
                               @RequestParam(name = "descrizione", required = false) String descrizione,
                               Model model) {

        Prodotto prodotto = new Prodotto();
        prodotto.setNome(nome);
        prodotto.setDescrizione(descrizione);
        prodotto.setQuantita(quantita);
        prodotto.setTipologia(tipologia);
        prodottoService.save(prodotto);
        model.addAttribute("success", "Created successfully.");
        model.addAttribute("prodotto", prodotto);

        return "add_prodotto";
    }

    @RequestMapping(path = "/update_prodotto", method = RequestMethod.POST)
    public String updateProdotto(
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "tipologia", required = false) String tipologia,
            @RequestParam(name = "quantita", required = false) Integer quantita,
            @RequestParam(name = "descrizione", required = false) String descrizione,
                                 ModelMap model) {

        if (!(id == null && 0 == id)) {//OK modifico

            Optional<Prodotto> prodottoServiceById = prodottoService.findById(id);

            Prodotto prodotto1;
            if (prodottoServiceById.isPresent())
                prodotto1 = prodottoServiceById.get();
            else throw new IllegalArgumentException("id non valido");

            prodotto1.setNome(nome);
            prodotto1.setDescrizione(descrizione);
            prodotto1.setQuantita(quantita);
            prodotto1.setTipologia(tipologia);

            prodottoService.save(prodotto1);
            System.out.println("prodotto with new data : " + prodotto1);

            model.addAttribute("prodotto", prodotto1);
            model.addAttribute("success", "Prodotto aggiornato");
            return "update";
        } else
            throw new IllegalArgumentException("id non corrispondenti");
    }

    @RequestMapping(value = "/delete_prodotto", method = RequestMethod.GET)
    public String deleteProdotto(HttpSession session,
                                 @RequestParam(name = "id", required = true) Integer id, Model model) {
        System.out.println("test : " + id);

        Optional<Prodotto> c = prodottoService.findById(id);
        prodottoService.delete(c.get());
        model.addAttribute("message", "Prodotto cancellato");

        List<Prodotto> lista = prodottoService.findAll();
        System.out.println("lista : " + lista);
        model.addAttribute("ProdottoLista", lista);

        return "list";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpSession session,
                       Model model) {

        List<Prodotto> lista = prodottoService.findAll();
        System.out.println("lista : " + lista);
        model.addAttribute("ProdottoLista", lista);

        return "list";
    }

    @RequestMapping(value = "/prodotti_by_tipologia", method = RequestMethod.GET)
    public String prodottoByTipologia(HttpSession session,
                                  @RequestParam(name = "tipologia", required = true) String tipologia, Model model) {
        System.out.println("test : " + tipologia);

        List<Prodotto> lista = prodottoService.findByTipologia(tipologia);
        System.out.println("lista : " + lista);
        model.addAttribute("ProdottoLista", lista);

        return "list";
    }

    @RequestMapping(value = "/prodotti_by_nome_or_descrizione", method = RequestMethod.GET)
    public String prodottoByNomeOrDescrizione(HttpSession session,
                                  @RequestParam(name = "nome", required = true) String nome,
                                  @RequestParam(name = "descrizione", required = true) String descrizione,
                                  Model model) {
        System.out.println("test : " + nome);

        List<Prodotto> lista = prodottoService.findByNomeOrDescrizione(nome, descrizione);
        System.out.println("lista : " + lista);
        model.addAttribute("ProdottoLista", lista);

        return "list";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String find(HttpSession session,
                       Model model) {

        List<Prodotto> lista = prodottoService.findAll();
        System.out.println("lista : " + lista);
        model.addAttribute("ProdottoLista", lista);

        return "find";
    }

}
