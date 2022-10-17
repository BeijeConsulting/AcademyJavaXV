package it.beije.hopper.service;

import it.beije.hopper.model.Product;
import it.beije.hopper.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Integer id){
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}
