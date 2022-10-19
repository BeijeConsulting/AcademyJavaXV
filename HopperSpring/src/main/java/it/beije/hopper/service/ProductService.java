package it.beije.hopper.service;

import it.beije.hopper.model.Product;
import it.beije.hopper.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService() {
        System.out.println("creo un oggetto ProductService...");
    }

    public Product loadProduct(int username) {
//		User user = new User();
//		user.setEmail(username);
//		user.setFirstName("Pippo");
//		user.setLastName("Rossi");

//		Optional<User> u = userRepository.findById(1);
//		User user = u.isPresent() ? u.get() : new User();

        Product product = productRepository.findById(username);

        System.out.println("loadProduct : " + product);

        return product;
    }

    public List<Product> findAll(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product saveProduct(Product product){
        Product p = productRepository.save(product);
        return p;
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }
}
