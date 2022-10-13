package it.beije.hopper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.hopper.ecommerce.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public abstract Product findById(int id);
	//public abstract List<Product> findAll();
}
