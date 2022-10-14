package it.beije.musicstore.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MusicController {
    public MusicController() {
        System.out.println("creo un oggetto MusicController...");
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello(HttpServletRequest request) {
        System.out.println("Hello Page Requested : " + request.getRequestURI());
        return "index";
    }
}
