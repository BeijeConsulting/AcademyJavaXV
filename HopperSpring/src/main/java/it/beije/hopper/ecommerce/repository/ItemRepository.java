package it.beije.hopper.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Order;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	public abstract List<Item> findAll();
		
//	@Query(nativeQuery = true, value = "SELECT * FROM users WHERE name = :name")//JDBC
//	public abstract List<User> loadByUser(@Param("name") String firstName);
}
