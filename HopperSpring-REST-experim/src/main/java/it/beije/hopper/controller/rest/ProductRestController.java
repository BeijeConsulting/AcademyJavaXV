package it.beije.hopper.controller.rest;

import it.beije.hopper.model.Product;
import it.beije.hopper.model.User;
import it.beije.hopper.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api")
public class ProductRestController {

    @Autowired
    ProductService productService;


    public ProductRestController(){
        System.out.println("creo un oggetto ProductRestController");
    }


    @GetMapping(value="/products")
    public List<Product> products(){
        List<Product> products = productService.findAll();
        return products;
    }

    @GetMapping(value="/product/{product_id}")
    public Product getProduct(@PathVariable(name="product_id") Integer id){
        System.out.println("GET product: " + id);
        Product product = productService.findById(id);
        return product;
    }


    @PostMapping(value="/product")
    public Product insertProduct(@RequestBody Product product){
        System.out.println("Insert Product: " + product);

        productService.save(product);

        System.out.println("Product post after save: " + product);

        return product;
    }

    @PutMapping(value="/product/{id}")
    public Product updateProduct( @PathVariable(name="id") Integer id,
                                  @RequestBody Product newData){
        System.out.println("POST update product id: " + id + " : " + newData);
        if( id.compareTo(newData.getId()) == 0){
            Product product = productService.findById(id);
            BeanUtils.copyProperties(newData, product, "id");
            productService.save(product);
            System.out.println("POST update product with new data: " + product);
        }else{
            throw new IllegalArgumentException("Product not present");
        }
        return newData;
    }

    @DeleteMapping(value="/product/{id}")
    public String deleteProduct(@PathVariable(name="id") Integer id){
        System.out.println("Delete delete user: " + id);
        productService.deleteById(id);
        return "{\"message\":\"rimosso prodotto " + id + "\"}"; // NON DA FARE!
    }

}
