package it.beije.hopper.repository;

import it.beije.hopper.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    public abstract Item findById(int ID);
}
