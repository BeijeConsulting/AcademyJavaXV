package it.beije.hopper.controller;

import it.beije.hopper.model.Order;
import it.beije.hopper.model.User;
import it.beije.hopper.service.OrderService;
import it.beije.hopper.service.UserServiceMod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControllerMod {
@Autowired
private UserServiceMod userServiceMod;
@Autowired
private OrderService orderService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {

        return "home";
    }

    @RequestMapping(value = "/loginMod", method = RequestMethod.GET)
    public String loginMod() {
        System.out.println("GET");
        return "loginMod";
    }

    @RequestMapping(value = "/loginMod", method = RequestMethod.POST)
    public String loginMod(HttpSession session,
                           @RequestParam(name = "email", required = false) String email,
                           @RequestParam(name = "password", required = false) String password, Model model) {
        System.out.println("POST");
        System.out.println(email + password) ;
        if (email.length() <=0 || password.length() <=0) {
            System.out.println(email + password) ;
            model.addAttribute("error", "Inserisci tutti i campi!");
            return "loginMod.jsp?error=1";
        } else {
        if (userServiceMod.findByEmailAndPassword(email, password) != null) {
                User u = userServiceMod.findByEmailAndPassword(email, password);
                model.addAttribute("user", u);
                return "welcomeMod";
            } else {
                model.addAttribute("error", "Email e/o password errata/e!");
                return "loginMod.jsp?error=2";
            }
        }
    }
    @RequestMapping(value = "/orderHistory", method = RequestMethod.POST)
    public String OrderHistory(HttpSession session, Model model, @RequestParam(name = "userId", required = true) Integer id) {
        System.out.println(orderService.findByUserId(id));
        List<Order> orderList = orderService.findByUserId(id);
        model.addAttribute("orderHistory", orderList);
        return "orderHistory";
    }
    @RequestMapping(value = "/testMod", method = RequestMethod.GET)
    public String testMod(HttpSession session, Model model) {
    model.addAttribute("list", userServiceMod.findAll());
        System.out.println(userServiceMod.findAll());
    return "testMod";
    }
//a
}
