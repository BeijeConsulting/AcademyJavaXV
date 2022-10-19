//package it.beije.hopper.ecommerce.rest.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import it.beije.hopper.ecommerce.model.Cart;
//import it.beije.hopper.service.CartService;
//
//
//@RestController
//@RequestMapping(value = "api")
//public class CartRestController {
//	
//	@Autowired
//	CartService cartService;
//
//	@GetMapping(value = "/best_selling_products")
//	public void addProductToCart(@RequestBody Cart cart) {
//		cartService.addProductToCart(cart);
//	}
//	
//}
