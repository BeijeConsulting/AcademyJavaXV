package it.beije.magazzino;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaQuery;
import it.beije.magazzino.model.Product;

@Service
public class CriteriaQueryEntity {

	private static EntityManager em = JpaEntityManager.getInstance().createEntityManager();
	private static CriteriaBuilder cb = em.getCriteriaBuilder(); 
	private static CriteriaQuery<Product> cq = cb.createQuery(Product.class );  
	private static Root<Product> root = cq.from(Product. class );
	private static TypedQuery<Product> query;  
	
	
	public static CriteriaQuery<Product> getCriteriaQuery() {
		return cq;
	}
	
	public static Root<Product> getRoot(){
		return root;
	}
	
	public static EntityManager getEntityManagar() {
		return em;
	}
	
	public static void createQuery(CriteriaQuery<Product> criterialQuery) {
		query = em.createQuery(criterialQuery);
	}
	
	public static TypedQuery<Product> getQuery(){
		return query;
	}
	
	public static CriteriaBuilder getCriteriaBuilder() {
		return cb;
	}
	
}
