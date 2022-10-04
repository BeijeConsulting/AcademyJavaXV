package it.beije.hopper.ecommerceMod;

import it.beije.hopper.Contatto;
import it.beije.hopper.ecommerce.Order;
import it.beije.hopper.ecommerce.Product;
import it.beije.hopper.ecommerce.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class EcommerceJPA {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
		EntityManager entityManager = entityManagerFactory.createEntityManager();


		int orderId = 3;
		Order order = entityManager.find(Order.class, orderId);
		Query query = entityManager.createQuery("SELECT i FROM Item as i WHERE order_id="+orderId);
		order.setItems(query.getResultList());
		System.out.println("Order: " + order);
		System.out.println();

		System.out.println("-------------------------");


		Query query1 = entityManager.createQuery("SELECT p FROM Product as p");
		for( Product product : (ArrayList<Product>)query1.getResultList() ){
			System.out.println("Product: " + product);
		}




		User testUsr = getUser(entityManager, "miky@gmail.com");
		Product testProduct = getProduct(entityManager, "Scarpe Nike", null);
		System.out.println("Test Usr: " + testUsr);
		System.out.println("TestProduct: " + testProduct);
		entityManager.close();
	}


//ADD USER
//ADD PRODUCT



	public static void addToCart(EntityManager entityManager, User user, Product product){



	}
//
//	public static void addProduct(EntityManager entityManager, String name, String desc, Double price, Integer quantity, Integer rating ){
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//
//
//	}

	//Extracts product based on name or id
	//returns null if Product does not exist
	public static Product getProduct(EntityManager entityManager, String productName, Integer productId){
		if( productId != null ) {
			return entityManager.find(Product.class, productId);
		}
		Query query = entityManager.createQuery("SELECT p FROM Product as p WHERE name="+"'"+productName+"'");
			for(Product product : (ArrayList<Product>)query.getResultList())
				if(product.getName().equalsIgnoreCase(productName)) return product;
		return null;
	}

	//Get all products
	public static List<Product> getAllProducts(EntityManager entityManager){
		Query query = entityManager.createQuery("SELECT p FROM Product as p");
		List<Product> products = query.getResultList();
		return products;
	}


 /// -------------------- USER -----------------

	//Extracts User based on email. TODO: make it work with name, surname (and id?) --> add String Type
	//returns null if User does not exist
	public static User getUser(EntityManager entityManager, String userEmail){
			Query query = entityManager.createQuery("SELECT u FROM User as u WHERE email="+"'"+userEmail+"'");
			for( User user : (ArrayList<User>)query.getResultList()){
				if( user.getEmail().equalsIgnoreCase(userEmail)) return user;
			}
			return null;
	}


	//Get all users
	public static List<User> getAllUsers(EntityManager entityManager){
		Query query = entityManager.createQuery("SELECT u FROM User as u");
		List<User> users = query.getResultList();
		return users;
	}
}
