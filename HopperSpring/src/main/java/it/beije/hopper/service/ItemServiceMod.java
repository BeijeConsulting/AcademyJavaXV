package it.beije.hopper.service;

import it.beije.hopper.model.Item;
import it.beije.hopper.repository.ItemRepositoryMod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceMod {

    @Autowired
    ItemRepositoryMod itemRepositoryMod;

    public Item findById(Integer id) {
        Optional<Item> item = itemRepositoryMod.findById(id);
        return item.get();
    }

    public Item save(Item item) {
        return itemRepositoryMod.save(item);
    }

    public boolean deleteItem(Integer id) {
        boolean status;
        if (itemRepositoryMod.findById(id).isPresent()) {
            status = true;
            itemRepositoryMod.deleteById(id);
        } else {
            status = false;
        }
        return status;
    }
}
