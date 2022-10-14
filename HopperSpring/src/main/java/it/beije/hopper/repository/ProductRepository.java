package it.beije.hopper.repository;

import it.beije.hopper.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public abstract Product findById(int id);
    public abstract List<Product> findAll();

}