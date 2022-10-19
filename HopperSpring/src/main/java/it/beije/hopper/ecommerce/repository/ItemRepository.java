package it.beije.hopper.ecommerce.repository;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	public abstract List<Item> findByUserId(Integer userId);
		
//	@Query(nativeQuery = true, value = "SELECT * FROM users WHERE name = :name")//JDBC
//	public abstract List<User> loadByUser(@Param("name") String firstName);
}
