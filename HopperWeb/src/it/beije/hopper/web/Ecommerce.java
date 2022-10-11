package it.beije.hopper.web;


import java.util.List;

public class Ecommerce {
    public static void main(String... arg){

    }

    public static void inserisciProdotto(){
        System.out.println("Pollo");
    }
    public static void eliminaProdotto(){
        System.out.println("Pollo");
    }
    public static List visualizzaProdotti(){
        List<Product> products = LoginServlet.entityManager.createQuery("from Product p").getResultList();
        return products;
    }
    public static List visualizzaOrdini(){
        List<Order> orders = LoginServlet.entityManager.createQuery("from Order p").getResultList();
        return orders;
    }
}
