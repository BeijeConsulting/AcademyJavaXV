package it.beije.magazzino;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductServiceCriteriaApi;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MainTester {

    public static void main(String[] args){

        ProductServiceCriteriaApi psca = new ProductServiceCriteriaApi();
        List<Product> result = psca.findAll();
        result.forEach(System.out::println);
    }
}
