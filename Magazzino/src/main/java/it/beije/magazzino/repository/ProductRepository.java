package it.beije.magazzino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.beije.magazzino.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	public abstract List<Product> findAll();
	
	@Query(nativeQuery = true, value = "SELECT * FROM products")//JDBC
	public abstract List<Product> loadAllProducts();
}
