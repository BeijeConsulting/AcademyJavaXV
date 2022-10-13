package it.beije.hopper.repository;

import it.beije.hopper.model.Item;
import it.beije.hopper.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    public abstract Item findByID(int ID);
}
