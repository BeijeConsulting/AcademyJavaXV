package it.beije.hopper.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import it.beije.hopper.Contatto;
import it.beije.hopper.Recapito;

public class FileCriteria {
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

		EntityManager entityManager = JPAEntityManagerFactory.openSession();
		Scanner scanner = new Scanner(System.in);

		inserimento();

		String in = scanner.nextLine();

		LOOP: while (!in.equalsIgnoreCase("exit")) {

			if (in.equalsIgnoreCase("stampa")) {
				stampaDB(entityManager);
			} else if (in.equalsIgnoreCase("aggiorna")) {
				System.out.println("Inserire id del contatto da aggiornare: ");
				String id = scanner.nextLine();
				updateDB(Integer.parseInt(id),entityManager);
			} else if (in.equalsIgnoreCase("elimina")) {
				System.out.println("Inserire id del contatto da eliminare: ");
				String id = scanner.nextLine();
				removeDB(Integer.parseInt(id),entityManager);
			} else if (in.equalsIgnoreCase("aggiungi")) {
				initializeWrite(entityManager);
			} else if (in.equalsIgnoreCase("ricerca"))
				select(entityManager);
			else {
				System.out.println("Inserimento non valido");
				inserimento();
				in = scanner.nextLine();
				continue LOOP;
			}
			System.out.println("");
			inserimento();
			in = scanner.nextLine();

		}
		System.out.println("Programma terminato!");
		scanner.close();

	}

	public static void initializeWrite(EntityManager entityManager) throws IOException, SQLException {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Se vuoi aggiungere elementi da tastiera digita y, inserire da file digita n: ");
		String in = scanner.nextLine();
		if (in.equals("y")) {

			System.out.println("OK , inserire i dati dell'utente");

			String[] contatti = new String[4];

			System.out.print("Inserire nome: ");
			in = scanner.nextLine();
			contatti[0] = in;
			System.out.println("");

			System.out.print("Inserire cognome: ");
			in = scanner.nextLine();
			contatti[1] = in;
			System.out.println("");

			System.out.print("Inserire email: ");
			in = scanner.nextLine();
			contatti[2] = in;
			System.out.println("");

			System.out.print("Inserire telefono: ");
			in = scanner.nextLine();
			contatti[3] = in;
			System.out.println("");

			System.out.println("Inserimento terminato...Aggiungo al database");

			writeDB(contatti,entityManager);

		}

		if (in.equals("n")) {
			File file = new File(
					"C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica.csv");
			initializeFile(file,entityManager);

		}

	}

	public static void initializeFile(File file,EntityManager entityManager) throws IOException, SQLException {

		FileReader fileReader = new FileReader(file);
		if (file.exists())
			System.out.println("Il file esiste");
		else
			System.out.println("Il file è stato creato");

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int count = 0;
		while (bufferedReader.ready() && count < 5) {
			String linea = bufferedReader.readLine();
			if (count >= 1) {
				String[] contatti = linea.split(";");
				writeDB(contatti,entityManager);
			}
			count++;
		}

		bufferedReader.close();
	}

	public static void writeDB(String[] contatti,EntityManager entityManager) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Contatto contatto = new Contatto();

		if (contatti.length == 4) {
			contatto.setCognome(contatti[1]);
			contatto.setNome(contatti[0]);
			contatto.setTelefono(contatti[3]);
			contatto.setEmail(contatti[2]);
			contatto.setNote(null);
			entityManager.persist(contatto);
			System.out.println("COGNOME: " + contatti[1] + ", NOME: " + contatti[0] + " EMAIL: " + contatti[2]
					+ " TELEFONO: " + contatti[3]);

		}

		if (contatti.length == 3) {
			contatto.setCognome(contatti[1]);
			contatto.setNome(contatti[0]);
			contatto.setTelefono(null);
			contatto.setEmail(contatti[2]);
			contatto.setNote(null);
			entityManager.persist(contatto);
			System.out.println("COGNOME: " + contatti[1] + ", NOME: " + contatti[0] + " EMAIL: " + contatti[2]);
		}

		if (contatti.length == 2) {
			contatto.setCognome(contatti[1]);
			contatto.setNome(contatti[0]);
			contatto.setTelefono(null);
			contatto.setEmail(null);
			contatto.setNote(null);
			entityManager.persist(contatto);
			System.out.println("COGNOME: " + contatti[1] + ", NOME: " + contatti[0]);
		}

		if (contatti.length == 1) {
			contatto.setCognome(null);
			contatto.setNome(contatti[0]);
			contatto.setTelefono(null);
			contatto.setEmail(null);
			contatto.setNote(null);
			entityManager.persist(contatto);
			System.out.println("NOME: " + contatti[0]);
		}

		entityTransaction.commit();
		entityManager.close();

	}

	public static void removeDB(int id,EntityManager entityManager) {

		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<Contatto> criteriaDelete = cb.createCriteriaDelete(Contatto.class);
		Root<Contatto> root = criteriaDelete.from(Contatto.class);

		entityManager.getTransaction().begin();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Sei sicuro di voler cancellare il contatto?(Scrivere y per dare conferma)");
		if (scanner.nextLine().toString().equalsIgnoreCase("y")) {
			criteriaDelete.where(cb.equal(root.get("id"), id));
			entityManager.createQuery(criteriaDelete).executeUpdate();
			System.out.println("Contatto rimosso");
		}

		entityManager.getTransaction().commit();
	}

	public static void updateDB(int id,EntityManager entityManager) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Contatto> criteriaUpdate = cb.createCriteriaUpdate(Contatto.class);
		Root<Contatto> root = criteriaUpdate.from(Contatto.class);

		entityManager.getTransaction().begin();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Inserire cosa voler modificare: (Se non verrà inserito nulla non vi saranno modifiche)");

		System.out.println("Nome: ");
		String nome = scanner.nextLine();

		System.out.println("Cognome: ");
		String cognome = scanner.nextLine();

		System.out.println("Email: ");
		String email = scanner.nextLine();

		System.out.println("Telefono: ");
		String telefono = scanner.nextLine();

		int count = 0;
		criteriaUpdate.where(cb.equal(root.get("id"),id));
		
		if (!nome.equals("")) {
			criteriaUpdate.set("nome", nome);
			count++;
		}
		if (!cognome.equals("")) {
			criteriaUpdate.set("cognome", cognome);
			count++;
		}
		if (!email.equals("")) {
			criteriaUpdate.set("email", email);
			count++;
		}
		if (!telefono.equals("")) {
			criteriaUpdate.set("telefono", telefono);
			count++;
		}

		if (count > 0)
			System.out.println("Modifiche effettuate");
		else
			System.out.println("Nessuna modifica effettuata");
		
		entityManager.createQuery(criteriaUpdate).executeUpdate();
		entityManager.getTransaction().commit();

	}

	public static void select(EntityManager entityManager) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Inserire la colonna da ricercare: Nome, cognome, email, telefono: ");
		String in = scanner.nextLine();

		Query query = null;

		if (in.equalsIgnoreCase("nome")) {
			System.out.print("\nInserire nome:");
			in = scanner.nextLine();
			query = entityManager.createQuery("SELECT c FROM Contatto as c WHERE nome='" + in + "'");
		} else if (in.equalsIgnoreCase("cognome")) {
			System.out.print("\nInserire cognome:");
			in = scanner.nextLine();
			query = entityManager.createQuery("SELECT c FROM Contatto as c WHERE cognome='" + in + "'");
		} else if (in.equalsIgnoreCase("email")) {
			System.out.print("\nInserire email:");
			in = scanner.nextLine();
			query = entityManager.createQuery("SELECT c FROM Contatto as c WHERE email='" + in + "'");
		} else if (in.equalsIgnoreCase("telefono")) {
			System.out.print("\nInserire telefono:");
			in = scanner.nextLine();
			query = entityManager.createQuery("SELECT c FROM Contatto as c WHERE telefono='" + in + "'");
		}

		List<Contatto> contatti = query.getResultList();

		for (Contatto c : contatti) {
			System.out.println(c);

		}

		entityTransaction.commit();
		entityManager.close();
	}

	public static void stampaDB(EntityManager entityManager) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
		cr.from(Contatto.class);
		Query query = entityManager.createQuery(cr);
		System.out.println(query.getResultList());

		
	}

	public static void inserimento() {

		System.out.println("Inserire cosa voler fare: ");
		System.out.println("Per stampare il Database digitare stampa");
		System.out.println("Per aggiornare il Database digitare aggiorna");
		System.out.println("Per eliminare un contatto dal Database digitare elimina");
		System.out.println("Per aggiungere un contatto nel Database digitare aggiungi");
		System.out.println("Per ricercare contatti nel Database digitare ricerca");
		System.out.println("Per uscire digitare exit");
	}
}
