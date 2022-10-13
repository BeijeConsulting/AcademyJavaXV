package it.beije.hopper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.hopper.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public abstract User findByEmail(String email);

	public abstract User findByEmailAndPassword(String email, String password);

	public abstract List<User> findByLastName(String lastName);
}
