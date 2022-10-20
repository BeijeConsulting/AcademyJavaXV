//package it.beije.magazzino.controller;
//
//import it.beije.hopper.model.User;
//import it.beije.hopper.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDate;
//import java.util.List;
//
//
//@RestController
//public class MyRestController {
//
//	public MyRestController() {
//		System.out.println("creo un oggetto MyRestController...");
//	}
//
//	@Autowired
//	private UserService userService;
//
//	@GetMapping(value = "/test_rest2")
//	public List<User> testRest() {
//		System.out.println("GET test_rest2...");
//
//		List<User> lista = userService.loadLastClients(LocalDate.now().minusMonths(1));
//		System.out.println("lista : " + lista);
//
//		return lista;
//	}
//
//}
