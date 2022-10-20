package it.beije.magazzino.controller;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class RestControllerMagazzino {
    @Autowired
    ProductService productService;

    //- Servizio REST che restituisce la lista di tutti i prodotti
    @GetMapping(value = "/listAllProducts")
    public List<Product> listAllProducts() {
        return productService.findAll();
    }

    //- Servizio REST che restituisce il dettaglio del prodotto tramite id
    @GetMapping(value = "/searchProduct/{id}")
    public Product searchProduct(@PathVariable(name = "id") Integer id) {
        if (productService.findById(id) != null) {
            return productService.findById(id);
        } else {
            return null;
        }
    }

    //- Servizio REST per la creazione di un nuovo prodotto
    @PostMapping(value = "/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    //- Servizio REST per la modifica di un prodotto esistente
    @PutMapping(value = "/updateProduct/{id}")
    public Product updateProduct(@PathVariable(name = "id") Integer id, @RequestBody Product newProduct) {
        if (productService.findById(id) != null) {
            Product product = productService.findById(id);
            BeanUtils.copyProperties(newProduct, product, "id");
            return productService.save(product);
        } else {
            return null;
        }
    }

    //- Servizio REST per la cancellazione di un prodotto
    @DeleteMapping(value = "/deleteProduct/{id}")
    public boolean deleteProduct(@PathVariable(name = "id") Integer id) {
        if (productService.findById(id) != null) {
            productService.deleteProduct(id);
            return true;
        } else {
            return false;
        }
    }

    // - Servizio REST che restituisce la lista di tutti i prodotti di una specifica tipologia
    @GetMapping(value = "/findByTypology/{typology}")
    public List<Product> findByTypology(@PathVariable(name = "typology") String typology) {
        if (productService.findByTypology(typology) != null) {
            return productService.findByTypology(typology);
        } else {
            return null;
        }
    }

    //- Servizio REST che restituisce la lista dei prodotti di una ricerca per nome e/o descrizione
    @GetMapping(value = "/findByName/{name}")
    public List<Product> findByName(@PathVariable(name = "name") String name) {
        if (productService.findByName(name) != null) {
            return productService.findByName(name);
        } else {
            return null;
        }
    }
}
