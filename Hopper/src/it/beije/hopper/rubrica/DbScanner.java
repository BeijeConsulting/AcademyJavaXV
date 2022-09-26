package it.beije.hopper.rubrica;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import it.beije.hopper.Contatto;

public class DbScanner {
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "FilippoBassani");
	}

	
	
	
	public static void main(String[] args) throws IOException {		

		
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = RubricaJDBC.getConnection();

			System.out.println("connection open? " + !connection.isClosed());

			
			//SCANNER
			System.out.println("Premi 'I' per inserire, 'U' per modificare, 'D' per cancellare, 'S' per vedere il db,");
			System.out.println("'Dup' per vedere i duplicati, 'C' per cercare il contatto, 'Un' per unire i duplicati");

			Scanner modifiche = new Scanner(System.in);
			String st = modifiche.next();
			
			statement = connection.createStatement();

		
			
			
			
			
			
			//INSERT
			if(st.equals("I")) {
				System.out.println("inserisci i dati");
				Scanner insert = new Scanner(System.in);
				System.out.print("Cognome: ");
				String cognome= insert.nextLine();
				System.out.print("Nome: ");
				String nome= insert.nextLine();
				System.out.print("Telefono: ");
				String telefono= insert.nextLine();
				System.out.print("Email: ");
				String email= insert.nextLine();
				System.out.print("Note: ");
				String note= insert.nextLine();
				
				statement.executeUpdate("INSERT INTO rubrica VALUES (null,'" + cognome + "', '" + nome + "', '" + telefono + "', '" + email + "', '" + note + "')");
				//CHIUSURA SCANNER
				insert.close();
			}
			
			
		//UPDATE
			if(st.equals("U")) {
				System.out.println("inserisci id della persona che vuoi modificare");
				Scanner update = new Scanner(System.in);
				String id= update.nextLine();
				System.out.println("cosa vuoi modificare? (C, N, T, E, Note)");
				String cosa= update.nextLine();
				
				switch(cosa) {
				case "C":	System.out.println("Cognome: ");
							String cognome= update.nextLine();	
							int c = statement.executeUpdate("UPDATE rubrica SET cognome = '"+ cognome +"' WHERE id ='"+ id +"'");
				
				case "N": 	System.out.println("Nome: ");
							String nome= update.nextLine();	
							int n = statement.executeUpdate("UPDATE rubrica SET nome = '"+ nome +"' WHERE id ='"+ id +"'");
				
				case "T":	System.out.println("Telefono: ");
							String telefono= update.nextLine();	
							int t = statement.executeUpdate("UPDATE rubrica SET telefono = '"+ telefono +"' WHERE id ='"+ id +"'");
				
				case "E": 	System.out.println("Email: ");
							String email= update.nextLine();	
							int e = statement.executeUpdate("UPDATE rubrica SET email = '"+ email +"' WHERE id ='"+ id +"'");
				
				case "Note": 	System.out.println("Note: ");
								String note= update.nextLine();	
								int not = statement.executeUpdate("UPDATE rubrica SET note = '"+ note +"' WHERE id ='"+ id +"'");
				}
				update.close();
			}
			
			
			
			
		//DELETE
			if(st.equals("D")) {
				System.out.println("inserisci i parametri di ricerca per i record che vuoi eliminare");
				Scanner delete = new Scanner(System.in);
				System.out.print("Cognome: ");
				String cognome= delete.nextLine();
				System.out.print("Nome: ");
				String nome= delete.nextLine();
				System.out.print("Telefono: ");
				String telefono= delete.nextLine();
				System.out.print("Email: ");
				String email= delete.nextLine();
				System.out.print("Note: ");
				String note= delete.nextLine();
				 int del = statement.executeUpdate("DELETE FROM rubrica WHERE cognome = '" + cognome + "' OR nome = '" + nome + "' OR telefono = '" + telefono + "'OR email = '" + email + "' OR note = '" + note + "'  ");
			
				delete.close();
			}

			
			
			
			
			
			//SELECT
			if(st.equals("S")) {
				System.out.println("Ordinati per nome o cognome? 'N', 'C'");
				Scanner ordine = new Scanner(System.in);
				String or= ordine.nextLine();
				switch(or) {
				
				case "N": rs = statement.executeQuery("SELECT * FROM rubrica ORDER BY nome");
				break;
				
				case "C": rs = statement.executeQuery("SELECT * FROM rubrica ORDER BY cognome");
				break;
				
				default: rs = statement.executeQuery("SELECT * FROM rubrica");
				break;
				}

			while (rs.next()) {
				System.out.println("ID : " + rs.getInt("id"));
				System.out.println("COGNOME : " + rs.getString("cognome"));
				System.out.println("NOME : " + rs.getString("nome"));
				System.out.println("TELEFONO : " + rs.getString("telefono"));
				System.out.println("EMAIL : " + rs.getString("email"));
				System.out.println("NOTE : " + rs.getString("note"));
			}		
			}
			
			//CERCA CONTATTO
			if(st.equals("C")) {
				System.out.println("inserisci i parametri di ricerca");
				Scanner cerca = new Scanner(System.in);	
				System.out.print("Cognome: ");
				String cognome= cerca.nextLine();
				System.out.print("Nome: ");
				String nome= cerca.nextLine();
				System.out.print("Telefono: ");
				String telefono= cerca.nextLine();
				System.out.print("Email: ");
				String email= cerca.nextLine();
				System.out.print("Note: ");
				String note= cerca.nextLine();
				ResultSet cer = statement.executeQuery("SELECT * FROM rubrica WHERE cognome = '" + cognome + "' OR nome = '" + nome + "' OR telefono = '" + telefono + "'OR email = '" + email + "' OR note = '" + note + "'");
				while (cer.next()) {
					System.out.println("ID : " + cer.getInt("id"));
					System.out.println("COGNOME : " + cer.getString("cognome"));
					System.out.println("NOME : " + cer.getString("nome"));
					System.out.println("TELEFONO : " + cer.getString("telefono"));
					System.out.println("EMAIL : " + cer.getString("email"));
					System.out.println("NOTE : " + cer.getString("note"));
				}
				cerca.close();
			}
			
			
			// DUPLICATI
			if(st.equals("Dup")) {
				 ResultSet dup = statement.executeQuery("Select cognome, nome, telefono, email, note, count(*) FROM rubrica GROUP BY cognome, nome, telefono, email, note  HAVING count(*)>1 ");
				
				 while (dup.next()) {
						System.out.print(dup.getString("cognome"));
						System.out.print(" " + dup.getString("nome"));
						System.out.print(" " + dup.getString("telefono"));
						System.out.print(" " + dup.getString("email"));
						System.out.println(" " + dup.getString("note"));
					}
				 
			}
			
			
			//UNISCI I DUPLICATI
			if(st.equals("Un")) {
				ResultSet un = statement.executeQuery(" SELECT DISTINCT cognome, nome, telefono, email, note FROM rubrica ");	
				 while (un.next()) {
						System.out.print(un.getString("cognome"));
						System.out.print(" " + un.getString("nome"));
						System.out.print(" " + un.getString("telefono"));
						System.out.print(" " + un.getString("email"));
						System.out.println(" " + un.getString("note"));
					}
			}
			
			
			
			//CHIUSURA SCANNER
			modifiche.close();

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				//rs.close();
				statement.close();
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
	}
}
