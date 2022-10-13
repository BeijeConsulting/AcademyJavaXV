package it.beije.hopper.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	

	public ProductService() {
		System.out.println("creo un oggetto UserService...");
	}
	

	
	public List<Product> loadProducts() {
		return productRepository.findAll();
	}
	
//	public User registerUser(String email, String password, String name, String surname) throws Exception {
//		User user = new User();
//		
//		user.setFirstName(name);
//		user.setLastName(surname);
//		user.setEmail(email);
//		user.setPassword(password);
//		
//		try {
//			User check = userRepository.findByEmail(user.getEmail());
//			
//			if(check == null) {
//			}else {
//				Exception presente = new Exception("Utente già registrato");
//				throw presente;
//			}
//			
//		}catch(NullPointerException e) {
//			System.out.println("Libero");
//			return null;
//		}
//		
//		
//		return user;
//	}

}