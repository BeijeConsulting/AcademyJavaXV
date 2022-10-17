package it.beije.hopper.controller.rest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.hopper.model.User;
import it.beije.hopper.repository.UserRepository;
import it.beije.hopper.service.UserService;


@RestController
@RequestMapping(value = "api")
public class UserRestController {

	@Autowired
	public UserService userService;
	
	@Autowired
	public UserRepository userRepository;
	
	public UserRestController() {
		System.out.println("creo un oggetto UserRestController");
	}
	
	@GetMapping(value = "/user/{id}")
	public User getUser(@PathVariable(name = "id") Integer id) {
		System.out.println("GET getUser : " + id);
		
		User user = userService.findById(id);
		System.out.println("user : " + user);
		
		return user;
	}
	
	@PostMapping(value = "/user")
	public User insertUser(@RequestBody User user) {
		System.out.println("POST insertUser : " + user);
		
		userService.save(user);
		System.out.println("user post save : " + user);
		
		return user;
	}

	@PutMapping(value = "/user/{id}")
	public User updateUser(@PathVariable(name = "id") Integer id, @RequestBody User newData) {
		System.out.println("POST updateUser id : " + id + " : " + newData);
		
		if (id.compareTo(newData.getId()) == 0) {//OK modifico
			
			User user = userService.findById(id);
			
			user.setEmail(newData.getEmail());
			//...
			
			BeanUtils.copyProperties(newData, user, "id");
			
			userService.save(user);
			System.out.println("user with new data : " + user);

			return user;
		} else
			throw new IllegalArgumentException("id non corrispondenti");
	}
	
	@DeleteMapping(value = "/user/{id}")
	public String deleteUser(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE deleteUser : " + id);
		
		userRepository.deleteById(id);
		
		return "{\"message\":\"rimosso user " + id + "\"}";
	}
}
