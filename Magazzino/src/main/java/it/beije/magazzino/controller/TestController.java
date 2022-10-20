package it.beije.magazzino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @RequestMapping(value = "index")
    public String index (HttpSession session){
        return "index";
    }
}
