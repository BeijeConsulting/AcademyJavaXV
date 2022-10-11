package it.beije.hopper.spring;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());

		return "beije"; // /WEB-INF/views/beije.jsp
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(HttpServletRequest request) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());

		return "hello";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		System.out.println("test : " + locale);

		return "testosterone";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("GET login...");

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session,
			@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password,
			Model model) {
		
		System.out.println("POST login...");
		
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		
		if (username != null && username.length() > 0 && password != null && password.length() > 0) {
			//verifico credenziali su DB...
			if (username.equalsIgnoreCase("pippo@beije.it") && password.equalsIgnoreCase("1234")) { //OK
//				model.addAttribute("fname", "Pippo");
//				model.addAttribute("lname", "Rossi");
				
				User user = new User();
				user.setEmail(username);
				user.setFirstName("Pippo");
				user.setLastName("Rossi");
				System.out.println(user);
				
				model.addAttribute("loggedUser", user);
				
				return "welcome";
			} else { //KO
				model.addAttribute("errore", "CREDENZIALI ERRATE");
			}
		} else {
			model.addAttribute("errore", "INSERIRE ENTRAMBE LE CREDENZIALI");
		}

		return "login";
	}
}
