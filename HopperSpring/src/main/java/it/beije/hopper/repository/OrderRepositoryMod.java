package it.beije.hopper.repository;

import it.beije.hopper.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryMod extends JpaRepository<Order, Integer> {
}
