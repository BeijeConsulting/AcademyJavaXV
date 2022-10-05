package it.beije.hopper.ecommerce;

import javax.persistence.Transient;
import java.util.List;

public class Cart {

    private List<Item> product;

    private int quantity;
    public Cart(Item products){
        this.product.add(products);
    }

}
