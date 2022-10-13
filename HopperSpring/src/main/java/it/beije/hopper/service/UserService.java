package it.beije.hopper.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.hopper.model.User;
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
	public List<User> findByLastName(String lastName){
		return userRepository.findByLastName(lastName);
	}

//	public void findById(Integer id){
//		System.out.println("User repository find by id: " + userRepository.findById(id));
//		return;
//	}
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
	
	public List<String> loadList() {
		return Arrays.asList("qui", "quo", "qua");
	}

}
