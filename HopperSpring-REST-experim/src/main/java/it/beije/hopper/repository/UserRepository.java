package it.beije.hopper.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.hopper.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public abstract User findByEmail(String email);

	public abstract User findByEmailAndPassword(String email, String password);

	public abstract List<User> findByLastName(String lastName);
	
	//@Query(value = "SELECT u FROM User u WHERE firstName = :name")//JPA
	@Query(nativeQuery = true, value = "SELECT * FROM users WHERE name = :name")//JDBC
	public abstract List<User> loadByName(@Param("name") String firstName);
	
	//@Query(nativeQuery = true, value = "SELECT * FROM users u JOIN orders o ON o.user_id = u.id WHERE o.datetime > :date GROUP BY u.id")
	@Query(nativeQuery = true, value = "SELECT * FROM orders o JOIN users u ON o.user_id = u.id WHERE o.datetime > :date GROUP BY u.id")
	public abstract List<User> loadLastClients(@Param("date") LocalDate date);


	public abstract void deleteById(Integer id);
	
	
}
