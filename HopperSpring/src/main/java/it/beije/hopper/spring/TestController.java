package it.beije.hopper.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class TestController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(HttpServletRequest request) {
	
		
		return "login";
	}
	
	@RequestMapping(value="welcome",method=RequestMethod.GET)
	public String welcome(HttpServletRequest request) {
		
		return "welcome";
	}
	
}
