package it.beije.magazzino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Welcome {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String availableActions(HttpServletRequest request, Model model){

        System.out.println("Access to the actions list");
        return "actions";
    }

    @RequestMapping(value = "back", method = RequestMethod.GET)
    public String backToWelcome(HttpServletRequest request, Model model){

        System.out.println("Back to welcome page");
        return "actions";
    }
}
