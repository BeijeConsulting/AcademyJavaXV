package it.beije.hopper.service;

import it.beije.hopper.model.Item;
import it.beije.hopper.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository productRepository;

    public ItemService() {
        System.out.println("creo un oggetto OrderService...");
    }

    public Item loadItem(int ID) {
//		User user = new User();
//		user.setEmail(username);
//		user.setFirstName("Pippo");
//		user.setLastName("Rossi");

//		Optional<User> u = userRepository.findById(1);
//		User user = u.isPresent() ? u.get() : new User();

        Item item = productRepository.findByID(ID);

        System.out.println("loadProduct : " + item);

        return item;
    }
}
