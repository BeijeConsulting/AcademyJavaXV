package it.beije.hopper.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.hopper.ecommerce.model.Item;



@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
//	@Query(nativeQuery = true, value = "SELECT * FROM order_items GROUP BY quantity ORDER BY quantity DESC")
//	public abstract List<Item> loadBestSellingProducts();
//	
	@Query(nativeQuery = true, value = "SELECT id, order_id, product_id name, descrizione, price,SUM(quantity) as quantity, promo "
			+ "FROM order_items GROUP BY product_id;")
	public abstract List<Item> loadBestSellingProducts();
	
	@Query(nativeQuery = true, value = "SELECT * FROM order_items")
	public abstract List<Item> loadAllItem();
	
	@Query(nativeQuery = true, value = "SELECT SUM(quantity) as quantity FROM order_items WHERE product_id = :product_id GROUP BY product_id")
	public abstract Integer returnNumberProducts(@Param("product_id") int product_id);
	
	@Query(nativeQuery = true, value = "SELECT  * FROM order_items GROUP BY product_id ORDER BY quantity DESC")
	public abstract List<Item> loadBestSellingOrderDesc();
	
	@Query(nativeQuery = true, value = "SELECT SUM(quantity) as quantity FROM order_items GROUP BY product_id ORDER BY quantity DESC")
	public abstract List<Integer> loadBestSellingQuantityDesc();
	
}
