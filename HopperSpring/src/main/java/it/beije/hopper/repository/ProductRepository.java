package it.beije.hopper.repository;

import it.beije.hopper.model.Product;
import it.beije.hopper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public abstract Product findByID(int ID);
}
