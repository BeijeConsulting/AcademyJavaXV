package it.beije.magazzino;


import it.beije.magazzino.model.Product;
import org.hibernate.Transaction;

import javax.persistence.*;

import javax.persistence.criteria.*;
import java.util.List;

public class ProductCriteria {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("magazzino");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    static EntityTransaction entityTransaction = entityManager.getTransaction();


    public static List<Product> allProductsCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> q = cb.createQuery(Product.class);
        Root<Product> c = q.from(Product.class);
        q.select(c);
        List<Product> products = entityManager.createQuery(q).getResultList();
        return products;
    }

    public static Product productByIdCriteria(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> q = cb.createQuery(Product.class);
        Root<Product> c = q.from(Product.class);
        q.select(c).where(cb.equal(c.get("id"), id));
        Product product = entityManager.createQuery(q).getSingleResult();
        return product;
    }

    public static List<Product> productByTypologyCriteria(String typology) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> q = cb.createQuery(Product.class);
        Root<Product> c = q.from(Product.class);
        q.select(c).where(cb.equal(c.get("typology"), typology));
        return entityManager.createQuery(q).getResultList();
    }

    public static List<Product> productByNameCriteria(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> q = cb.createQuery(Product.class);
        Root<Product> c = q.from(Product.class);
        q.select(c).where(cb.equal(c.get("name"), name));
        return entityManager.createQuery(q).getResultList();
    }

    public static void deleteProductCriteria(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Product> criteriaDelete = cb.createCriteriaDelete(Product.class);
        Root<Product> root = criteriaDelete.from(Product.class);
        criteriaDelete.where(cb.equal(root.get("id"), id));
        entityTransaction.begin();
        entityManager.createQuery(criteriaDelete).executeUpdate();
        entityTransaction.commit();
    }

    public static void updateProductCriteria(Product product) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Product> criteriaUpdate = cb.createCriteriaUpdate(Product.class);
        Root<Product> root = criteriaUpdate.from(Product.class);
        criteriaUpdate.set("name", product.getName());
        criteriaUpdate.set("typology", product.getTypology());
        criteriaUpdate.set("quantity", product.getQuantity());
        criteriaUpdate.set("description", product.getDescription());
        criteriaUpdate.where(cb.equal(root.get("id"), product.getId()));

        entityTransaction.begin();
        entityManager.createQuery(criteriaUpdate).executeUpdate();
        entityTransaction.commit();
    }
    public static void saveProductCriteria(Product product) {

    }
    public static void main(String[] args) {
    }
}
