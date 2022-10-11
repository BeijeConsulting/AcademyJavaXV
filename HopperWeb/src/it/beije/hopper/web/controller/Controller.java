package it.beije.hopper.web.controller;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import it.beije.hopper.web.beans.*;

public class Controller {
    static EntityManagerFactory entityManagerFactory;
    static EntityManager entityManager;
    static EntityTransaction entityTransaction;

    public Controller() {
        if (entityManager == null || !entityManager.isOpen())
            getConnection();
    }

    private static void getConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hopperweb");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();

    }

    public User LogIn(String email, String password) {

        entityTransaction.begin();

        User u = null;
        List<User> users = new ArrayList<>();
        if (users == null || users.isEmpty()) {

            Query query = entityManager.createQuery("SELECT u FROM User as u where u.email = \'" + email + "\' AND u.password = \'" + password + "\'");
            users = query.getResultList();
            if (users == null || users.size() != 1) {
                System.out.println("email o password errati!");
                users = null;
            } else {
                u = users.get(0);
            }
        }
        entityTransaction.commit();
        return u;

    }

    public User AddUser(EntityManager entityManager) {
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
            Query query = entityManager.createQuery("SELECT u FROM User as u where u.email = \'" + email + "\'");
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

    public boolean ChangePassword(User user) {
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

    public Order AddOrder(int userid, HashMap<Integer, Integer> hashMap) {
        entityTransaction.begin();
        User user = entityManager.find(User.class, userid);

        double amount = 0.0;

        Order order = new Order();
        order.setUserId(user.getId());

        List<Item> itemsToBuy = new ArrayList<>();
        for (int i : hashMap.keySet()) {
            System.out.println("key: " + i + " value: " + hashMap.get(i));
            Product productTemp = entityManager.find(Product.class, i);
            Item item = new Item();
            item.setName(productTemp.getName());
            item.setPrice(productTemp.getPrice() * hashMap.get(i));
            item.setProductId(productTemp.getId());
            item.setQuantity(hashMap.get(i));
            productTemp.setQuantity(productTemp.getQuantity() - hashMap.get(i));

            itemsToBuy.add(item);
            amount += productTemp.getPrice() * hashMap.get(i);
        }
        order.setAmount(amount);
        order.setDatetime(LocalDateTime.now());
        order.setItems(itemsToBuy);
        entityManager.persist(order);
        for (Item item : itemsToBuy) {
            item.setOrderId(order.getId());
            entityManager.persist(item);
        }
        System.out.println("Ordine effettuato!");

        entityTransaction.commit();
        return order;
    }

    public List<Product> getProduct() {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Query query = entityManager.createQuery("SELECT i FROM Product as i order by id");
        List<Product> products = query.getResultList();

        entityTransaction.commit();
        return products;
    }

    public List<Order> viewOrder(User user) {
        entityTransaction.begin();
        Scanner s = new Scanner(System.in);
        double amount = 0;

        Order order = new Order();
        order.setUserId(user.getId());
        Query query = entityManager.createQuery("SELECT o FROM Order as o WHERE userId = " + user.getId() + " order by datetime");
        List<Order> orders = query.getResultList();
        for (Order o : orders){
            query = entityManager.createQuery("SELECT i FROM Item as i WHERE orderId = " + o.getId() + " order by id");
            List<Item> itemsTemp = query.getResultList();
            o.setItems(itemsTemp);
            System.out.println(o.toString());
        }


        entityTransaction.commit();
        return orders;
    }
}
