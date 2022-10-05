package it.beije.hopper.ecommerce;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


public class MethodsEcommerce {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction entityTransaction = entityManager.getTransaction();

    public static List<Product> productList() {
        Product product;
        Query query = entityManager.createQuery("SELECT p FROM Product as p");
        List<Product> productList = query.getResultList();
        for (Product p : productList) {
            System.out.println(p);
        }
        return productList;
    }

    public static boolean login(String email, String psw) {
        Query query = entityManager.createQuery("SELECT u FROM User as u");
        List<User> listaUsers = query.getResultList();

        for (int i = 0; i < listaUsers.size(); i++) {
            if (listaUsers.get(i).getEmail().equalsIgnoreCase(email) && listaUsers.get(i).getPassword().equals(psw)) {
                return true;
            }
        }
        return false;
    }

}

