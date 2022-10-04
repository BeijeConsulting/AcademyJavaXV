package it.beije.hopper.ecommerce;

import it.beije.hopper.Contatto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Scanner;


public class GestoreEcommerce {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction entityTransaction = entityManager.getTransaction();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci la tua email:");
        String email = scanner.nextLine();
        System.out.println("Inserisci la password:");
        String psw = scanner.nextLine();
        boolean login = MethodsEcommerce.login(email, psw);

        if (login) {
            System.out.println("Benvenuto in BeijeShop, cosa vuoi fare?\n 1. Lista prodotti, \n 2. Acquista");
            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1": {
                    MethodsEcommerce.productList();
                    break;
                }
                case "2": {
                    ArrayList<Product> prodotti = new ArrayList<>();
                    MethodsEcommerce.productList();
                    System.out.println("Che prodotto vuoi acquistare?");
                    Integer id = Integer.valueOf(scanner.nextLine());
                    System.out.println("Quanti ne vuoi acquistare?");
                    Integer qta = Integer.valueOf(scanner.nextLine());
                    Product articolo = entityManager.find(Product.class, id);
                    Product articoloX = new Product();
                    articoloX.setName(articolo.getName());
                    articoloX.setDesc(articolo.getDesc());
                    articoloX.setPrice(articolo.getPrice());
                    articoloX.setQuantity(qta);
                    prodotti.add(articoloX);
                    System.out.println("Vuoi acquistare ancora?");
                    String x = scanner.nextLine();

                    while (x.equalsIgnoreCase("Y")) {
                        System.out.println("Che prodotto vuoi acquistare?");
                        Integer id1 = Integer.valueOf(scanner.nextLine());
                        System.out.println("Quanti ne vuoi acquistare?");
                        Integer qta2 = Integer.valueOf(scanner.nextLine());
                        Product articolo1 = entityManager.find(Product.class, id);
                        Product articolo2 = new Product();
                        articolo2.setName(articolo.getName());
                        articolo2.setDesc(articolo.getDesc());
                        articolo2.setPrice(articolo.getPrice());
                        articolo2.setQuantity(qta2);
                        prodotti.add(articolo2);
                        System.out.println("Vuoi acquistare ancora?");
                        x = scanner.nextLine();
                    }
                    System.out.println("okay, gli articoli che vuoi acquistare sono i seguenti: \n" + prodotti);
                }
            }
        } else {
            System.out.println("Username e/o password errati");
        }
    }

}
