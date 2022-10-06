package it.beije.hopper.ecommercedecataldo;

//Libreria per apertura e chiusura connessione al db
import static it.beije.hopper.ecommerce.Cart.*;
import static it.beije.hopper.gestorerubrica.Utilities.*;

//Bean JPA
import it.beije.hopper.ecommerce.Cart;
import it.beije.hopper.ecommerce.Item;
import it.beije.hopper.ecommerce.Product;
import it.beije.hopper.ecommerce.User;

//Librerie JPA
import javax.persistence.*;

//Strutture utili per input e storage dati nel programma
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Ecommerce {
    static Scanner s;
    public static void main(String []args){
        //visualizzaProdottiDisponibili();
        /*Item prodotto=new Item();
        prodotto.setName("Arcibaldo");
        prodotto.setPrice(400.0);
        prodotto.setDesc("Un bel televisore, molto regale");
        prodotto.setQuantity(20);
        List<Item> carello= addInCart(prodotto);

        System.out.println(carello.toString());*/
        inserisciProdotto();
    }
    public static void visualizzaProdottiDisponibili(){
        //Connessione al DB e query
        Query query = connessioneDB("hopper").createQuery("SELECT c FROM Product AS c");//Connessione al DB e query
        //Salvataggio query in ArrayList di oggetti Product
        List<Product> prodotti = query.getResultList();//Esecuzione query
        //Stampa dei risultati
        System.out.print("Ecco i prodotti disponibii nel negozio");
        stampaRisultati(prodotti);
    }
    public static void inserisciProdotto(){ //INSERT nella tabella Product

        Product prodotto=new Product();
        s=new Scanner(System.in);

        System.out.println("Inserimento nuovo prodotto nell' e-commerce");
        System.out.print("Inserire il nome del prodotto\n");
        prodotto.setName(s.nextLine());// Settaggio campo name dell'oggetto prodotto
        System.out.println("Inserire la descrizione del prodotto");
        prodotto.setDesc(s.nextLine());// Settaggio campo desc dell'oggetto prodotto
        System.out.println("Inserire il prezzo del prodotto");
        prodotto.setPrice(Double.valueOf(s.nextLine()));// Settaggio campo price dell'oggetto prodotto
        System.out.println("Inserire la quantità del prodotto");
        prodotto.setQuantity(Integer.valueOf(s.nextLine()));// Settaggio campo quantity dell'oggetto prodotto
        s.close();

        prodotto.setRating(5);


        System.out.println("STAMPA DI DEBUG");
        System.out.println(prodotto.getName());
        System.out.println(prodotto.getDesc());
        System.out.println(prodotto.getPrice());
        System.out.println(prodotto.getQuantity());

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hopper");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(prodotto);
        entityTransaction.commit();

        System.out.println("Prodotto POST update : " + prodotto.getId());
        entityManager.close();
    }
    /*public static void aggiungiAlCarello(){

    }
    public static void creaOrdine(){

    }*/


}
