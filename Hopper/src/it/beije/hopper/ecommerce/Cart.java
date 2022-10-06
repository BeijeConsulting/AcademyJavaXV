package it.beije.hopper.ecommerce;
import java.util.ArrayList;
import java.util.List;
public class Cart {
    private static List<Item> cart=new ArrayList<>();
    public static List<Item> addInCart(Item product) {
        if(product.getQuantity()>0) {
            cart.add(product);
        }
        return cart;
    }
}
