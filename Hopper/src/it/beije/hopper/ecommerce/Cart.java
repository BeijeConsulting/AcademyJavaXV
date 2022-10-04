package it.beije.hopper.ecommerce;

import javax.persistence.Transient;
import java.util.List;

public class Cart {
    @Transient
    private List<Item> product;

    private int quantity;


    public Cart(List<Item> products){
        this.product=products;
    }

}
