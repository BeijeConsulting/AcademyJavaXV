package it.beije.magazzino.service;

import it.beije.magazzino.JpaEntityManager;
import it.beije.magazzino.model.Product;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Service
public class ProductServiceCriteria {

//    @Autowired
    EntityManagerFactory emf;

    EntityManager em;


    public ProductServiceCriteria(){
        emf = JpaEntityManager.getInstance();
        em = emf.createEntityManager();
    }

    public List<Product> findAll(){
//        EntityManager em = emf.createEntityManager();
//         em.getTransaction().begin() --> begin???
        CriteriaBuilder builder = em.getCriteriaBuilder();

        //Use builder to create a query
        CriteriaQuery<Product> query = builder.createQuery(Product.class);

        // SELECT p FROM Product p (equivalent)
//        query.select(query.from(Product.class)); alternative to below
        Root<Product> product = query.from(Product.class); // ROOT of the query!
        query.select(product);
        TypedQuery<Product> tq = em.createQuery(query);
        List<Product> result = tq.getResultList();

        return result;
    }

    //SELECT p FROM Product p WHERE p.quantity > :quantity; ---> TODO:HOW TO USE PARAMETERS IN CRITERIA QUERIES??
    public List<Product> findWhereQuantityGreaterThan(int quanitity){

//        EntityManager em = emf.createEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();

        //Use builder to create a query
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);

        query.select(product).where(
                builder.greaterThan(product.get("quantity"), quanitity)
        );


        TypedQuery<Product> tq = em.createQuery(query);
        List<Product> products = tq.getResultList();
        return products;
    }

    public List<Product> findByNameOrDescription(String name, String desc) {


    }

//    private static CriteriaQuery<Product> buildProductCriteriaQuery(){
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Product> query = builder.createQuery(Product.class);
//
//    }
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
