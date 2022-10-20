package it.beije.magazzino.controller;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import  it.beije.magazzino.service.ProdottoService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ControllerJSP {

    @Autowired
    ProdottoService prodottoService;
    @Autowired
    ProdottoRepository prodottoRepository;

    public ControllerJSP(){
        System.out.println("DEBUG: ControllerJSP has been instanced");
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allProducts(Model model){
        System.out.println("/all get");
        List<Prodotto> lista = prodottoService.loadAll();
        System.out.println("Lista:" + lista + "\n");
        model.addAttribute("lista", lista);
        return "all_products";
    }

    @RequestMapping(value ="/detail", method = RequestMethod.GET)
    public String showDetail(Model model){
        System.out.println("/detail get");
        return "detail";
    }
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String showDetail(HttpSession session, @RequestParam(name = "id", required = false) int id, Model model){
        System.out.println("/detail POST");

        System.out.println("ID: " + id);
        model.addAttribute("id", id);

        Optional<Prodotto> prodotto = prodottoRepository.findById(id);
        System.out.println(prodotto);

        model.addAttribute("prodottoNome",prodotto.get().getNome());
        model.addAttribute("prodottoId",prodotto.get().getId());
        model.addAttribute("prodottoTipo",prodotto.get().getTipologia());
        model.addAttribute("prodottoQuantita",prodotto.get().getQuantita());
        model.addAttribute("prodottoDesc",prodotto.get().getDescrizione());
        return "detail";}

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model){
        System.out.println("/add get");

        return "add_item";
    }

}
