package it.beije.hopper.web.ecommerce;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class GestoreEcommerce {

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        EntityManager entityManager = JPAEntityManager.getConnection();
        login();
    }

    static private void addUser() {
    	 EntityManager entityManager = JPAEntityManager.getConnection();

        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();

        User user = new User();
        Scanner scanner = new Scanner(System.in);

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

    static private void addProduct() {
    	 EntityManager entityManager = JPAEntityManager.getConnection();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Product product = new Product();
        Scanner scanner = new Scanner(System.in);

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

    static private void order(int id) {
    	 EntityManager entityManager = JPAEntityManager.getConnection();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Order order = new Order();

        //Dato che la tabella è piccola faccio questa stampa in modo da facilitare l'acquisto
        stampaProdotti();

        List<Product> carrello = new ArrayList<>();

        Scanner scanner=new Scanner(System.in);
        System.out.println("Digitare id del prodotto che si vuole comprare oppure digitare exit per uscire: ");
        String in = scanner.nextLine();

        while(!in.equalsIgnoreCase("exit")) {
            Product product = entityManager.find(Product.class, Integer.parseInt(in));
            if(product.getQuantity() <= 0) {
                System.out.println("Il prodotto è esaurito!");
            }
            else {
                System.out.println("Prodotto selezionato: " + product.getName() + "\n\nDigitare 1 per aggiungerlo al carrello o 0 per non aggiungerlo: ");
                if(scanner.nextLine().equalsIgnoreCase("1")) {
                    carrello.add(product);
                    System.out.println("Prodotto aggiunto al carrello!");
                    product.setQuantity(product.getQuantity()-1);
                }
            }

            System.out.println("\nDigitare 1 se si desidera aggiungere altri prodotti o 0 altrimenti: ");
            if(scanner.nextLine().equalsIgnoreCase("1")) {
                stampaProdotti();
                System.out.println("Digitare id del prodotto che si vuole comprare oppure digitare exit per uscire: ");
                in=scanner.nextLine();
            }else {
                in = "exit";
            }
        }


        double amount = 0;
        LocalDateTime localDateTime=LocalDateTime.now();

        if(carrello.size() > 0) {
            System.out.println("Il tuo carrello:");
            for(int i=0; i<carrello.size(); i++) { //
                System.out.println(carrello.get(i));
            }
            System.out.println("\nDigitare 1 per procedere con il pagamento o 0 altrimenti");

            if(scanner.nextLine().equalsIgnoreCase("1")) {
                for(int i=0; i<carrello.size(); i++) {
                    amount += carrello.get(i).getPrice();

                }
                order.setUserId(id);
                order.setDatetime(localDateTime);
                order.setAmount(amount);
                order.setPromo(null);
                entityManager.persist(order);
                transaction.commit();
                entityManager.close();
                orderItems(order, carrello);
                System.out.println("Ordine effettuato");

            }
            else{
                for(int i=0; i<carrello.size(); i++)
                    carrello.get(0).setQuantity(carrello.get(0).getQuantity()+1);
            }
        }

        entityManager.close();
    }

    static private void orderItems(Order order, List<Product> product) {
    	 EntityManager entityManager = JPAEntityManager.getConnection();
        EntityTransaction transaction=entityManager.getTransaction();

        Item item;
        LOOP:for(int i=0; i<product.size(); i++) {
            transaction.begin();

            if(i!=0)
                for(int j=i-1; j>=0; j--) {

                    if(product.get(i).getId() == product.get(j).getId()) {
                        Query query = entityManager.createQuery("SELECT i FROM Item i WHERE i.name='"+order.getId()+""+product.get(i).getId()+"'");
                        Item items = (Item)query.getResultList().get(0);
                        items.setQuantity(items.getQuantity()+1);
                        items.setPrice(items.getPrice()+product.get(i).getPrice());
                        entityManager.persist(items);
                        transaction.commit();
                        continue LOOP;
                    }
                }

            item=new Item();
            item.setOrderId(order.getId());
            item.setProductId(product.get(i).getId());
            item.setName(order.getId()+" "+product.get(i).getId());
            item.setPrice(product.get(i).getPrice());
            item.setDesc(product.get(i).getDesc());
            item.setQuantity(1);
            entityManager.persist(item);
            transaction.commit();
        }

        entityManager.close();

    }

    static private void login() {

    	EntityManager entityManager = JPAEntityManager.getConnection();
        EntityTransaction transaction=entityManager.getTransaction();

        transaction.begin();

        Scanner scanner = new Scanner(System.in);
        String email;
        String password;

        System.out.println("Benvenuto, inserire email e password:");
        System.out.print("Email: ");
        email=scanner.nextLine();
        System.out.print("Password: ");
        password=scanner.nextLine();

        Query query=entityManager.createQuery("SELECT u FROM User AS u WHERE u.email='"+email+"' AND u.password='"+password+"'");
        User user=(User)query.getResultList().get(0);
        if(user!=null) {
            System.out.println("Login avvenuto con successo!");
            System.out.println("Per effettuare un ordine digita 1, altrimenti digita 0");
            if(scanner.nextLine().equalsIgnoreCase("1"))
                order(user.getId());
        }
    }

    static private void stampaProdotti() {

    	 EntityManager entityManager = JPAEntityManager.getConnection();

        Query query=entityManager.createQuery("SELECT p FROM Product as p");
        List<Product> product=query.getResultList();
        if(product == null) System.out.println("Null");
        if(product.get(0) == null) System.out.println("Null");

        for(Product u: product)
            System.out.println(u);
    }
}