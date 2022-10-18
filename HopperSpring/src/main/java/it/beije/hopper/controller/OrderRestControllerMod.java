package it.beije.hopper.controller;

import it.beije.hopper.model.Order;
import it.beije.hopper.service.OrderServiceMod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/rest")
public class OrderRestControllerMod {
    @Autowired
    OrderServiceMod orderServiceMod;

    @GetMapping(value = "/order/{id}")
    public Order getOrder(@PathVariable (name = "id") Integer id) {
        return orderServiceMod.findOrderById(id);
    }

    @PostMapping(value = "/order")
    public Order addOrder(@RequestBody Order order) {
//        order.setDatetime(LocalDateTime.now());
        return orderServiceMod.save(order);
    }

    @PutMapping(value = "/order/{id}")
    public Order updateOrder(@PathVariable (name = "id") Integer id, @RequestBody Order newOrder){
        Order order = orderServiceMod.findOrderById(id);
        BeanUtils.copyProperties(newOrder, order, "id", "datetime", "items");
        orderServiceMod.save(order);
        return order;
    }

    @DeleteMapping(value = "/order/{id}")
    public boolean deleteOrder(@PathVariable(name = "id") Integer id) {
    return orderServiceMod.deleteItem(id);
    }
}
