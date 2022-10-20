package it.beije.magazzino.controller;

import it.beije.magazzino.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import  it.beije.magazzino.service.ProdottoService;

@Controller
public class ControllerJSP {

    @Autowired
    ProdottoService prodottoService;

    public ControllerJSP(){
        System.out.println("DEBUG: ControllerJSP has been instanced");
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allProducts(Model model){
        List<Prodotto> lista = prodottoService.loadAll();
        System.out.println("Lista:" + lista + "\n");
        model.addAttribute("lista", lista);
        return "all_products";
    }
}
