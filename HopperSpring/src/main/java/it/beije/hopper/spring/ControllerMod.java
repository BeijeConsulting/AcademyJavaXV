package it.beije.hopper.spring;

import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerMod {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {

        return "home";
    }

    @RequestMapping(value = "/loginMod", method = RequestMethod.GET)
    public String loginMod(HttpServletRequest request) {
        return "loginMod";
    }

    @RequestMapping(value = "/loginMod", method = RequestMethod.POST)
    public String loginMod(HttpSession session,
                           @RequestParam(name = "email", required = false) String email,
                           @RequestParam(name = "password", required = false) String password) {
        System.out.println(email + password) ;
        if (email == null && password == null) {
            return "loginMod";
        } else {
            if (email.equals("antonio") && password.equals("123")) {
                User u = new User();
                u.setEmail(email);
                u.setFirstName("Antonio");
                session.setAttribute("name", u.getFirstName());
                session.setAttribute("email", u.getEmail());
                return "welcome";
            } else {
                session.setAttribute("error", "Email e/o password errata/e!");
                return "loginMod.jsp?error=2";
            }
        }
    }
}
