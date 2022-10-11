package it.beije.hopper.ecommerceMod;



import it.beije.hopper.ecommerceMod.models.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class EcommerceJPA {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HopperWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		int orderId =3;
		Order order = entityManager.find(Order.class, orderId);
		Query query = entityManager.createQuery("SELECT i FROM Item as i WHERE order_id="+orderId);
		System.out.println(query.getResultList());
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
		Product testProduct2 = getProduct(entityManager, "", 2);
		System.out.println("Test Usr: " + testUsr);
		System.out.println("TestProduct: " + testProduct);
		System.out.println("TestProduct2: " + testProduct2);

		Cart cart = new Cart();
//		cart.addProduct(testProduct, 50.0);
//		cart.addProduct(testProduct, 50.0);
//		cart.addProduct(testProduct, 50.0);
		cart.addProduct(testProduct2, 2.0);
		cart.addProduct(testProduct2, 2.0);
		cart.addProduct(testProduct2, 2.0);
		cart.addProduct(testProduct2, 2.0);
		cart.addProduct(testProduct2, 2.0);

		System.out.println(cart);

		System.out.println(cart.getAllItemsInCart());

		System.out.println("-----------------------------------");
		/*
		addOrder(EntityManager entityManager, Cart cart, User user,
								LocalDateTime dateTime, Double promoOrder){
		* */
		LocalDateTime testDateTime = LocalDateTime.now();
		addOrder( entityManager, cart, testUsr,  testDateTime, 1.0);

		entityManager.close();
	}


//ADD USER
//ADD PRODUCT

	public static void addProductToCart(EntityManager entityManager, Product product, Integer discountPercentage){
//		Double discount...



	}
/// -------------------- Item (order items) -----------------

	//Insert/Add Order-Item in the DB (after
	public static void addOrderItem(EntityManager entityManager, Order order, User user, Product product ,
									 Cart cart, String orderDescription, Double promoOrder){

//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();

		Item newItem = new Item();
		newItem.setOrderId(order.getId());
		newItem.setProductId(product.getId());
		newItem.setName(product.getName());
		newItem.setDesc(orderDescription);
		newItem.setPrice( cart.numberOfProductInCart(product) * ( product.getPrice() - cart.singleProductDiscountAmount(product) ) ); // price is composed of: ( (Price of single product - (discount on that product)) * numOfProducts in cart ) -
		newItem.setQuantity(cart.numberOfProductInCart(product)); // --> Add to order and remove from Warehouse
		newItem.setPromo(promoOrder); // total promo of single order. This is not the promo for each single item.


		entityManager.persist(newItem);



//
//		entityTransaction.commit();


	}

