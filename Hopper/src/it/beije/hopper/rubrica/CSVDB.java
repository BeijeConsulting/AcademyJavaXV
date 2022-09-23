package it.beije.hopper.rubrica;

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

import it.beije.hopper.Contatto;
import it.beije.hopper.xml.parser.gruppo1.VostroOggettoDocumento;

public class CSVDB {
	
	public static final String QUERY_INSERT = "INSERT INTO rubrica (cognome, nome, telefono, email, note) VALUES (?, ?, ?, ?, ?)";

	public static List<Contatto> readRubrica(String path) {
		File file = new File(path);
		
		//System.out.println("file exists? " + file.exists());

		FileReader fileReader = null;
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		try {
			fileReader = new FileReader(file);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int c = 0;
			List<String> rows = new ArrayList<String>();
			while (bufferedReader.ready()) {
				rows.add(bufferedReader.readLine());
				//System.out.println("rows["+ c + "] " + rows.get(c++));
			}
			
			Contatto contatto = null;
			for (String row : rows) {
				
				String[] cols = row.split(";");

				
				contatto = new Contatto();
				contatto.setCognome(cols[0]);
				contatto.setNome(cols[1]);
				contatto.setTelefono(cols[2]);
				contatto.setEmail(cols[3]);
				contatto.setNote(cols[4]);
				/*System.out.println("COGNOME : " + contatto.getCognome());
				System.out.println("NOME : " + contatto.getNome());
				System.out.println("TELEFONO : " + contatto.getTelefono());
				System.out.println("EMAIL : " + contatto.getEmail());
				System.out.println("NOTE : " + contatto.getNote());
				*/
				contatti.add(contatto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException inner) {
				inner.printStackTrace();
			}
		}
		
		return contatti;
	}
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "FilippoBassani");
	}

	public static void main(String[] args) throws IOException {
		//List<Contatto> contatti = readRubrica("/Users/filippobassani/Desktop/csv/rubrica - tel.csv");
		FileWriter fileWriter = new FileWriter("/Users/filippobassani/Desktop/csv/rubrica - tel.csv");
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = RubricaJDBC.getConnection();

			System.out.println("connection open? " + !connection.isClosed());

			statement = connection.createStatement();

			//INSERT	
			/*preparedStatement = connection.prepareStatement(QUERY_INSERT);
			for (Contatto contatto : contatti) {
			preparedStatement.setString(1,contatto.getCognome());
			preparedStatement.setString(2, contatto.getNome());
			preparedStatement.setString(3, contatto.getTelefono());
			preparedStatement.setString(4, contatto.getEmail());
			preparedStatement.setString(5, contatto.getNote());
			preparedStatement.executeUpdate();
			}*/
			
			
			
			//UPDATE
			/*
			int r = statement.executeUpdate("UPDATE rubrica SET note = 'erano note' WHERE id < 10");
			System.out.println("updated rows : " + r);

			//DELETE
			r = statement.executeUpdate("DELETE FROM rubrica WHERE cognome = 'Roberta'");
			System.out.println("deleted rows : " + r);
			*/
			
			//SELECT
			rs = statement.executeQuery("SELECT * FROM rubrica");
			char sep = ';';
			while (rs.next()) {
				System.out.println("ID : " + rs.getInt("id"));
				System.out.println("COGNOME : " + rs.getString("cognome"));
				System.out.println("NOME : " + rs.getString("nome"));
				System.out.println("TELEFONO : " + rs.getString("telefono"));
				System.out.println("EMAIL : " + rs.getString("email"));
				System.out.println("NOTE : " + rs.getString("note"));
				
				
			
				
					fileWriter.write(rs.getString("cognome"));
					fileWriter.write(sep);
					fileWriter.write(rs.getString("nome"));
					fileWriter.write(sep);
					fileWriter.write(rs.getString("telefono"));
					fileWriter.write(sep);
					fileWriter.write(rs.getString("email"));
					fileWriter.write(sep);
					fileWriter.write(rs.getString("note"));
					fileWriter.write('\n');
			}

				fileWriter.flush();
				fileWriter.close();

			
				
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
	}	

	}

