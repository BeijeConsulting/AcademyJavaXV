package it.beije.magazzino.controller;

import it.beije.magazzino.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "ajax")
public class AJAXController {

    @GetMapping(value = "/searchProductID/{id}")
    public String getAJAX(Model model, @PathVariable Integer id) {
        model.addAttribute("id", id);
        return "getAJAX";
    }

    @RequestMapping(value = "/addajaxproduct")
    public String postAJAX(Model model) {
        return "postAJAX";
    }
    @GetMapping(value = "/putAJAX/18")
    public String putAJAX(Model model) {
        return "deleteAJAX";
    }

    @GetMapping (value = "/addprodotto")
    public String postAJAXForm() {
        return "formAJAX";
    }

    @PostMapping (value = "/addprodotto")
    public String postAJAXForm(Model model, @RequestParam(name = "name", required = false) String name,
                               @RequestParam(name = "typology", required = false) String typology,
                               @RequestParam(name = "description", required = false) String description,
                               @RequestParam(name = "quantity", required = false) Integer quantity) {
        System.out.println(name);
        System.out.println(typology);
        System.out.println(description);
        System.out.println(quantity);
        Product product = new Product(name, typology, quantity, description);
        model.addAttribute("product", product);
        return "postAJAX";
    }

    @GetMapping(value = "deleteAJAX/{id}")
    public String deleteAJAX(Model model, @PathVariable Integer id) {
        model.addAttribute("id", id);
        return "deleteAJAX";
    }
}