/// -------------------- Order --------------------------------
	/*
	`id`
  	`user_id`
  	`datetime`
  	`amount`
  	`promo`
	*/
	//TODO: fix promo to percentage of totalItemtype --> Double.
	public static void addOrder(EntityManager entityManager, Cart cart, User user,
								LocalDateTime dateTime, Double promoOrder){

		EntityTransaction entityTransaction =  entityManager.getTransaction();
		entityTransaction.begin();

		//Create new Order
		Order newOrder = new Order();
		Integer userId = user.getId();

		newOrder.setUserId(user.getId());
		newOrder.setDatetime(dateTime);



		Iterator<Product> products = cart.getAllItemsInCart().iterator();
		//Calculate total promo and Set promo
		//promo = (objectType0-Promo*#Objectype0)+...+(objectType(n-1)-Promo*#Objectype(n-1))

		Double promoSingleItems = 0.0;
		while(products.hasNext()){
			Product tmpProd = products.next();
			promoSingleItems += ( cart.singleProductDiscountAmount(tmpProd) * cart.numberOfProductInCart(tmpProd));
		}

		newOrder.setAmount(cart.totalCostofCart()-( promoSingleItems+promoOrder ));
		newOrder.setPromo(promoSingleItems);

		entityManager.persist(newOrder);
		System.out.println("In addOrder (order) PT1:"+newOrder);
//		entityTransaction.commit();





		//extract all orders from cart and add them on order-item table
		products = cart.getAllItemsInCart().iterator();
		/*
		addOrderItem(EntityManager entityManager, Order order, User user, Product product, Cart cart, String orderDescription)
		* */
		//update order-items table
		while(products.hasNext()){
			Product tmpProduct = products.next();
			addOrderItem(entityManager, newOrder, user, tmpProduct, cart,  "Temporary Order-Item description", promoOrder);
			//Update number of items of product in "Warehouse"
			int newTotalQuantity = tmpProduct.getQuantity() - cart.numberOfProductInCart(tmpProduct);
			updateProduct(entityManager, tmpProduct, null, newTotalQuantity );
		}

		entityTransaction.commit();


		// ------- Order done -----
		Query query = entityManager.createQuery("SELECT i FROM Item as i WHERE order_id="+newOrder.getId());
		newOrder.setItems( query.getResultList() );
		System.out.println("In addOrder (order) Aftercommit:"+newOrder);


//		Order order = entityManager.find(Order.class, orderId);
//		Query query = entityManager.createQuery("SELECT i FROM Item as i WHERE order_id="+orderId);

	}
	public static Order getOrder(EntityManager entityManager, Integer id){
		return entityManager.find(Order.class, id);
	}
	//Get all Orders
	public static List<Order> getAllOrders(EntityManager entityManager){
		Query query = entityManager.createQuery("SELECT o FROM Order as o");
		return query.getResultList();
	}
	public static List<Order> getAllUserOrders(Integer id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HopperWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT o FROM Order as o where userId=" + id);
		return query.getResultList();
	}

/// -------------------- Product -----------------
	//TODO: OVERLOAD Better
	public static void updateProduct(EntityManager entityManager, String productName,  Double newPrice, Integer newQuantity){
		Product modifiedProduct = getProduct(entityManager, productName, null);
		updateProduct( entityManager, modifiedProduct,  newPrice, newQuantity);
	}

	public static void updateProduct(EntityManager entityManager, Integer productId, Double newPrice, Integer newQuantity){
		Product modifiedProduct = getProduct(entityManager, null, productId);
		updateProduct( entityManager, modifiedProduct,  newPrice, newQuantity);
	}

	public static void updateProduct(EntityManager entityManager, Product product,  Double newPrice, Integer newQuantity){
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		if( !entityTransaction.isActive() ){
//			entityTransaction.begin();
//		}


		//modifyPrice
		if( newPrice != null){
			product.setPrice(newPrice);
		}
		//modifyQuantity
		if( newQuantity != null){
			product.setQuantity(newQuantity);
		}
		entityManager.persist(product);
//		entityTransaction.commit();
	}
//
//	public static void addProduct(EntityManager entityManager, String name, String desc, Double price, Integer quantity, Integer rating ){
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//
//
//	}

	//TODO: OVERLOAD the method!
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

	public static List<Product> getAllProducts(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HopperWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
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



	public static boolean login(String email, String psw, EntityManager entityManager) {
		Query query = entityManager.createQuery("SELECT u FROM User as u");
		List<User> listaUsers = query.getResultList();
		for (int i = 0; i < listaUsers.size(); i++) {
			if (listaUsers.get(i).getEmail().equalsIgnoreCase(email) && listaUsers.get(i).getPassword().equals(psw)) {
				return true;
			}
		}
		return false;
	}

	public static boolean login(String email, String psw) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HopperWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM User as u");
		List<User> listaUsers = query.getResultList();
		for (int i = 0; i < listaUsers.size(); i++) {
			if (listaUsers.get(i).getEmail().equalsIgnoreCase(email) && listaUsers.get(i).getPassword().equals(psw)) {
				return true;
			}
		}
		return false;
	}

	public static User getUser(String userEmail) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HopperWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM User as u WHERE email=" + "'" + userEmail + "'");
		for (User user : (ArrayList<User>) query.getResultList()) {
			if (user.getEmail().equalsIgnoreCase(userEmail)) return user;
		}
		return null;
	}

	public static void addUser(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HopperWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}


}

