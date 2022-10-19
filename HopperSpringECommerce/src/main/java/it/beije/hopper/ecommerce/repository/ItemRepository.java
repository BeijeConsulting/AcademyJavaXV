package it.beije.hopper.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.hopper.ecommerce.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	public abstract Optional<Item> findById(Integer id);
	public abstract Item findByName(String name);
	
}
