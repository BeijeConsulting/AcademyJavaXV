package it.beije.hopper.repository;

import it.beije.hopper.model.Product;
import it.beije.hopper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public abstract Product findByEmail(String email);

	public abstract Product findByEmailAndPassword(String email, String password);

	public abstract List<Product> findByLastName(String lastName);
}
