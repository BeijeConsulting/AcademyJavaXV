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
    public Product product(@PathVariable(name="product_id") Integer id){
        System.out.println("GET product: " + id);
        Product product = productService.findById(id);
        return product;
    }
//    @GetMapping(value = "/user/{id}")
//    public User getUser(@PathVariable(name = "id") Integer id) {
//        System.out.println("GET getUser : " + id);
//
//        User user = userService.findById(id);
//        System.out.println("user : " + user);
//
//        return user;
//    }
//
//    @PostMapping(value = "/user")
//    public User insertUser(@RequestBody User user) {
//        System.out.println("POST insertUser : " + user);
//
//        userService.save(user);
//        System.out.println("user post save : " + user);
//
//        return user;
//    }
//
//    @PutMapping(value = "/user/{id}")
//    public User updateUser(@PathVariable(name = "id") Integer id, @RequestBody User newData) {
//        System.out.println("POST updateUser id : " + id + " : " + newData);
//
//        if (id.compareTo(newData.getId()) == 0) {//OK modifico
//
//            User user = userService.findById(id);
//
//            user.setEmail(newData.getEmail());
//            //...
//
//            BeanUtils.copyProperties(newData, user, "id");
//
//            userService.save(user);
//            System.out.println("user with new data : " + user);
//
//            return user;
//        } else
//            throw new IllegalArgumentException("id non corrispondenti");
//    }
//
//    @DeleteMapping(value = "/user/{id}")
//    public String deleteUser(@PathVariable(name = "id") Integer id) {
//        System.out.println("DELETE deleteUser : " + id);
//
////		userRepository.deleteById(id);
//        userService.deleteById(id);
//
//        return "{\"message\":\"rimosso user " + id + "\"}";
//    }

}
