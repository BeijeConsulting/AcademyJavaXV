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
        List<Prodotto> lista = prodottoService.findAll();
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
    public String addProdotto(Model model){
        System.out.println("/add get");

        return "add_prodotto";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProdotto(HttpSession session, @RequestParam(name = "nomeProdotto", required = false) String nomeProdotto
            ,@RequestParam(name = "tipoProdotto", required = false) String tipoProdotto
            ,@RequestParam(name = "quantitaProdotto", required = false) int quantitaProdotto
            ,@RequestParam(name = "descrizioneProdotto", required = false) String descrizioneProdotto
            ,Model model){
        System.out.println( nomeProdotto + tipoProdotto + quantitaProdotto + descrizioneProdotto);

        model.addAttribute("nomeProdotto", nomeProdotto);
        model.addAttribute("tipoProdotto", tipoProdotto);
        model.addAttribute("quantitaProdotto", quantitaProdotto);
        model.addAttribute("descrizioneProdotto", descrizioneProdotto);
        Prodotto newProdotto = new Prodotto(nomeProdotto, tipoProdotto, quantitaProdotto, descrizioneProdotto);

        System.out.println(newProdotto);

        prodottoService.save(newProdotto);

        return "add_prodotto";
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateProdotto(Model model){
        System.out.println("/update get");

        return "update_prodotto";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProdotto(HttpSession session, @RequestParam(name = "idProdotto", required = false) Integer idProdotto
            ,@RequestParam(name = "nomeProdotto", required = false) String nomeProdotto
            ,@RequestParam(name = "tipoProdotto", required = false) String tipoProdotto
            ,@RequestParam(name = "quantitaProdotto", required = false) int quantitaProdotto
            ,@RequestParam(name = "descrizioneProdotto", required = false) String descrizioneProdotto
            ,Model model) {
        Prodotto prodotto = prodottoService.findById(idProdotto);

        Prodotto newProdotto = new  Prodotto(idProdotto,nomeProdotto,tipoProdotto,quantitaProdotto,descrizioneProdotto);

        prodotto = newProdotto;

        prodottoRepository.save(prodotto);

        return "update_prodotto";
        }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteProdotto(Model model){
        System.out.println("/delete get");

        return "delete_prodotto";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteProdotto(HttpSession session, @RequestParam(name = "idProdotto", required = false) Integer idProdotto, Model model){
        System.out.println("Delete id: "+ idProdotto);

        prodottoRepository.deleteById(idProdotto);

        System.out.println("product at id " + idProdotto + "deleted");

        return "delete_prodotto";
    }

    @RequestMapping(value = "/findbytipo", method = RequestMethod.GET)
    public String findProdottoWithTipo(Model model){
        System.out.println("FIND BY TIPO GET");

        return "find_by_tipo";
    }
    @RequestMapping(value = "/findbytipo", method = RequestMethod.POST)
    public String findProdottoWithTipo(HttpSession session, @RequestParam(name = "tipoProdotto", required = false) String tipoProdotto, Model model){
        System.out.println("Cerca prodotti con tipologia: " + tipoProdotto);

        List <Prodotto> lista = prodottoRepository.findProdottoByTipologia(tipoProdotto);

        model.addAttribute("lista", lista);

        return "find_by_tipo";
    }





}
