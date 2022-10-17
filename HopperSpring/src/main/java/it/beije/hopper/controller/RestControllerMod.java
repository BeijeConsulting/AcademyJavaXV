package it.beije.hopper.controller;

import it.beije.hopper.model.Product;
import it.beije.hopper.service.ProductServiceMod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rest")
public class RestControllerMod {

    @Autowired
    ProductServiceMod productServiceMod;

    public RestControllerMod() {
        System.out.println("creo un oggetto RestControllerMod");
    }

    @GetMapping(value = "/product/{id}")
    public Product getProduct(@PathVariable(name = "id") Integer id) {
        return productServiceMod.findById(id);
    }

    @PostMapping(value = "/product")
    public Product insertProduct(@RequestBody Product product) {
        productServiceMod.save(product);
        return product;
    }

    @PutMapping(value = "/product/{id}")
    public Product updateProduct(@PathVariable(name = "id") Integer id, @RequestBody Product newProduct) {
        if (id.intValue() == newProduct.getId()) {
            Product product = productServiceMod.findById(id);
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            productServiceMod.save(product);
            return product;
        } else {
            throw new IllegalArgumentException("id non corrispondenti");
        }
    }

    @DeleteMapping(value = "/product/{id}")
    public boolean deleteProduct(@PathVariable(name = "id") Integer id) {
        if (productServiceMod.findById(id) == null) {
            System.out.println("non esistente");
            return false;
        } else {
            productServiceMod.deleteProduct(id);
            return true;
        }
    }
}
