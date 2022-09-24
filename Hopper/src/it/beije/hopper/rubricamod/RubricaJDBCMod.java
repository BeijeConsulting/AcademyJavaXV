package it.beije.hopper.rubricamod;

import it.beije.hopper.Contatto;

import java.io.IOException;
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
		boolean writeToDB = true;

		List<Contatto> contatti = null;
		String path = null;
		if( writeToDB ){

			///READ CSV FILES (to DB)
			String pathToFileCSV =  "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy-pt2\\Hopper\\src\\it\\beije\\hopper\\testFile_CSV_XML\\rubrichecsv\\rubrica - test.csv";
			contatti = CSVmanagerMod.readRubrica(pathToFileCSV);
			System.out.println(contatti);
			System.out.println();

			//To be done
//			//XML FILES to DB
//			String pathToFile = "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy-pt2\\Hopper\\src\\it\\beije\\hopper\\testFile_CSV_XML\\xml\\test_parser.xml";
//			contatti = XMLmanagerMod.readRubricaXML(pathToFile);

		}else{
			path = "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy-pt2\\Hopper\\src\\it\\beije\\hopper\\rubricamod\\outputfiles\\csv\\output.cvs";
			contatti = new ArrayList<>();
			//System.out.println(contatti);
			try{
				CSVmanagerMod.writeRubrica(contatti, path);
			}catch(IOException ioe){
				System.out.println("There was a problem ");
				ioe.printStackTrace();
			}

		}





		
		try {
			connection = RubricaJDBCMod.getConnection();
			connectionClosed = !connection.isClosed();
			System.out.println("connection open? " + connectionClosed);

			statement = connection.createStatement();

			if( writeToDB ) {


				//INSERT
				preparedStatement = connection.prepareStatement(QUERY_INSERT);
				for (Contatto contatto : contatti) {
					preparedStatement.setString(2, contatto.getCognome() != null ? contatto.getCognome() : "");
					preparedStatement.setString(1, contatto.getNome() != null ? contatto.getNome() : "");
					preparedStatement.setString(3, contatto.getTelefono() != null ? contatto.getTelefono() : "");
					preparedStatement.setString(4, contatto.getEmail() != null ? contatto.getEmail() : "");
					preparedStatement.setString(5, contatto.getNote() != null ? contatto.getNote() : "");
					preparedStatement.executeUpdate();
				}


			}else {


				//SELECT
				rs = statement.executeQuery("SELECT * FROM rubrica");

				while (rs.next()) {

					Contatto contatto = new Contatto();
					contatto.setNome(rs.getString("nome"));
					contatto.setCognome(rs.getString("cognome"));
					contatto.setTelefono(rs.getString("telefono"));
					contatto.setEmail(rs.getString("email"));
					contatto.setNote(rs.getString("note"));
					contatti.add(contatto);
				}

				//Write CSV
				try {
					CSVmanagerMod.writeRubrica(contatti, path);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}

			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {

				if( rs != null ) rs.close();
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
