package it.beije.magazzino.repository;



import it.beije.magazzino.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

        public abstract List<Product> findAll();

        public abstract Optional<Product> findById(Integer id);

        public abstract Product save(Product product);

        public abstract void deleteById(Integer id);


        public abstract List<Product> findByType(String type);
}
