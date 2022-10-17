package it.beije.hopper.service;

import java.time.LocalDate;
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
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public User findById(Integer id) {
		Optional<User> u = userRepository.findById(id);
		
		if (!u.isPresent()) throw new IllegalArgumentException("User non trovato con id " + id);

		return u.get();
	}
	
	public User loadUser(String username) {
		
		User user = userRepository.findByEmail(username);
		
		System.out.println("loadUser : " + user);
		
		return user;
	}
	
	public List<User> loadLastClients(LocalDate date) {
		return userRepository.loadLastClients(date);
	}


}


