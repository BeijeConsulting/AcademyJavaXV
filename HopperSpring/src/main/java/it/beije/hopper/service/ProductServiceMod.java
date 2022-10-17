package it.beije.hopper.service;

import it.beije.hopper.model.Product;
import it.beije.hopper.model.User;
import it.beije.hopper.repository.ProductRepositoryMod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceMod {
    @Autowired
    ProductRepositoryMod productRepositoryMod;

    public Product findByName(String name) {
        return productRepositoryMod.findByName(name);
    }

    public Product findById(Integer id) {
        Optional<Product> p = productRepositoryMod.findById(id);
        return p.get();
    }

    public Product save(Product product){
        return productRepositoryMod.save(product);
    }
    public void deleteProduct(Integer id){
        productRepositoryMod.deleteById(id);
    }
}
