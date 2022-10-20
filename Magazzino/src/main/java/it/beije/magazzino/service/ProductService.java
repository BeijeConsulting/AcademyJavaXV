package it.beije.magazzino.service;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        if (productRepository.findById(id).isPresent()) {
            Optional<Product> product = productRepository.findById(id);
            return product.get();
        } else {
            return null;
        }
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByTypology(String typology) {
        return productRepository.findByTypology(typology);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
