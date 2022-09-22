package it.beije.hopper.rubricamod;

import it.beije.hopper.Contatto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RubricaJDBCMod {
	
	public static final String QUERY_INSERT = "INSERT INTO rubrica (nome, cognome, telefono, email, note) VALUES (?, ?, ?, ?, ?)";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "beije");
	}



	public static void main(String[] args) {


		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		boolean connectionClosed = true;
		boolean read = false;
		List<Contatto> contatti = null;
		if( read ){
			///CSV FILES to DB
//			String pathToFileCSV =  "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy-pt2\\Hopper\\src\\it\\beije\\hopper\\testFile_CSV_XML\\rubrichecsv\\rubrica - test.csv";
//			contatti = CSVmanagerMod.readRubrica(pathToFileCSV);
//
//				XML FILES to DB
//			String pathToFile = "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy-pt2\\Hopper\\src\\it\\beije\\hopper\\testFile_CSV_XML\\xml\\test_parser.xml";
//			contatti = XMLmanagerMod.readRubricaXML(pathToFile);
		}else{
			String outPathCSV = "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy-pt2\\Hopper\\src\\it\\beije\\hopper\\rubricamod\\outputfiles\\csv\\output.cvs";
			contatti = new ArrayList<>();
//
//			try{
//				CSVmanagerMod.writeRubrica(contatti, outPathCSV);
//			}catch(IOException ioe){
//				System.out.println("There was a problem ");
//				ioe.printStackTrace();
//			}

		}





		
		try {
			connection = RubricaJDBCMod.getConnection();
			connectionClosed = !connection.isClosed();
			System.out.println("connection open? " + connectionClosed);

			statement = connection.createStatement();

			//INSERT
			preparedStatement = connection.prepareStatement(QUERY_INSERT);
			for( Contatto contatto : contatti ){
				preparedStatement.setString(2, contatto.getCognome());
				preparedStatement.setString(1, contatto.getNome());
				preparedStatement.setString(3, contatto.getTelefono());
				preparedStatement.setString(4, contatto.getEmail());
				preparedStatement.setString(5, contatto.getNote());
				preparedStatement.executeUpdate();
			}




//			//UPDATE
//			int r = statement.executeUpdate("UPDATE rubrica SET note = 'erano note' WHERE id < 10");
//			System.out.println("updated rows : " + r);
//
//			//DELETE
//			r = statement.executeUpdate("DELETE FROM rubrica WHERE cognome = 'Roberta'");
//			System.out.println("deleted rows : " + r);

			//SELECT
			rs = statement.executeQuery("SELECT * FROM rubrica");

			while (rs.next()) {
				//			System.out.println("ID : " + rs.getInt(1));
				//			System.out.println("COGNOME : " + rs.getString(2));
				//			System.out.println("NOME : " + rs.getString(3));
				//			System.out.println("TELEFONO : " + rs.getString(4));
				//			System.out.println("EMAIL : " + rs.getString(5));
				//			System.out.println("NOTE : " + rs.getString(6));


				System.out.print("ID : " + rs.getInt("id"));
				System.out.print (" | COGNOME : " + rs.getString("cognome"));
				System.out.print(" | NOME : " + rs.getString("nome"));
				System.out.print(" | TELEFONO : " + rs.getString("telefono"));
				System.out.print(" | EMAIL : " + rs.getString("email"));
				System.out.println(" | NOTE : " + rs.getString("note"));
			}	

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				connection.close();
				connectionClosed = connection.isClosed();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}finally{
				System.out.println("Connection closed? " + connectionClosed);
			}
		}

	}

}
