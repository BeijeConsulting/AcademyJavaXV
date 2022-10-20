package it.beije.magazzino.repository;

import it.beije.magazzino.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByTypology(String typology);
    List<Product> findByName(String name);
}
