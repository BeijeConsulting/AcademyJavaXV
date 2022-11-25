package it.beije.magazzino.controller;

import it.beije.magazzino.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "challenge")
public class AjaxControllerCh {

    @GetMapping(value = "home")
    public String home() {
        return "ajaxHome";
    }

    @PostMapping(value = "/addprodottoCh")
    public String postAJAXForm(Model model, @RequestParam(name = "name", required = false) String name,
                               @RequestParam(name = "typology", required = false) String typology,
                               @RequestParam(name = "description", required = false) String description,
                               @RequestParam(name = "quantity", required = false) Integer quantity) {
        Product product = new Product(name, typology, quantity, description);
        model.addAttribute("product", product);
        return "ajaxHome";
    }

    @PostMapping(value = "searchProductCh")
    public String getAjaxCh(Model model, @RequestParam(name="id", required = false) Integer id) {
        model.addAttribute("id", id);
        return "ajaxHome";
    }
}
