package it.beije.magazzino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class RedirectController {
/*    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpSession session,
                       Model model) {

        List<Prodotto> lista = prodottoService.findAll();
        System.out.println("lista : " + lista);
        model.addAttribute("ProdottoLista", lista);

        return "list";
        return "add_prodotto";
    }*/
}
