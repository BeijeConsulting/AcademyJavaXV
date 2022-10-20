package it.beije.magazzino.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.magazzino.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	public abstract List<Product> findAll();

	public abstract Product findByNameAndTypology(String name, String typology);

	@Query(nativeQuery = true, value = "SELECT * FROM products WHERE id = :id")//JDBC
	public abstract Product loadById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "SELECT * FROM products")//JDBC
	public abstract List<Product> loadAllProducts();


	@Query(nativeQuery = true, value = "SELECT * FROM products WHERE name = :name")//JDBC
	public abstract List<Product> loadByName(@Param("name") String name);
}
