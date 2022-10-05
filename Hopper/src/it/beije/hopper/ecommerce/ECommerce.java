package it.beije.hopper.ecommerce;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.hopper.rubrica.JPAEntityManagerFactory;

public class ECommerce {

	public static void main(String[] args) {
		EntityManager entityManager = JPAEntityManagerFactory.openSession();
		login(entityManager);
		entityManager.close();
	}
	
	//solo amministratori***
	static private void addUser(EntityManager entityManager,EntityTransaction transaction) {
		
		transaction.begin();
		
		User user=new User();
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("Inserire email: ");
		user.setEmail(scanner.nextLine());
		System.out.print("\nInserire password: ");
		user.setPassword(scanner.nextLine());
		System.out.print("\nInserire nome: ");
		user.setName(scanner.nextLine());
		System.out.print("\nInserire cognome: ");
		user.setSurname(scanner.nextLine());
		
		entityManager.persist(user);
		transaction.commit();
		entityManager.close();	
	}
	
	//solo amministratori***
	static private void addProduct(EntityManager entityManager,EntityTransaction transaction) {
		
		transaction.begin();
		
		Product product=new Product();
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("Inserire nome prodotto: ");
		product.setName(scanner.nextLine());
		
		System.out.print("Inserire descrizione prodotto: ");
		product.setDesc(scanner.nextLine());
		
		System.out.print("Inserire prezzo prodotto: ");
		product.setPrice(Double.parseDouble(scanner.nextLine()));
		
		System.out.print("Inserire quantità disponibili prodotto: ");
		product.setQuantity(Integer.parseInt(scanner.nextLine()));
		
		System.out.print("Inserire votazione prodotto: ");
		product.setRating(Integer.parseInt(scanner.nextLine()));
		
		entityManager.persist(product);
		transaction.commit();
		entityManager.close();
	}
	
	static private void order(int id,EntityManager entityManager) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		
		Order order=new Order();
		
		//Dato che la tabella è piccola faccio questa stampa in modo da facilitare l'acquisto
		stampaProdotti();
		
		Carrello carrello=new Carrello();
		
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Inserire id prodotto da voler comprare: (exit per uscire)");
		String in=scanner.nextLine();
		
		LOOP:while(!in.equalsIgnoreCase("exit")) {
			Product product=entityManager.find(Product.class, Integer.parseInt(in));
			if(product.getQuantity()<=0)
				System.out.println("Il prodotto non è disponibile");
			else {
				System.out.println("Il prodotto è disponibile , vuoi aggiungerlo al carrello temporaneo? : (y per aggiungerlo,n per non aggiungerlo)");
				if(scanner.nextLine().equalsIgnoreCase("y")) {
					carrello.add(product);
					System.out.println("Prodotto aggiunto");
					product.setQuantity(product.getQuantity()-1);
				}
				else {
					System.out.println("Prodotto non aggiunto");
				}
					
			}
			System.out.println("Vuoi fare altri acquisti?(y si,n no)");
			if(scanner.nextLine().equalsIgnoreCase("y")) {
				stampaProdotti();
				System.out.println("Inserire id prodotto da voler comprare: (exit per uscire)");
				in=scanner.nextLine();
				
				continue LOOP;
			}else {
				in="exit";
			}
		}
		
		
		double amount=0;
		LocalDateTime localDateTime=LocalDateTime.now();
		if(carrello.size()>0) {
			System.out.println("\n\nVuoi acquistare gli articoli nel tuo carrello?");
			System.out.println("Il tuo carrello:");
			
			for(int i=0;i<carrello.size();i++) {	
				System.out.println(carrello.getProduct(i));
			}
			
			if(scanner.nextLine().equalsIgnoreCase("y")) {
				for(int i=0;i<carrello.size();i++) {
					amount+=carrello.getProduct(i).getPrice();
					
			}
				order.setUserId(id);
				order.setDatetime(localDateTime);
				order.setAmount(amount);
				order.setPromo(null);
				entityManager.persist(order);
				transaction.commit();
				orderItems(order,carrello,entityManager,transaction);
				System.out.println("Ordine effettuato");
				
			}	
			else{
			for(int i=0;i<carrello.size();i++)
				carrello.getProduct(0).setQuantity(carrello.getProduct(0).getQuantity()+1);
			}
		}
	}
	
	static private void orderItems(Order order,Carrello product,EntityManager entityManager,EntityTransaction transaction) {
		
		Item item;
		LOOP:for(int i=0;i<product.size();i++) {
			transaction.begin();
			
			if(i!=0)
				for(int j=i-1;j>=0;j--) {
					
					if(product.getProduct(i).getId()==product.getProduct(j).getId()) {
						Query query=entityManager.createQuery("SELECT i FROM Item i WHERE i.name='"+order.getId()+""+product.getProduct(i).getId()+"'");
						Item items=(Item)query.getResultList().get(0);
						items.setQuantity(items.getQuantity()+1);
						items.setPrice(items.getPrice()+product.getProduct(i).getPrice());
						entityManager.persist(items);
						transaction.commit();
						continue LOOP;
					}					
				}
			
			item=new Item();
			item.setOrderId(order.getId());
			item.setProductId(product.getProduct(i).getId());
			item.setName(order.getId()+""+product.getProduct(i).getId());
			item.setPrice(product.getProduct(i).getPrice());
			item.setDesc(product.getProduct(i).getDesc());
			item.setQuantity(1);
			entityManager.persist(item);
			transaction.commit();
		}
		
	}

	static private void login(EntityManager entityManager) {
					
		Scanner scanner=new Scanner(System.in);
		String email;
		String password;
		
		System.out.println("Benvenuto, inserire email e password: ");
		System.out.print("Email: ");
		email=scanner.nextLine();
		System.out.print("Password: ");
		password=scanner.nextLine();
				
		Query query=entityManager.createQuery("SELECT u FROM User u WHERE u.email='"+email+"' AND u.password='"+password+"'");
		User user=(User)query.getResultList().get(0);
		if(user!=null) {
			System.out.println(user);
			System.out.println("Login avvenuto con successo!\n");
			System.out.println("Per fare un ordine digitare ordine");
			if(scanner.nextLine().equalsIgnoreCase("ordine"))
				order(user.getId(),entityManager);
			}
	}
	
	static private void stampaProdotti() {
		
		EntityManager entityManager = JPAEntityManagerFactory.openSession();
		
		Query query=entityManager.createQuery("SELECT p FROM Product as p");
		List<Product> product=query.getResultList();
		
		for(Product u: product)
			System.out.println(u);	
	}


}
