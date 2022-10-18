package it.beije.hopper.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.hopper.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	public abstract List<Order> findByUserId(Integer userId);
		
//	@Query(nativeQuery = true, value = "SELECT * FROM users WHERE name = :name")//JDBC
//	public abstract List<User> loadByUser(@Param("name") String firstName);

	public abstract Optional<Order> findById(Integer id);

	public abstract List<Order> findAll();
	public abstract Order save(Order order);
}
