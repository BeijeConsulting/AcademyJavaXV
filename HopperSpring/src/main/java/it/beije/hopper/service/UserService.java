package it.beije.hopper.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.hopper.model.User;


@Service
public class UserService {

	public UserService() {
		System.out.println("creo un oggetto UserService...");
	}

	public User loadUser(String username) {
		User user = new User();
		user.setEmail(username);
		user.setFirstName("Pippo");
		user.setLastName("Rossi");
		System.out.println(user);
		
		return user;
	}
	
	public List<String> loadList() {
		return Arrays.asList("qui", "quo", "qua");
	}

}
