package it.beije.hopper.rubricamod;

import it.beije.hopper.Contatto;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RubricaJDBCMod {
	
	//public static final String QUERY_INSERT = "INSERT INTO rubrica (nome, cognome, telefono, email, note) VALUES (?, ?, ?, ?, ?)";

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


		List<Contatto> contatti = null;
		String path = null;
		Scanner scanner = new Scanner(System.in);

		boolean writeToDB = false;


		//File manager
		if( writeToDB ){ //FILE TO DB

			///READ CSV FILES (to DB)
//			String pathToFileCSV =  "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy\\Hopper\\src\\it\\beije\\hopper\\testFile_CSV_XML\\rubrichecsv\\rubrica - test.csv";
//			contatti = CSVmanagerMod.readRubrica(pathToFileCSV);
//			System.out.println(contatti);
//			System.out.println();


//			//XML FILES to DB
//			String pathToFile = "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy-pt2\\Hopper\\src\\it\\beije\\hopper\\testFile_CSV_XML\\xml\\test_parser.xml";
//			contatti = XMLmanagerMod.readRubricaXML(pathToFile);

		}else{//DB to FILE

			path = "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy\\Hopper\\src\\it\\beije\\hopper\\testFile_CSV_XML\\rubrichecsv\\output\\output.cvs";
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

			if( writeToDB ) { //Write/Update DB


				//INSERT

				preparedStatement = connection.prepareStatement("INSERT INTO rubrica (nome, cognome, telefono, email, note) VALUES (?, ?, ?, ?, ?)");
				//insertToDBFromCLI(preparedStatement, scanner );


				//Update
				;





				//FILE to db
//				for (Contatto contatto : contatti) {
//					preparedStatement.setString(2, contatto.getCognome() != null ? contatto.getCognome() : "");
//					preparedStatement.setString(1, contatto.getNome() != null ? contatto.getNome() : "");
//					preparedStatement.setString(3, contatto.getTelefono() != null ? contatto.getTelefono() : "");
//					preparedStatement.setString(4, contatto.getEmail() != null ? contatto.getEmail() : "");
//					preparedStatement.setString(5, contatto.getNote() != null ? contatto.getNote() : "");
//					preparedStatement.executeUpdate();
//				}


			}else {// READ FROM DB

				System.out.println("Extracting from DB");
				//terminal
				//SELECT
				contatti = selectFromDbFromCLI(statement, scanner);

//				//SELECT
//				rs = statement.executeQuery("SELECT * FROM rubrica WHERE nome='Baglio'");
////				System.out.println(rs.getString());
//				while (rs.next()) {
//
//					Contatto contatto = new Contatto();
//					contatto.setId(rs.getInt("id"));
//					contatto.setNome(rs.getString("nome"));
//					contatto.setCognome(rs.getString("cognome"));
//					contatto.setTelefono(rs.getString("telefono"));
//					contatto.setEmail(rs.getString("email"));
//					contatto.setNote(rs.getString("note"));
//					System.out.println("Contatto :" + contatto);
//					//contatti.add(contatto);
//				}

//				//Write CSV
//				try {
//					CSVmanagerMod.writeRubrica(contatti, path);
//				} catch (IOException ioe) {
//					ioe.printStackTrace();
//				}

			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				connection.close();
				connectionClosed = connection.isClosed();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}finally{
				System.out.println("Connection closed? " + connectionClosed);
			}
		}

	}





