package it.beije.hopper.controller.rest;

import it.beije.hopper.model.Item;
import it.beije.hopper.model.User;
import it.beije.hopper.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api")
public class ItemRestController {

    @Autowired
    ItemService itemService;

    public ItemRestController(){
        System.out.println("creo un oggetto ItemRestController");
    }

    @GetMapping(value="/items")
    public List<Item> getItems(){
        List<Item> items = itemService.findAll();

        System.out.println("Items: |" + items +"|" );

        return items;
    }



//    @PostMapping(value = "/item")
//    public User insertUser(@RequestBody Item item) {
//        System.out.println("POST insert Item : " + item);
//
////        userService.save(user);
//        itemService.
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
