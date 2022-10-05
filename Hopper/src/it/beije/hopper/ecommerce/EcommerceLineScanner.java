package it.beije.hopper.ecommerce;

import it.beije.hopper.Contatto;
import it.beije.hopper.Recapito;
import it.beije.hopper.rubrica.RubricaJPA2;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EcommerceLineScanner {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager createEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("em");

        }
        return entityManagerFactory.createEntityManager();
    }

    public static User LogIn(EntityManager entityManager) {
        User u = null;
        Scanner s = new Scanner(System.in);
        String email;
        String password;
        List<User> users = new ArrayList<>();
        while (users == null || users.isEmpty()) {
            System.out.println("Inserire email: ");
            email = s.nextLine();
            System.out.println("Inserire password: ");
            password = s.nextLine();

            Query query = entityManager.createQuery("SELECT u FROM user as u where u.email = " + email + " AND u.password = " + password + "");
            users = query.getResultList();
            if (users == null || users.size() != 1) {
                System.out.println("email o password errati!");
                users = null;
            } else {
                u = users.get(0);
            }
        }
        return u;

    }

    public static User AddUser(EntityManager entityManager) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        User u = new User();
        Scanner s = new Scanner(System.in);
        String nome_utente = "";
        String cognome = "";
        while (nome_utente == null || nome_utente.isEmpty()) {
            System.out.println("Inserire nome Utente: ");
            nome_utente = s.nextLine();
            System.out.println("Inserire Cognome: ");
            cognome = s.nextLine();
        }
        String email = null;
        while (email == null || email.isEmpty()) {
            System.out.println("Inserire email: ");
            email = s.nextLine();
            Query query = entityManager.createQuery("SELECT u FROM user as u where u.email = " + email);
            List<User> users = query.getResultList();
            if (users != null || users.size() != 0) {
                System.out.println("email già inserita! Inserire una nuova email");
                email = null;
                continue;
            }
            break;
        }
        String password = null;
        while (password == null || password.isEmpty()) {
            System.out.println("Inserire password: ");
            password = s.nextLine();
        }
        u.setName(nome_utente);
        u.setSurname(cognome);
        u.setEmail(email);
        u.setPassword(password);
        entityManager.persist(u);

        entityTransaction.commit();
        return u;
    }

    public static boolean ChangePassword(EntityManager entityManager, User user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User u = entityManager.find(User.class, user.getId());
        if (u == null) {
            System.out.println("utente inesistente");
        }
        Scanner s = new Scanner(System.in);
        String oldPassword = null;
        while (oldPassword == null || oldPassword.isEmpty()) {
            System.out.println("Inserire vecchia password: ");
            oldPassword = s.nextLine();
        }
        if (!oldPassword.equals(u.getPassword())) {
            System.out.println("Password errata! Quitting...");
            return false;
        }
        String newPassword = null;
        while (newPassword == null || newPassword.isEmpty()) {
            System.out.println("Inserire nuova password: ");
            newPassword = s.nextLine();
            if (newPassword.equals(oldPassword)) {
                System.out.println("La nuova password non può essere uguale alla precedente!");
                newPassword = null;
                continue;
            }
            break;
        }
        u.setPassword(newPassword);
        entityManager.persist(u);

        entityTransaction.commit();
        System.out.println("La password è stata modificata!");
        return true;
    }

    public static void AddOrder(EntityManager entityManager, User user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Scanner s = new Scanner(System.in);
        double amount = 0;

        Order order = new Order();
        order.setUserId(user.getId());
        Query query = entityManager.createQuery("SELECT i FROM Product as i order by id");
        List<Product> products = query.getResultList();
        for (Product product : products)
            System.out.println(product.toString());

        List<Item> itemsToBuy = new ArrayList<>();
        String temp = "";
        while (temp.equals("-1") || temp.isEmpty()) {
            System.out.println("Inserire id dell'oggetto che vuoi comprare: (inserisci -1 per uscire)");
            temp = s.nextLine();
            Product productTemp = entityManager.find(Product.class, Integer.parseInt(temp));
            System.out.println("Inserire quantità dell'oggetto che vuoi comprare: (Max: " + productTemp.getQuantity() + ")");
            String q = s.nextLine();
            Item item = new Item();
            item.setPrice(productTemp.getPrice());
            item.setProductId(productTemp.getId());
            item.setQuantity(Integer.parseInt(q));
            productTemp.setQuantity(productTemp.getQuantity() - Integer.parseInt(q));
            entityManager.persist(item);
            itemsToBuy.add(item);
            amount += item.getPrice();
        }
        order.setAmount(amount);
        order.setDatetime(LocalDateTime.now());
        order.setItems(itemsToBuy);
        entityManager.persist(order);
        System.out.println("Ordine effettuato!");

        entityTransaction.commit();
    }

    public static Order viewOrder(EntityManager entityManager, User user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Scanner s = new Scanner(System.in);
        double amount = 0;

        Order order = new Order();
        order.setUserId(user.getId());
        Query query = entityManager.createQuery("SELECT o FROM Order as o WHERE userId = " + user.getId() + " order by datetime");
        List<Order> orders = query.getResultList();
        for (Order o : orders)
            System.out.println(o.toString());

        String temp = "";
        while (temp.equals("-1") || temp.isEmpty()) {
            System.out.println("Inserire id dell'ordine che vuoi cambiare: (inserisci -1 per uscire)");
            temp = s.nextLine();
            Order orderTemp = entityManager.find(Order.class, Integer.parseInt(temp));
        }
        //TODO
        entityTransaction.commit();
        return order;
    }

    public static void main(String[] args) {
        EcommerceLineScanner ecommerceLineScanner = new EcommerceLineScanner();


    }
}
