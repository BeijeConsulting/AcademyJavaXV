package it.beije.magazzino.controller;

import it.beije.magazzino.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProdottoService prodottoService;

    public HomeController() {
        System.out.println("creo un oggetto HomeController...");
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        System.out.println("Hello Page Requested : " + request.getRequestURI());



        return "home"; // /WEB-INF/views/home.jsp

    }


}
