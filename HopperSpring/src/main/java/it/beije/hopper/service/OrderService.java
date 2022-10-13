package it.beije.hopper.service;

import it.beije.hopper.model.Order;
import it.beije.hopper.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderService() {
        System.out.println("creo un oggetto OrderService...");
    }

    public Order loadOrder(int ID) {
//		User user = new User();
//		user.setEmail(username);
//		user.setFirstName("Pippo");
//		user.setLastName("Rossi");

//		Optional<User> u = userRepository.findById(1);
//		User user = u.isPresent() ? u.get() : new User();

        Order order = orderRepository.findById(ID);

        System.out.println("loadProduct : " + order);

        return order;
    }
}
