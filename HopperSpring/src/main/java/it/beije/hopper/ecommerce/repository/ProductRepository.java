package it.beije.hopper.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Product;
import it.beije.hopper.model.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product save(Product product);
	public abstract List<Product> findAll();

}
