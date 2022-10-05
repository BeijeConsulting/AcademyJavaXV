package it.beije.hopper.ecommerce;

import it.beije.hopper.Contatto;

import javax.persistence.*;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestoreEcommerce {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction entityTransaction = entityManager.getTransaction();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto, digita 'login' per loggarti o 'registrati' per registrarti.");
        String loginReg = scanner.nextLine();
        if (loginReg.equalsIgnoreCase("login")) {
            System.out.println("Inserisci la tua email:");
            String email = scanner.nextLine();
            System.out.println("Inserisci la password:");
            String psw = scanner.nextLine();
            boolean login = MethodsEcommerce.login(email, psw);

            if (login) {
                Query query = entityManager.createQuery("SELECT u FROM User as u WHERE email='" + email + "'");
                List<User> users = query.getResultList();
                User u = new User();

                u.setId(users.get(0).getId());
                u.setName(users.get(0).getName());
                u.setSurname(users.get(0).getSurname());
                System.out.println("Benvenuto in BeijeShop " + u.getName() + " " + u.getSurname() + ", cosa vuoi fare?\n 1. Lista prodotti, \n 2. Acquista");

                boolean choice = true;
                String scelta = scanner.nextLine();

                switch (scelta) {
                    case "1": {
                        MethodsEcommerce.productList();
                        break;
                    }
                    case "2": {
                        entityTransaction.begin();
                        Order order = new Order();
                        order.setUserId(u.getId());
                        order.setDatetime(LocalDateTime.now());

                        Double tot = 0.0;
                        ArrayList<Item> carrello = new ArrayList<>();
                        MethodsEcommerce.productList();
                        try {
                            System.out.println("Che prodotto vuoi acquistare?");
                            Integer id = Integer.valueOf(scanner.nextLine());
                            Product prodotto = entityManager.find(Product.class, id);
                            prodotto.getName();
                            System.out.println("Quanti ne vuoi acquistare?");
                            Integer qta = Integer.valueOf(scanner.nextLine());

                            Item item = new Item();
                            item.setName(prodotto.getName());
                            item.setDesc(prodotto.getDesc());
                            item.setPrice(prodotto.getPrice());
                            item.setProductId(prodotto.getId());
                            item.setQuantity(qta);
                            prodotto.setQuantity(prodotto.getQuantity() - qta);
                            carrello.add(item);

                            tot += item.getPrice() * item.getQuantity();
                        } catch (NullPointerException e) {
                            System.out.println("Prodotto non valido.");
                        }
                        System.out.println("Vuoi acquistare ancora? ('Y' se si', 'N' se no)");
                        String x = scanner.nextLine();

                        while (x.equalsIgnoreCase("Y")) {
                            try {
                                System.out.println("Che prodotto vuoi acquistare?");
                                Integer id1 = Integer.valueOf(scanner.nextLine());
                                Product prodotto1 = entityManager.find(Product.class, id1);
                                prodotto1.getName();

                                System.out.println("Quanti ne vuoi acquistare?");
                                Integer qta2 = Integer.valueOf(scanner.nextLine());
                                Item item1 = new Item();
                                item1.setName(prodotto1.getName());
                                item1.setDesc(prodotto1.getDesc());
                                item1.setPrice(prodotto1.getPrice());
                                item1.setProductId(prodotto1.getId());
                                item1.setQuantity(qta2);
                                prodotto1.setQuantity(prodotto1.getQuantity() - qta2);
                                carrello.add(item1);
                                tot += item1.getPrice() * item1.getQuantity();
                                System.out.println("Vuoi acquistare ancora? ('Y' se si', 'N' se no)");
                                x = scanner.nextLine();
                            } catch (NullPointerException e) {
                                System.out.println("Prodotto non valido.");
                                System.out.println("Vuoi acquistare ancora? ('Y' se si', 'N' se no)");
                                x = scanner.nextLine();
                            }
                        }
                        System.out.println("Okay, questi sono i prodotti che hai all'interno del carrello: \n" + carrello + "\n Per un totale di: " + tot + " euro.");
                        System.out.println("Vuoi confermare l'ordine? ('Y' se si', 'N' se no)");
                        String conferma = scanner.nextLine();

                        if (conferma.equalsIgnoreCase("Y")) {
                            order.setAmount(tot);
                            entityManager.persist(order);

                            int orderId = order.getId();
                            entityTransaction.commit();

                            for (Item i : carrello) {
                                i.setOrderId(orderId);

                                entityTransaction.begin();
                                entityManager.persist(i);
                                entityTransaction.commit();
                            }
                        } else {
                            System.out.println("Hai annullato l'ordine, alla prossima!");
                        }
                        break;
                    }
                    case "3": {

                    }
                    default: {
                        System.out.println("Scelta errata");
                        GestoreEcommerce.main(args);
                    }

                }
            } else {
                System.out.println("Username e/o password errati");
            }
        } else {
            User u = new User();
            System.out.println("Digita il tuo nome:");
            String nome = scanner.nextLine();
            System.out.println("Digita il tuo cognome:");
            String cognome = scanner.nextLine();
            System.out.println("Digita la tua email:");
            String email = scanner.nextLine();
            System.out.println("Digita la tua password:");
            String password = scanner.nextLine();
            u.setName(nome);
            u.setSurname(cognome);
            u.setEmail(email);
            u.setPassword(password);

            entityTransaction.begin();
            entityManager.persist(u);
            entityTransaction.commit();
            GestoreEcommerce.main(args);
        }


    }
}