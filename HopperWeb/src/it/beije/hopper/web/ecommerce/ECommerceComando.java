package it.beije.hopper.web.ecommerce;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//import it.beije.hopper.Contatto;
//import it.beije.hopper.Recapito;

public class ECommerceComando {

	public static void main(String[] args) {
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HopperWeb");
//		 EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		
//		
//		
//		//User utente = login();
//		
//		//eCommerceUsers(entityManager, entityTransaction);
//		//eCommerceProducts(entityManager, entityTransaction);
//		//eCommerceOrder(entityManager, entityTransaction);
//		//eCommerceOrderItems(entityManager, entityTransaction);
//		//Acquisto (utente, entityManager,  entityTransaction);
//		
//		
//		entityManager.close();
	}
	
	
	public static void eCommerceUsers(EntityManager entityManager, EntityTransaction entityTransaction)
	{
				
		 User user = null;		 
		 
		 List<User> users = entityManager.createQuery("from User u", User.class).getResultList();
		 for (User u : users)
			 System.out.println(u);
		
		entityTransaction.commit();
	}
	
	public static void eCommerceProducts(EntityManager entityManager,EntityTransaction entityTransaction)
	{
		
		 Product product = null;		 
		 
		 List<Product> products = entityManager.createQuery("from Product p", Product.class).getResultList();
		 for (Product p : products)
			 System.out.println(p);
		
		entityTransaction.commit();
	}
	
	public static void eCommerceOrder(EntityManager entityManager,EntityTransaction entityTransaction)
	{
		
		 Order order = null;		 
		 
		 List<Order> orders = entityManager.createQuery("from Order o", Order.class).getResultList();
		 for (Order o : orders)
			 System.out.println(o);
		
		entityTransaction.commit();
	}
	
	public static void eCommerceOrderItems(EntityManager entityManager, EntityTransaction entityTransaction)
	{
		
		 Item item = null;		 
		 
		 List<Item> items = entityManager.createQuery("from Item i", Item.class).getResultList();
		 for (Item i : items)
			 System.out.println(i);
		
		entityTransaction.commit();
	}
	
	public static void login(String username, String password)
	{
		
		System.out.println("Funziona");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HopperWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();		
		
		User user = new User();
		 
		 List<User> users = entityManager.createQuery("from User u", User.class).getResultList();

			//controllare che utente sia in DB
				
				boolean isExist = false;

					 System.out.println("Inserire email");		 
					 user.setEmail(username);
					 
					 System.out.println("Inserire password");		 
					 user.setPassword(password);
					 
					for (User u : users)
						 if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword()))
						 {
							 isExist = true;
							 user.setId(u.getId());
						 }
					
				
			
		entityManager.close();						
		}
	
	public static void registrazione(String username, String password)
	{
//		boolean isThere = false;
//		
//		for (User u : users)
//			 if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword()))
//				 isThere = true;
//		
//		if (isThere == false)
//		{
//			scanner = new Scanner(System.in);
//		
//			System.out.println("Inserire Nome: ");		
//			user.setName(scanner.nextLine());
//			
//			System.out.println("Inserire Cognome: ");
//			user.setSurname(scanner.nextLine());
//			
//			System.out.println("Inserire Email: ");
//			user.setEmail(scanner.nextLine());
//			
//			System.out.println("Inserire Password: ");
//			user.setPassword(scanner.nextLine());
//			
//			entityManager.persist(user);
//			
//			entityTransaction.commit();
//			
//		}
//		
//		else
//			System.out.println("Utente già presente!!");
//		 
//		//entityManager.close();
//		break;
	}
	
	public static void Acquisto (User user, EntityManager entityManager, EntityTransaction entityTransaction)
	{
		
		//System.out.println("ID UTENTE IN ACQUISTO " + user.getId());
		 int id_acquisto;		 
		 
		do 
		 {
			 Product product = null;		 
			 
			 List<Product> products = entityManager.createQuery("from Product p", Product.class).getResultList();
			 for (Product p : products)
				 System.out.println(p);
			 
			 System.out.println("Inserire l'ID del prodotto da comprare o digitare 0 per uscire ");
			 Scanner scanner = new Scanner(System.in);
			 id_acquisto = scanner.nextInt();
			 
			 System.out.println("Inserire la quantità ");
			 int numero = scanner.nextInt();
			 
			 
			 
			 updateItem(user, entityManager, entityTransaction, id_acquisto, numero, products);

			 
			 
		 }while (id_acquisto!=0);
		 
		entityTransaction.commit();
			
	}
	
	public static void updateItem(User user, EntityManager entityManager, EntityTransaction entityTransaction, int idProdottoAcquistato, int quanti, List<Product> prod)
	{
		double spesa = 0;
						
		for (Product p: prod) {
			System.out.println(p.getName());
			
			p.setRating(p.getRating());
			if (p.getId() == idProdottoAcquistato)
			{	
				System.out.println(p);
				String nome = p.getName();
				int totale = p.getQuantity();
				//System.out.println("Totale: "+totale);
				int nuovo = p.getQuantity() - quanti;
				//System.out.println("nuovo: "+nuovo);
				p.setQuantity(nuovo);
				//p.setName("AAA");
				p.setDesc(p.getDesc());
				p.setPrice(p.getPrice());
				
				spesa+= quanti * p.getPrice();
				//System.out.println(p);
				entityManager.persist(p);
				
				
				//CARRELLO
				
				List<Product> carrello = new ArrayList<Product>();
				for (int i = 0; i<quanti; i++)
				{
					carrello.add(p);
					
				}
				System.out.println("CARRELLO: " + p.getName() + " QUANTITA': "+quanti +" PREZZO CAD: " + p.getPrice());
				System.out.println(carrello);
					
			}
		}
		
		
		//salvare il record nell'ordine
		
		//entityTransaction.commit();
		updateOrder(user, entityManager, entityTransaction, spesa, idProdottoAcquistato, quanti);
		
	}
	
	
	public static void updateOrder(User user, EntityManager entityManager, EntityTransaction entityTransaction, double spesa, int idProdottoAcquistato, int quanti)
	{
		LocalDateTime now = LocalDateTime.now(); 
		 Order order = new Order();
		 System.out.println("ID utente " + user.getId());
		 order.setUserId(user.getId());
		 order.setAmount(spesa);
		 order.setDatetime(now);
		 
		 entityManager.persist(order);
		 	
		
		Item item = new Item();
		item.setOrderId(order.getId());
		item.setProductId(idProdottoAcquistato);
		item.setPrice(spesa);
		item.setQuantity(quanti);
		item.setName(""+order.getId()+idProdottoAcquistato);
		entityManager.persist(item);
		entityTransaction.commit();
		
		
		 
	}
	
	

}

