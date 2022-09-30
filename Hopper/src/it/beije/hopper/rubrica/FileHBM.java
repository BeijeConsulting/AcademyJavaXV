package it.beije.hopper.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.beije.hopper.Contatto;

public class FileHBM {
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		
		Session session = HBMsessionFactory.openSession();
		Scanner scanner = new Scanner(System.in);
		
		inserimento();

		String in = scanner.nextLine();

		LOOP: while (!in.equalsIgnoreCase("exit")) {

			if (in.equalsIgnoreCase("stampa")) {
				stampaDB();
			} else if (in.equalsIgnoreCase("aggiorna")) {
				System.out.println("Inserire id del contatto da aggiornare: ");
				String id = scanner.nextLine();
				updateDB(Integer.parseInt(id));
			} else if (in.equalsIgnoreCase("elimina")) {
				System.out.println("Inserire id del contatto da eliminare: ");
				String id = scanner.nextLine();
				removeDB(Integer.parseInt(id));
			} else if (in.equalsIgnoreCase("aggiungi")) {
				initializeWrite();
			} else if(in.equalsIgnoreCase("ricerca"))
					select();					
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

	public static void initializeWrite() throws IOException, SQLException {

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

			writeDB(contatti);
		}

		if (in.equals("n")) {
			File file = new File(
					"C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica.csv");
			initializeFile(file);
		}

	}

	public static void initializeFile(File file) throws IOException, SQLException {

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
				writeDB(contatti);
			}
			count++;
		}
		bufferedReader.close();
	}

	public static void writeDB(String[] contatti) {

		Session session = HBMsessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Contatto contatto = new Contatto();

		if (contatti.length == 4) {
			contatto.setCognome(contatti[1]);
			contatto.setNome(contatti[0]);
			contatto.setTelefono(contatti[3]);
			contatto.setEmail(contatti[2]);
			contatto.setNote(null);
			session.save(contatto);
			System.out.println("COGNOME: " + contatti[1] + ", NOME: " + contatti[0] + " EMAIL: " + contatti[2]
					+ " TELEFONO: " + contatti[3]);

		}

		if (contatti.length == 3) {
			contatto.setCognome(contatti[1]);
			contatto.setNome(contatti[0]);
			contatto.setTelefono(null);
			contatto.setEmail(contatti[2]);
			contatto.setNote(null);
			session.save(contatto);
			System.out.println("COGNOME: " + contatti[1] + ", NOME: " + contatti[0] + " EMAIL: " + contatti[2]);
		}

		if (contatti.length == 2) {
			contatto.setCognome(contatti[1]);
			contatto.setNome(contatti[0]);
			contatto.setTelefono(null);
			contatto.setEmail(null);
			contatto.setNote(null);
			session.save(contatto);
			System.out.println("COGNOME: " + contatti[1] + ", NOME: " + contatti[0]);
		}

		if (contatti.length == 1) {
			contatto.setCognome(null);
			contatto.setNome(contatti[0]);
			contatto.setTelefono(null);
			contatto.setEmail(null);
			contatto.setNote(null);
			session.save(contatto);
			System.out.println("NOME: " + contatti[0]);
		}

		transaction.commit();

		session.close();

	}

	public static void removeDB(int id) {

		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Scanner scanner = new Scanner(System.in);

		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();

		for (Contatto c : contatti) {
			if(c.getId()==id) {
				System.out.println("Sei sicuro di voler cancellare il contatto?(Scrivere y per dare conferma)");
				if (scanner.nextLine().toString().equalsIgnoreCase("y")) {
					session.remove(c);
					System.out.println("Contatto rimosso");
					break;
				}
			}
		}
		transaction.commit();
		session.close();
	}

	public static void updateDB(int id) {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();

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
		for (Contatto c : contatti) {
			if (c.getId() == id) {
				if (!nome.equals("")) {
					c.setNome(nome);
					count++;
				}
				if (!cognome.equals("")) {
					c.setCognome(cognome);
					count++;
				}
				if (!email.equals("")) {
					c.setEmail(email);
					count++;
				}
				if (!telefono.equals("")) {
					c.setTelefono(telefono);
					count++;
				}
				transaction.commit();
				session.save(c);
				break;
			}

		}

		if (count > 0)
			System.out.println("Modifiche effettuate");
		else
			System.out.println("Nessuna modifica effettuata");

		session.close();

	}

	public static void stampaDB() {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.getTransaction();

		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatto = query.getResultList();

		for (Contatto c : contatto) {
			System.out.println(c);
		}
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

	public static void select() {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Inserire la colonna da ricercare: Nome, cognome, email, telefono: ");
		String in=scanner.nextLine();
		
		Query<Contatto> query=null;
		
		if(in.equalsIgnoreCase("nome")) {
			System.out.print("\nInserire nome:");
			in=scanner.nextLine();
			query = session.createQuery("SELECT c FROM Contatto as c WHERE nome='" + in + "'");
		}
		else if(in.equalsIgnoreCase("cognome")) {
			System.out.print("\nInserire cognome:");
			in=scanner.nextLine();
			query = session.createQuery("SELECT c FROM Contatto as c WHERE cognome='" + in + "'");
		}
		else if(in.equalsIgnoreCase("email")) {
			System.out.print("\nInserire email:");
			in=scanner.nextLine();
			query = session.createQuery("SELECT c FROM Contatto as c WHERE email='" + in + "'");
		}
		else if(in.equalsIgnoreCase("telefono")) {
			System.out.print("\nInserire telefono:");
			in=scanner.nextLine();
			query = session.createQuery("SELECT c FROM Contatto as c WHERE telefono='" + in + "'");
		}
		
		List<Contatto> contatti = query.getResultList();

		for (Contatto c : contatti) {
			System.out.println(c);
		}
	}
}
