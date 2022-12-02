package it.beije.magazzino.service;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.beije.magazzino.model.Product;
import it.beije.magazzino.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired 
	EntityManager em;

	public ProductService() {
		System.out.println("creo un oggetto ProductService...");
	}

	public List<Product> findAll() {
		
		return productRepository.findAll();
	}

	public List<Product> findById(int prodotto) {
		return productRepository.findById(prodotto);
	}
	
	
	public Product save(Product prod) {
		return productRepository.save(prod);
	}
	
	public List<Product> findByTipo(String tipo){
        List<Product> prod = productRepository.findByTipo(tipo);
        return prod;
    }
	
	
    
	
	public List<Product> findByDesc(String desc){
        List<Product> prod = productRepository.findByDesc(desc);
        return prod;
    }



	public List<Product> findByName(String nome) {
		List<Product> prod = productRepository.findByName(nome);
        return prod;
	}
	
	public List<Product> findByNameAndDesc(String name, String desc) {
		List<Product> prod = productRepository.findByNameAndDesc(name, desc);
        return prod;
	}
	
	
	public List<Product> getProductCriteria(){
	 CriteriaBuilder cb = em.getCriteriaBuilder();
	 CriteriaQuery<Product> cq = cb.createQuery(Product.class);
	 
	 Root<Product> prod = cq.from(Product.class);
	 
	 TypedQuery<Product> query = em.createQuery(cq);
	 return query.getResultList();
	}
	
	public List<Product> getProductIdCriteria(int id){
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		 
		 Root<Product> prod = cq.from(Product.class);
		 cq.select(prod).where(cb.equal(prod.get("id"), id));
		 TypedQuery<Product> query = em.createQuery(cq);
		 return query.getResultList();
		}
	
	
	
	
	public List<Product> getProductNameCriteria(String name){
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		 
		 Root<Product> prod = cq.from(Product.class);
		 cq.select(prod).where(cb.equal(prod.get("name"), name));
		 TypedQuery<Product> query = em.createQuery(cq);
		 return query.getResultList();
		}
	public List<Product> getProductDescCriteria(String desc){
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		 
		 Root<Product> prod = cq.from(Product.class);
		 cq.select(prod).where(cb.equal(prod.get("desc"), desc));
		 TypedQuery<Product> query = em.createQuery(cq);
		 return query.getResultList();
		}
	 
	public List<Product> getProductNameDescCriteria(String nome, String desc){
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		 
		 Root<Product> prod = cq.from(Product.class);
		 cq.select(prod).where(cb.equal(prod.get("name"), nome));
		 cq.select(prod).where(cb.equal(prod.get("desc"), desc));
		 TypedQuery<Product> query = em.createQuery(cq);
		 return query.getResultList();
		}
//	public List<Product> getProductCriteria(){
//		JpaEntityManager.getInstance();
//		EntityManagerFactory entityManagerFactory= JpaEntityManager.getInstance();
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
//		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
//		
//		Root<Product> productRoot = criteriaQuery.from(Product.class);
//		
//		criteriaQuery.select(productRoot);
//		
//		CriteriaQuery<Product> select = criteriaQuery.select(productRoot);
//		TypedQuery<Product> query = entityManager.createQuery(select);
//		
//		return query.getResultList();
//	}


}