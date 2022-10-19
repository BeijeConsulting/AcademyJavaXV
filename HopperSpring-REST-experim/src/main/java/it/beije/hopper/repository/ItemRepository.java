package it.beije.hopper.repository;

import it.beije.hopper.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    public abstract List<Item> findAll();




}
