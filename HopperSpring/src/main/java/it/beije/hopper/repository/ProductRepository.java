package it.beije.hopper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import it.beije.hopper.ecommerce.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	//public abstract List<Product> findAll();
	@Query(nativeQuery = true, value = "SELECT * FROM products WHERE name LIKE %:product_name%")//JDBC
	public abstract List<Product> loadByName(@Param("product_name") String product_name);
	
	@Query(nativeQuery = true, value = "SELECT * FROM order_items GROUP BY quantity ORDER BY quantity desc")//JDBC
	public abstract List<Product> loadBestSellingProducts();
	
}
