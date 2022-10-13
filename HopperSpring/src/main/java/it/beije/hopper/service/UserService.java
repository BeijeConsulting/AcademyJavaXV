package it.beije.hopper.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.model.User;
import it.beije.hopper.repository.ProductRepository;
import it.beije.hopper.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	

	public UserService() {
		System.out.println("creo un oggetto UserService...");
	}
	
	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public User loadUser(String username) {
//		User user = new User();
//		user.setEmail(username);
//		user.setFirstName("Pippo");
//		user.setLastName("Rossi");

//		Optional<User> u = userRepository.findById(1); 
//		User user = u.isPresent() ? u.get() : new User();
		
		User user = userRepository.findByEmail(username);
		
		System.out.println("loadUser : " + user);
		
		return user;
	}
	
	public List<User> loadLastClients(LocalDate date) {
		return userRepository.loadLastClients(date);
	}
	
	public User registerUser(String email, String password, String name, String surname) throws Exception {
		User user = new User();
		
		user.setFirstName(name);
		user.setLastName(surname);
		user.setEmail(email);
		user.setPassword(password);
		
		try {
			User check = userRepository.findByEmail(user.getEmail());
			
			if(check == null) {
			}else {
				Exception presente = new Exception("Utente già registrato");
				throw presente;
			}
			
		}catch(NullPointerException e) {
			System.out.println("Libero");
			return null;
		}
		
		
		return user;
	}

}
