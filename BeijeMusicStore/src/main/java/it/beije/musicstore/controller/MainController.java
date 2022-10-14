package it.beije.musicstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class MainController {

//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private OrderService orderService;

    public MainController() {
        System.out.println("creo un oggetto MainController...");
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        //System.out.println("Hello Page Requested : " + request.getRequestURI());

        return "welcome"; // /WEB-INF/views/beije.jsp
    }
//
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String hello(HttpServletRequest request) {
//        System.out.println("Hello Page Requested : " + request.getRequestURI());
//
//        return "hello";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login() {
//        System.out.println("GET login...");
//
//        return "login";
//    }


}
