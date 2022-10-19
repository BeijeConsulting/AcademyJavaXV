package it.beije.hopper.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.hopper.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	public abstract Optional<Product> findById(Integer id);
}
