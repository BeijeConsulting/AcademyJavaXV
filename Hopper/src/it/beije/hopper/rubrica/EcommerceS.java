package it.beije.hopper.rubrica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import it.beije.hopper.Contatto;
import it.beije.hopper.Recapiti;
import it.beije.hopper.ecommerce.Item;
import it.beije.hopper.ecommerce.Product;
import it.beije.hopper.ecommerce.User;
import it.beije.hopper.ecommerce.Order;


public class EcommerceS {
	public static int id_login=0;
	
	public static void main(String[] args) {
		EntityManager entityManager = JPAEntityManagerFactory.openSession();
				
		System.out.println("Vuoi loggarti '1' o registrarti '2'");	
		Scanner logreg = new Scanner(System.in);
		String lr = logreg.next();
		if (lr.equals("1")) {
		if(Login()==1) {
		//SCANNER
			System.out.println(id_login);
		System.out.println("Premi 'U' per gli utenti, 'P' per i prodotti, 'C' per comprare un prodotto");		
		Scanner modifiche = new Scanner(System.in);
		String st = modifiche.next();

		if (st.equals("U")) {
			selectUsers();
		}else if (st.equals("P")) {
			selectProd();
		}
		else if (st.equals("C")) {
			
			Buy();	
		}		
		
		}		
		}else if (lr.equals("2")) {	
			
			Registration();
			System.out.println("Registrazione effettuata correttamente");

		}
				
		
					
		
		
	
	}
	
	
	public static int Login() {
		EntityManager entityManager = JPAEntityManagerFactory.openSession();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		int log = 0;
		System.out.println("Inserisci l'email");
		Scanner login = new Scanner(System.in);
		String lg= login.nextLine();
		
		Query query = entityManager.createQuery("SELECT u FROM User as u WHERE email ='"+lg+"'");
		if(query.getResultList().size() == 0){
			System.out.println("questo utente non esiste");
		}else {	
		System.out.println("Inserisci ps");
		String ps= login.nextLine();
		 query = entityManager.createQuery("SELECT u FROM User as u WHERE password ='"+ps+"'");
		 if(query.getResultList().size() == 0){
				System.out.println("Password sbagliata");
		 }else {
			 
			 query = entityManager.createQuery("SELECT u FROM User as u WHERE email ='"+lg+"'AND password ='"+ps+"'");
			 List<User> user = query.getResultList();
				for (User u : user) {
					id_login=u.getId();
				}
				System.out.println("login effettuato");
				log = 1;
		 }
		}
		return log;
	}

	public static void Registration() {
		EntityManager entityManager = JPAEntityManagerFactory.openSession();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		User user = new User();
		
		Scanner registration = new Scanner(System.in);
		System.out.println("Inserisci l'email");	
		String email= registration.nextLine();
		
		System.out.println("Inserisci password");	
		String password= registration.nextLine();
		
		System.out.println("Inserisci nome");	
		String nome= registration.nextLine();
		
		System.out.println("Inserisci cognome");
		String cognome= registration.nextLine();
		
		user.setSurname(cognome);
		user.setName(nome);
		user.setEmail(email);
		user.setPassword(password);
		
		entityManager.persist(user);
		entityTransaction.commit();
		entityManager.close();
		}
		
	static private void Buy() {
		EntityManager entityManager = JPAEntityManagerFactory.openSession();
		
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		
		Order order=new Order();
		Item item=new Item();
		double amount=0;
		LocalDateTime localDateTime=LocalDateTime.now();
		
		
		List<Product> carrello=new ArrayList<>();
		
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Quale prodotto vuoi acquistare?: (exit per uscire)");
		selectProd();
		String id_prod=scanner.nextLine();
		
		LOOP:while(!id_prod.equals("exit")) {
			Product product=entityManager.find(Product.class, Integer.parseInt(id_prod));
			
					carrello.add(product);
					System.out.println("Prodotto aggiunto al carrello");
					product.setQuantity(product.getQuantity()-1);
							
			
			System.out.println("Vuoi comprare qualcos'altro?(si,no)");
			if(scanner.nextLine().equals("si")) {
				selectProd();
				System.out.println("Quale altro prodotto vuoi acquistare?: (exit per uscire)");
				id_prod=scanner.nextLine();
				
				continue LOOP;
			}else {
				id_prod="exit";
			}
		}
	
		
		if(carrello.size()>0) {
			System.out.println("\nSicuro di voler acquistare i seguenti articoli?(si,no)");
			for(int i=0; i<carrello.size(); i++) {
				System.out.println("Il tuo carrello:");
				System.out.println(carrello.get(i));
			}
			if(scanner.nextLine().equals("si")) {
				for(int i=0; i<carrello.size(); i++) {
					amount+=carrello.get(i).getPrice();
					
			}
				order.setUserId(id_login);
				order.setDatetime(localDateTime);
				order.setAmount(amount);
				
				entityManager.persist(order);
				
				
				
				
				LOOP:for(int i=0;i<carrello.size();i++) {
							
					if(i!=0)
						for(int j=i-1;j>=0;j--) {
							
							if(carrello.get(i).getId()==carrello.get(j).getId()) {
								Query query=entityManager.createQuery("SELECT i FROM Item i WHERE i.name='"+order.getId()+""+carrello.get(i).getId()+"'");
								Item items=(Item)query.getResultList().get(0);
								items.setQuantity(items.getQuantity()+1);
								items.setPrice(items.getPrice()+carrello.get(i).getPrice());
								entityManager.persist(items);
								transaction.commit();
								continue LOOP;
							}					
						}
					
					item.setOrderId(order.getId());
					item.setProductId(carrello.get(i).getId());
					item.setName(carrello.get(i).getName());
					item.setPrice(carrello.get(i).getPrice());
					item.setDesc(carrello.get(i).getDesc());
					item.setQuantity(1);
					entityManager.persist(item);
					transaction.commit();
				}
				System.out.println("Ordine effettuato con successo");
				transaction.commit();
			}	
			else{
			for(int i=0;i<carrello.size();i++)
				carrello.get(0).setQuantity(carrello.get(0).getQuantity()+1);
			}
			
		}
		
		entityManager.close();
	}
	
	
	
	
	
	
	
	public static void selectUsers() {
		EntityManager entityManager = JPAEntityManagerFactory.openSession();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query query = entityManager.createQuery("SELECT u FROM User as u");//SELECT * FROM rubrica
		List<User> user = query.getResultList();
		for (User u : user) {
			System.out.println(u);
//			if (c.getId() == 21) contatto = c;
		}

		entityTransaction.commit();
		entityManager.close();
	}

	public static void selectProd() {
		EntityManager entityManager = JPAEntityManagerFactory.openSession();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query query = entityManager.createQuery("SELECT p FROM Product as p");//SELECT * FROM rubrica
		List<Product> product = query.getResultList();
		for (Product p : product) {
			System.out.println(p);
		}

		entityTransaction.commit();
		entityManager.close();
	}
}

