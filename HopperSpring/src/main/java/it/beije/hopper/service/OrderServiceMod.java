package it.beije.hopper.service;

import it.beije.hopper.model.Order;
import it.beije.hopper.repository.OrderRepositoryMod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceMod {
    @Autowired
    OrderRepositoryMod orderRepositoryMod;

    public Order findOrderById (Integer id){
        if (orderRepositoryMod.findById(id).isPresent()) {
            Optional<Order> order = orderRepositoryMod.findById(id);
            return order.get();
        } else {
            Order order = null;
            return order;
        }
    }

    public Order save (Order order) {
        return orderRepositoryMod.save(order);
    }

    public boolean deleteItem(Integer id) {
        boolean status;
        if (orderRepositoryMod.findById(id).isPresent()) {
            status = true;
            orderRepositoryMod.deleteById(id);
        } else {
            status = false;
        }
        return status;
    }
}

