package it.beije.magazzino;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductServiceCriteria;

import java.util.List;

public class MainTester {

    public static void main(String[] args){

        ProductServiceCriteria psca = new ProductServiceCriteria();
//        List<Product> result = psca.findAll();

//        List<Product> result = psca.findWhereQuantityGreaterThan(1000);

        List<Product> result = psca.findByNameOrDescription("Pencil","Toys for kids");
        result.forEach(System.out::println);
    }
}
