package it.beije.magazzino.controller;

import it.beije.magazzino.ProductCriteria;
import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControllerMagazzino {

    @Autowired
    ProductService productService;

    //- Pagina che restituisce la lista di tutti i prodotti
    @GetMapping(value = "/listAllProducts")
    public String listAllProducts(Model model) {
//        List<Product> productList = ProductCriteria.allProductsCriteria();
        List<Product> productList = ProductCriteria.allProductsCriteria();
        model.addAttribute("productList", productList);
        return "listAllProducts";
    }

    //- Pagina che restituisce il dettaglio del prodotto tramite id
    @GetMapping(value = "/searchProduct")
    public String searchProduct(Model model) {
//        List<Product> productList = ProductCriteria.allProductsCriteria();
        List<Product> productList = ProductCriteria.allProductsCriteria();
        model.addAttribute("list", productList);
        return "searchProductById";
    }

    @PostMapping(value = "/searchProduct")
    public String searchProduct(Model model, @RequestParam(name = "id", required = false) Integer id) {
//        List<Product> productList = ProductCriteria.allProductsCriteria();
        List<Product> productList = ProductCriteria.allProductsCriteria();
        model.addAttribute("list", productList);
        if (ProductCriteria.productByIdCriteria(id) != null) {
            Product productDetail = ProductCriteria.productByIdCriteria(id);
            model.addAttribute("productDetail", productDetail);
        } else {
            model.addAttribute("error", "Id errato");
            return "searchProductById";
        }
        return "searchProductById";
    }

    //- Pagina per la creazione di un nuovo prodotto
    @GetMapping(value = "/addProduct")
    public String addProduct() {
        return "createProduct";
    }

    @PostMapping(value = "/addProduct")
    public String addProduct(Model model, @RequestParam(name = "name", required = false) String name,
                             @RequestParam(name = "typology", required = false) String typology,
                             @RequestParam(name = "description", required = false) String description,
                             @RequestParam(name = "quantity", required = false) Integer quantity) {

        Product product = new Product(name, typology, quantity, description);
        productService.save(product);
        List<Product> productList = ProductCriteria.allProductsCriteria();
        model.addAttribute("productList", productList);
        return "listAllProducts";
    }

    //- Pagina per la modifica di un prodotto esistente
    @GetMapping(value = "updateProduct")
    public String updateProduct(Model model) {
        List<Product> productList = ProductCriteria.allProductsCriteria();
        model.addAttribute("productList", productList);
        return "updateProduct";
    }

    @PostMapping(value = "updateProduct")
    public String updateProduct(Model model, @RequestParam(name = "id", required = false) Integer id) {
        if (ProductCriteria.productByIdCriteria(id) != null) {
            model.addAttribute("product", productService.findById(id));
            List<Product> productList = ProductCriteria.allProductsCriteria();
            model.addAttribute("productList", productList);
            return "updateProductFinal";
        } else {
            List<Product> productList = ProductCriteria.allProductsCriteria();
            model.addAttribute("productList", productList);
            model.addAttribute("error", "Id errato");
            return "updateProduct";
        }
    }

    @PostMapping(value = "updateProductFinal")
    public String updateProductFinal(Model model, @RequestParam(name = "id", required = false) Integer id,
                                     @RequestParam(name = "name", required = false) String name,
                                     @RequestParam(name = "typology", required = false) String typology,
                                     @RequestParam(name = "description", required = false) String description,
                                     @RequestParam(name = "quantity", required = false) Integer quantity) {

        Product product = new Product(name, typology, quantity, description);
        product.setId(id);
        ProductCriteria.updateProductCriteria(product);
        List<Product> productList = ProductCriteria.allProductsCriteria();
        model.addAttribute("productList", productList);
        return "listAllProducts";
    }

    // - Pagina per la cancellazione di un prodotto
    @GetMapping(value = "deleteProduct")
    public String deleteProduct(Model model) {
        List<Product> productList = ProductCriteria.allProductsCriteria();
        model.addAttribute("productList", productList);
        return "deleteProduct";
    }

    @PostMapping(value = "deleteProduct")
    public String deleteProduct(Model model, @RequestParam(name = "id") Integer id) {
        if (productService.findById(id) != null) {
            ProductCriteria.deleteProductCriteria(id);
            List<Product> productList = ProductCriteria.allProductsCriteria();
            model.addAttribute("productList", productList);
            return "listAllProducts";
        } else {
            List<Product> productList = ProductCriteria.allProductsCriteria();
            model.addAttribute("productList", productList);
            model.addAttribute("error", "Id errato");
            return "deleteProduct";
        }
    }

    // - Pagina che restituisce la lista di tutti i prodotti di una specifica tipologia
    @GetMapping(value = "findByTypology")
    public String findByTypology(Model model) {
        model.addAttribute("productList", ProductCriteria.allProductsCriteria());
        return "searchByTypology";
    }

    @PostMapping(value = "findByTypology")
    public String findByTypology(Model model, @RequestParam(name = "typology") String typology) {
        List<Product> listByTypology = ProductCriteria.productByTypologyCriteria(typology);
        model.addAttribute("listByTypology", listByTypology);
        return "searchByTypology";
    }

    //- Pagina che restituisce la lista dei prodotti di una ricerca per nome e/o descrizione
    @GetMapping(value = "findByName")
    public String findByName() {
        return "searchByName";
    }

    @PostMapping(value = "findByName")
    public String findByName(Model model, @RequestParam(name = "name") String name) {
        List<Product> productList = ProductCriteria.productByNameCriteria(name);
        model.addAttribute("listByName", productList);
        return "searchByName";
    }

    @GetMapping(value = "findbynameandtypo")
    public String findByNameAndTypo() {
        return "searchByNameAndTypo";
    }

    @PostMapping(value = "findbynameandtypo")
    public String findByNameAndTypo(Model model, @RequestParam(name = "name") String name, @RequestParam(name = "typology") String typology) {
        List<Product> productList = ProductCriteria.productByTypologyAndNameCriteria(typology, name);
        model.addAttribute("listByName", productList);
        return "searchByNameAndTypo";
    }
}

