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


//        public List<Product> findAll(){
//        return productRepository.findAll();
//    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Integer id){
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }


    public void deleteById(Integer id){ productRepository.deleteById(id);}

    public List<Product> findByType(String type){
        return productRepository.findByType(type);
    }

}
