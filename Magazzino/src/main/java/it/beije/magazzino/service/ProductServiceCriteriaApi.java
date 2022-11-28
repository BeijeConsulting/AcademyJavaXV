package it.beije.magazzino.service;

import it.beije.magazzino.JpaEntityManager;
import it.beije.magazzino.model.Product;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;



@Service
public class ProductServiceCriteriaApi {


    EntityManagerFactory emf;
    public ProductServiceCriteriaApi(){
        emf = JpaEntityManager.getInstance();
    }
    public List<Product> findAll(){
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();

        //Use builder to create a query
        CriteriaQuery<Product> query = builder.createQuery(Product.class);

        // SELECT p FROM Product p (equivalent)
//        query.select(query.from(Product.class)); alternative to below
        Root<Product> product = query.from(Product.class);
        query.select(product);

        TypedQuery<Product> tq = em.createQuery(query);

        List<Product> result = tq.getResultList();

        return result;
    }
//
//    public Product findById(Integer id){
//        Optional<Product> product = productRepository.findById(id);
//        return product.get();
//    }
//
//    public Product save(Product product){
//        return productRepository.save(product);
//    }
//
//
//    public void deleteById(Integer id){ productRepository.deleteById(id);}
//
//    public List<Product> findByType(String type){
//        return productRepository.findByType(type);
//    }
//
//    public List<Product>  findByNameOrDescription(String name, String description){
//        return productRepository.findByNameOrDescription(name,description);
//    }

}
