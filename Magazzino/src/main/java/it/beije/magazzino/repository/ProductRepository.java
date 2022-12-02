package it.beije.magazzino.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import it.beije.magazzino.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public abstract List<Product> findAll();
	 
	 public abstract List<Product> findById(int id);

	 public abstract List<Product> findByTipo(String tipo);
	 
	 public abstract List<Product> findByName(String nome);
	 
	 public abstract List<Product> findByDesc(String desc);
	 
	 public abstract List<Product> findByNameAndDesc(String name, String desc);
	 

}
