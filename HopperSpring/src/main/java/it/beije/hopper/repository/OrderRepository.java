package it.beije.hopper.repository;

import it.beije.hopper.model.Order;
import it.beije.hopper.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    public abstract Order findByID(int ID);
}
