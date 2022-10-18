package it.beije.hopper.repository;

import it.beije.hopper.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositoryMod extends JpaRepository<Item, Integer> {
}
