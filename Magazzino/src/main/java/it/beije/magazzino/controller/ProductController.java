package it.beije.magazzino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

    public ProductController() {
        System.out.println("creo un oggetto ProductController...");
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        System.out.println("Pagina index rechiesta dal client : " + request.getRequestURI());

        return "index"; // /WEB-INF/views/index.jsp
    }
}
