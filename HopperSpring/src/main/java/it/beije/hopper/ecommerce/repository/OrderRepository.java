package it.beije.hopper.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.hopper.ecommerce.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	public abstract List<Order> findByUserId(Integer userId);
		
//	@Query(nativeQuery = true, value = "SELECT * FROM users WHERE name = :name")//JDBC
//	public abstract List<User> loadByUser(@Param("name") String firstName);
}
