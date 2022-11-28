package it.beije.magazzino.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.CriteriaQueryEntity;

public class QueryCriteria {
	
	public void allProduct() {
		
		CriteriaQuery<Product> query = CriteriaQueryEntity.getCriteriaQuery();
		query =  query.select(CriteriaQueryEntity.getRoot()); 
		CriteriaQueryEntity.createQuery(query);
		List<Product> list = CriteriaQueryEntity.getQuery().getResultList();  
		
		for(Product p : list) {
			System.out.println(p);
		}
	}
	
	public void getDisponibilita(int quantity) {
		
		CriteriaQuery<Product> query = CriteriaQueryEntity.getCriteriaQuery();
		query = query.select(CriteriaQueryEntity.getRoot())
				.where(CriteriaQueryEntity.getCriteriaBuilder().gt(CriteriaQueryEntity.getRoot().get("quantity"), quantity));
		CriteriaQueryEntity.createQuery(query); 
		List<Product> products = CriteriaQueryEntity.getQuery().getResultList();  
		
		for(Product product : products) {
			System.out.println(product);
		}
	}
	
	
	
}
