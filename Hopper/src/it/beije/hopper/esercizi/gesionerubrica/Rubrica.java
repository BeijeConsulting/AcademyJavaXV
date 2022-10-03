package it.beije.hopper.esercizi.gesionerubrica;

import it.beije.hopper.Contatto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class Rubrica {

	private List<Contatto> contatti = new ArrayList<Contatto>();
	static String path = "C:/Users/emanu/Documents/Beije/workspace Java Beije/EsercitazioneFileXML/test_parser1.xml";
	String tecnology = "JPA";
	
	//Sezione MENU
	public void seeMenu() throws Exception  {
		
		switch(tecnology) {
		case "JPA": JPAEntityManager.getConnection(); break;
		}

		System.out.println("Scegli l'opzione da eseguire: ");
		
		Scanner s = new Scanner(System.in);
		String st = "";
		int scelta = 0;
		
		do {
			System.out.println("\n\n---MENU RUBRICA---");
			System.out.println("1) Lista contatti");
			System.out.println("2) Cerca Contatto");
			System.out.println("2) Crea nuovo contatto");
			System.out.println("3) Carica rubrica da fonti esterne");
			System.out.println("4) Esporta rubrica");
			System.out.println("5) Seleziona sorgente di default");
			System.out.println("6) Exit");
			System.out.println("7) Modifica contatto");
			System.out.print("Scelta: ");
			st = s.next();
			
			try {
			scelta = Integer.parseInt(st);
			}catch (NumberFormatException ENE){
				System.out.println("\nErrore: devi inserire un numero compreso nel menu");
			}
			
			switch(scelta) {
			case 1:
				System.out.println("\n\nStampa Rubrica---");
				System.out.println(" |Cognome | Nome | Telefono | Email");
				stampaRubrica();
				break;
			
			case 2:
				newContact();
				break;
				
			case 3:
				seeMenuImport();
				break;
				
			case 4:
				seeMenuExport();
				break;	
				
			case 5:
				System.out.println("\n\n---CERCA CONTATTO---");
				List<Contatto> contatti = cercaContatto();
				
				if( contatti != null)
				if( contatti.isEmpty() ) System.out.println("Non sono stati trovati contatti");
					else 
					stampaRubrica(contatti);
				break;
				
			case 7: 
				seeMenuModificaContatto();
				break;
				
			}
			
		}while(scelta != 6);
		
		System.out.println("BYE!!");
		s.close();
	}
	
	private void seeMenuImport() {
		Scanner s = new Scanner(System.in);
		String st = "";
		int scelta = 0;
		
		do {
			System.out.println("\n\n---CARICA RUBRICA DA FONTI ESTERNE---");
			System.out.println("1) Carica rubrica da DataBase Hopper");
			System.out.println("2) Carica rubrica da file XML");
			System.out.println("3) Carica rubrica da file CVS");
			System.out.println("4) Ritorna al menu principale");
			System.out.print("Scelta: ");
			st = s.next();
			
			try {
			scelta = Integer.parseInt(st);
			}catch (NumberFormatException ENE){
				System.out.println("\nErrore: devi inserire un numero compreso nel menu");
			}
			
			switch(scelta) {
			case 1:
				contatti = importFromHibernate();
				//contatti = importFromDataBase();
				break;
				
			case 2:
				contatti = GestioneFile.importFromXML();
				break;
				
			case 3:
				contatti = GestioneFile.importFromCSV();
				break;
			
			}
			
	
			//System.out.println(( (!contatti.isEmpty()) ^ (scelta != 4) ));
			//System.out.println(! ( (!contatti.isEmpty()) && (scelta == 4) ) );
			
		}while( scelta != 4   );
	}
	
	private void seeMenuExport() throws Exception {
		
		 Scanner s = new Scanner(System.in);
		 String st = "";
		 int scelta = 0;

		 do {
			 System.out.println("\n\n---CARICA RUBRICA DA FONTI ESTERNE---");
			 System.out.println("1) Esporta in formato XML");
			 System.out.println("2) Esporta in formato CSV");
			 System.out.println("3) Ritorna al menu principale");
			 System.out.print("Scelta: ");
			 st = s.next();

			 try {
				 scelta = Integer.parseInt(st);
			 }catch (NumberFormatException ENE){
				 System.out.println("\nErrore: devi inserire un numero compreso nel menu");
			 }

			 switch(scelta) {
			 
			 case 1:
				 GestioneFile.exportFromXML(contatti);
				 break;
			 
			 case 2: 
				 GestioneFile.exportFromCSV(contatti);
				 break;
			 }

		 }while(scelta != 3);
	}

	//Operazioni sui contatti
	private void newContact() throws Exception  {
		
		stampaRubrica();
		
		Scanner s = new Scanner(System.in);
		int scelta;
		Contatto newContact = new Contatto();
		
		System.out.println("Inserisci i dati relativi al nuovo contatto (se si vuole lasciare un campo vuoto inserire 'null')");
		
		System.out.print("Cognome: ");
		newContact.setCognome(s.next());
		
		System.out.print("Nome: ");
		newContact.setNome(s.next());
		
		System.out.print("Telefono: ");
		newContact.setTelefono(s.next());
		
		System.out.print("Email: ");
		newContact.setEmail(s.next());
		
		System.out.print("Note: ");
		newContact.setNote(s.next());
		
		do {
			System.out.println("\n\nSalvare questo contatto? 1)Si o 2)No");
			scelta =  getScelta();
			
			if(scelta == 1) {
				switch(tecnology) {
				case "DataBase":
					aggiungiContattoDataBase(newContact);
					break;
				
				case "XML":
					contatti.add(newContact);
					GestioneFile.exportFromXML(contatti);
					break;
				
				case "CSV":
					contatti.add(newContact);
					GestioneFile.exportFromCSV(contatti);
					break;
				
				case "JPA":
					GestioneConnessioniJPA.saveContact(newContact);
					break;
				}
			}
			
		}while(scelta == 0 || scelta > 2);
		
		riepilogoContatto(newContact);
		
		//switch(scelta)
		
	}
	
	private void riepilogoContatto(Contatto contatto) {
		System.out.println("Cognome: " + contatto.getCognome() );
		System.out.println("Nome: " + contatto.getNome() );
		System.out.println("Telefono: " + contatto.getTelefono() );
		System.out.println("Email: " + contatto.getEmail() );
		System.out.println("Note: " + contatto.getNote() );
	}
	
	private void riepilogoRicerca(Contatto contatto) {
		System.out.println("cognome: " + contatto.getCognome() + " | nome: " + contatto.getNome() + " | telefono: " + contatto.getTelefono() + " | email: " + contatto.getEmail() + " | note:  " + contatto.getNote()) ;
	}
	
	private void stampaRubrica() throws Exception {
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		switch(tecnology) {
		case "JPA":
			contatti = GestioneConnessioniJPA.getAllContacts();
			break;
		}
		
		if( !contatti.isEmpty() ) {
			for(Contatto contatto : contatti) {
				System.out.println("- " + contatto.getCognome() + " " + contatto.getNome() + " " + contatto.getTelefono() + " " + contatto.getEmail() );
			}
		}else {
			System.out.println("Rubrica vuota, caricare dati da fonti esterne");
		}
	}

	private void stampaRubrica(List<Contatto> contatti){
		
			if( !contatti.isEmpty() ) {
				for(Contatto contatto : contatti) {
					System.out.println("- " + contatto.getCognome() + " " + contatto.getNome() + " " + contatto.getTelefono() + " " + contatto.getEmail() );
				}
			}else {
				System.out.println("Rubrica vuota, caricare dati da fonti esterne");
			}
		}
		
	private List<Contatto> cercaContatto() {
		
		Contatto serchContact = new Contatto();
		List<Contatto> contatti = new ArrayList<>();
		int scelta = 0;
		Scanner s = new Scanner(System.in);
		String appoggio;
		
		do {
			if(scelta != 0) System.out.println("\n");
			System.out.println("Inserisci parametri di ricerca (per azzerare un campo basta selezionarlo e inserire la keyword null) ");
			System.out.println("Parametri di ricerca => cognome: " + serchContact.getCognome() + " | nome: " + serchContact.getNome() + " | telefono: " + serchContact.getTelefono() + " | email: " + serchContact.getEmail() + " | note:  " + serchContact.getNote());
			System.out.println("1)Cognome");
			System.out.println("2)Nome");
			System.out.println("3)Telefono");
			System.out.println("4)Email");
			System.out.println("5)Note");
			System.out.println("6)Avvia ricerca");
			System.out.println("7)Torna al menu principale");
			System.out.print("Scelta: ");
			scelta = getScelta();
			
			switch(scelta) {
			case 1:
				System.out.print("Cognome: ");
				appoggio = s.next();
				serchContact.setCognome( appoggio.compareToIgnoreCase("null") == 0 ? null : appoggio );
				break;
				
			case 2:
				System.out.print("Nome: ");
				appoggio = s.next();
				serchContact.setNome( appoggio.compareToIgnoreCase("null") == 0 ? null : appoggio );
				break;
				
			case 3:
				System.out.print("Telefono: ");
				appoggio = s.next();
				serchContact.setTelefono( appoggio.compareToIgnoreCase("null") == 0 ? null : appoggio );
				break;
				
			case 4:
				System.out.print("Email: ");
				appoggio = s.next();
				serchContact.setEmail( appoggio.compareToIgnoreCase("null") == 0 ? null : appoggio );
				break;
				
			case 5:
				System.out.print("Note: ");
				appoggio = s.next();
				serchContact.setNome( appoggio.compareToIgnoreCase("null") == 0 ? null : appoggio );
				break;
				
			case 6:
				switch(tecnology) {
				case "JPA":
					contatti = GestioneConnessioniJPA.searchContacts(serchContact);
					return contatti;
				}
		
			case 7:
				return null;
				
			}
			
		}while(scelta < 1 || scelta != 7);
		
		return null;
	}

	private void seeMenuModificaContatto() {
		System.out.println("\n\n---MODIFICA CONTATTO---");
		List<Contatto> contatti = cercaContatto();
		Contatto contact;
		
		if(contatti == null) return;
		
		if( !contatti.isEmpty() ) {
			
			int index = -1;
			int scelta = -1;
			
			do {
				System.out.println("\nSeleziona contatto da modificare");
				for(Contatto contatto : contatti) System.out.println(++index + ") cognome: " + contatto.getCognome() + " | nome: " + contatto.getNome() + " | telefono: " + contatto.getTelefono() + " | email: " + contatto.getEmail() + " | note:  " + contatto.getNote());
				System.out.println(contatti.size() + ") Torna al menu principale");
				System.out.print("Scelta: ");
				scelta = getScelta();
				
				if(scelta == contatti.size() ) return;
				
				if(scelta < 0) {
					System.out.println("\nErrore, inserire un valore positivo\n");
					continue;
				}
				
				modificaContatto( contatti.get(scelta) );


			}while(scelta < 0 || scelta != contatti.size());
			
		}else {
			System.out.println("Non ci sono contatti con queste caratteristiche");
		}
		
	}
	
	private void modificaContatto(Contatto contatto) {
	
		Contatto modifiedContact = contatto.returnCopy();
		int scelta = 0;
		String appoggio;
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("\nScegli i campi da modificare");
			System.out.println("1)Cognome");
			System.out.println("2)Nome");
			System.out.println("3)Telefono");
			System.out.println("4)Email");
			System.out.println("5)Note");
			System.out.println("6)Salva modifiche");
			System.out.println("7)Annulla modifiche");

			System.out.print("\nAttuale => ");
			riepilogoRicerca(contatto);

			System.out.print("Modifiche => ");
			riepilogoRicerca(modifiedContact);

			System.out.print("\nScelta: ");
			scelta = getScelta();
			System.out.println("\n");

			switch(scelta) {
			case 1:
				System.out.print("Cognome: ");
				appoggio = s.next();
				modifiedContact.setCognome( appoggio.compareToIgnoreCase("null") == 0 ? null : appoggio );
				break;

			case 2:
				System.out.print("Nome: ");
				appoggio = s.next();
				modifiedContact.setNome( appoggio.compareToIgnoreCase("null") == 0 ? null : appoggio );
				break;

			case 3:
				System.out.print("Telefono: ");
				appoggio = s.next();
				modifiedContact.setTelefono( appoggio.compareToIgnoreCase("null") == 0 ? null : appoggio );
				break;

			case 4:
				System.out.print("Email: ");
				appoggio = s.next();
				modifiedContact.setEmail( appoggio.compareToIgnoreCase("null") == 0 ? null : appoggio );
				break;

			case 5:
				System.out.print("Note: ");
				appoggio = s.next();
				modifiedContact.setNome( appoggio.compareToIgnoreCase("null") == 0 ? null : appoggio );
				break;
				
			case 6:
				GestioneConnessioniJPA.editContact(modifiedContact);
				break;

			case 7:
				return;
			}

		}while(scelta < 0 || scelta != 6);
		
		
		
		
	}
	
	//Gestione Rubrica DataBase JDBC
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "Marinelli1997");
	}

	private List<Contatto> importFromDataBase() {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		List<Contatto> contatti = new ArrayList<>();
		Contatto contatto;
		
		try {
			connection = Rubrica.getConnection();

			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM rubrica");
			
			//SELECT
			while (rs.next()) {
				contatto = new Contatto();
				contatto.setCognome( rs.getString("cognome") );
				contatto.setNome( rs.getString("nome") );
				contatto.setTelefono( rs.getString("telefono") );
				contatto.setEmail( rs.getString("email") );
				contatto.setNote( rs.getString("note") );
				contatti.add(contatto);
			}
			
			System.out.println("Rubrica caricata correttamente da DataBase. ");

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				//connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		
		return contatti;
	}

	private void aggiungiContattoDataBase(Contatto contatto) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		PreparedStatement insert = null;
		
		try {
			connection = Rubrica.getConnection();
			
			insert = connection.prepareStatement("INSERT INTO `hopper`.`rubrica` (`cognome`, `nome`, `telefono`, `email`, `note`) VALUES (?, ?, ?, ?, ?)");
			insert.setString(1, contatto.getCognome());
			insert.setString(2, contatto.getNome());
			insert.setString(3, contatto.getEmail());
			insert.setString(4, contatto.getTelefono());
			insert.setString(5, contatto.getNote());
			insert.executeUpdate();
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			//try {
				//rs.close();
				//statement.close();
				//connection.close();
			//} catch (SQLException sqlEx) {
				//sqlEx.printStackTrace();
		//	}
		}
	}
	
	//Gestione Rubrica Database Hibernate
	private List<Contatto> importFromHibernate() {
		Session session = HBMsessionFactory.opernSession();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
		List<Contatto> contatti = query.getResultList();
		return contatti;
	}
	
	//Metodi TOOLS
	public int getScelta() {
		Scanner s = new Scanner(System.in);
		String st = "";
		int scelta = 0;
		
		try {
			st = s.next();
			scelta = Integer.parseInt(st);
		}catch(NumberFormatException NFE) {
			System.out.println("Errore, ripetere l'operazione... PS: inserire un valore numerico positivo");
			scelta = 0;
		}
		
		return scelta;
	}

	
}