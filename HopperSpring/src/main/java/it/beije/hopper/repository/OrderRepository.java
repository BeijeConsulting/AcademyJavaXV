package it.beije.hopper.repository;

import it.beije.hopper.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    public abstract Order findById(int ID);
    public abstract List<Order> findByUserId(int ID);
    public List<Order> findAll();

}
