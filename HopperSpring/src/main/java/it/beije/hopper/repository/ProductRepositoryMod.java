package it.beije.hopper.repository;

import it.beije.hopper.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryMod extends JpaRepository<Product, Integer> {

    public abstract Product findByName(String name);

}
