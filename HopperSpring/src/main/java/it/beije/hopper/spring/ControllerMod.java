package it.beije.hopper.spring;

import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class ControllerMod {

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
            if (email.equals("antonio@gmail.com") && password.equals("123")) {
                User u = new User();
                u.setEmail(email);
                u.setFirstName("Antonio");
                model.addAttribute("name", u.getFirstName());
                model.addAttribute("email", u.getEmail());
                ArrayList<String> list = new ArrayList<String>( Arrays.asList("prova", "ciao", "tino") );
                model.addAttribute("list", list);
                return "welcomeMod";
            } else {
                model.addAttribute("error", "Email e/o password errata/e!");
                return "loginMod.jsp?error=2";
            }
        }
    }
}