//			//DELETE
//			r = statement.executeUpdate("DELETE FROM rubrica WHERE cognome = 'Roberta'");
//			System.out.println("deleted rows : " + r);

	//terminal
	//Update
	public static void updateDBFromCLI(Statement statement, Scanner scanner) throws SQLException{

//			//UPDATE
//			int r = statement.executeUpdate("UPDATE rubrica SET note = 'erano note' WHERE id < 10");
//			System.out.println("updated rows : " + r);
		StringBuilder query = new StringBuilder("UPDATE rubrica SET");
		System.out.println();

	}

	//terminal
	//SELECT
	public static ArrayList<Contatto> selectFromDbFromCLI(Statement statement, Scanner scanner){
		ArrayList<Contatto> contatti = new ArrayList<>();
		// (nome, cognome, telefono, email, note)
		StringBuilder query = new StringBuilder("SELECT * FROM rubrica WHERE ");

		System.out.println("Are you looking by 'name', 'surname', 'phone number' or 'email' (Empty will show all the table's contents)?");
		String userIn = scanner.nextLine();
		if( userIn.equalsIgnoreCase("name")){
			System.out.print("Enter name: ");
			query.append(" nome=" +  "'"+scanner.nextLine()+ "'");
		}else if( userIn.equalsIgnoreCase("surname") ){
			System.out.print("Enter surname: ");
			query.append(" cognome=" + "'"+scanner.nextLine()+ "'");
		}else if( userIn.equalsIgnoreCase("phone number") ){
			System.out.print("Enter telefono: ");
			query.append(" telefono=" + "'"+scanner.nextLine()+ "'");
		}else if( userIn.equalsIgnoreCase("email") ){
			System.out.print("Enter email: ");
			query.append(" email=" + "'"+scanner.nextLine()+ "'");
		}else{
			query = new StringBuilder("SELECT * FROM rubrica");
		}


		ResultSet  rs = null;
		try{
			rs = statement.executeQuery(query.toString());
			while( rs.next() ){
				Contatto contatto = new Contatto();
				contatto.setId(rs.getInt("id"));
				contatto.setNome(rs.getString("nome"));
				contatto.setCognome(rs.getString("cognome"));
				contatto.setEmail(rs.getString("email"));
				contatto.setNote(rs.getString("note"));
				contatto.setTelefono(rs.getString("telefono"));
				contatti.add(contatto);
			}
			//System.out.println(contatti);

		}catch(SQLException sqlE ){
			try{
				rs.close();
				statement.close();
			}catch(SQLException sqlEinner ){
				sqlEinner.getMessage();
				sqlEinner.printStackTrace();
			}

		}



		return contatti.size() > 0 ?  contatti: null;

	}





	//terminal
	//INSERT to DB
	public static void insertToDBFromCLI(PreparedStatement preparedStatement, Scanner scanner) throws SQLException{
//		Contatto contatto = new Contatto();
//		System.out.println("Name: ");
//		contatto.setNome( scanner.nextLine() );
//		System.out.println("Surname: ");
//		contatto.setCognome(scanner.nextLine());
//		System.out.println("Phone number: ");
//		contatto.setTelefono(scanner.nextLine());
//		System.out.println("email: ");
//		contatto.setEmail(scanner.nextLine());
//		System.out.println("note: ");
//		//ToDo; while.... has next line ecc...
//		contatto.setNote(scanner.nextLine());
//
//		preparedStatement.setString(2, contatto.getCognome() != null ? contatto.getCognome() : "");
//		preparedStatement.setString(1, contatto.getNome() != null ? contatto.getNome() : "");
//		preparedStatement.setString(3, contatto.getTelefono() != null ? contatto.getTelefono() : "");
//		preparedStatement.setString(4, contatto.getEmail() != null ? contatto.getEmail() : "");
//		preparedStatement.setString(5, contatto.getNote() != null ? contatto.getNote() : "");
//		preparedStatement.executeUpdate();


		// (nome, cognome, telefono, email, note)
		System.out.print("Name: ");
		preparedStatement.setString(2, scanner.nextLine() );

		System.out.print("Surname: ");
		preparedStatement.setString(1, scanner.nextLine());

		System.out.print("Phone number: ");
		preparedStatement.setString(3, scanner.nextLine());

		System.out.print("Email: ");
		preparedStatement.setString(4, scanner.nextLine());

		System.out.print("Note: ");
		preparedStatement.setString(5, scanner.nextLine());
		preparedStatement.executeUpdate();


	}

}
