package it.beije.hopper.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;


public class JDBCMetodi {
	
	
	
		static Connection connection = null;
		static Statement statement = null;
		static ResultSet rs = null;
		static PreparedStatement preparedStatement = null;
		public static final String QUERY_INSERT = "INSERT INTO rubrica (nome, cognome, telefono, email, note) VALUES (?,?,?,?,?)";
		static String pathFile = "C:\\Users\\caste\\OneDrive\\Desktop\\BeijeAcademy\\Rubrica\\RubricaScanner\\rubrica.csv";
		static File file = new File(pathFile);
		
		
		public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "cavagna");
		}
	
		public static void main(String[] args) throws IOException {
			
			
			FileReader fileReader = new FileReader(pathFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		try {
			connection = RubricaJDBC.getConnection();
			System.out.println("connection open? " + !connection.isClosed());
			statement = connection.createStatement();

			//writeDB();
			//readFromDB();
			//writeDBtoCSV();
			//writeCSVtoDB();

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				try {
					statement.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

	}
	
	public static void writeDB()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserire Nome: ");		
		String nome = scanner.nextLine();
		
		System.out.println("Inserire Cognome: ");
		String cognome = scanner.nextLine();
		
		System.out.println("Inserire Telefono: ");
		String telefono = scanner.nextLine();
		
		System.out.println("Inserire Email: ");
		String email = scanner.nextLine();
		
		System.out.println("Inserire Note: ");
		String note = scanner.nextLine();
		
		System.out.println(nome+cognome+email+telefono+note);
		try {
			preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, cognome);
			preparedStatement.setString(2, nome);
			preparedStatement.setString(3, telefono);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, note);
			preparedStatement.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
	}
	
	public static void readFromDB() throws SQLException
	{
		rs = statement.executeQuery("SELECT * FROM rubrica");

		while (rs.next()) {

			System.out.println("ID: " + rs.getInt("id"));
			System.out.println("COGNOME: " + rs.getString("cognome"));
			System.out.println("NOME: " + rs.getString("nome"));
			System.out.println("TELEFONO: " + rs.getString("telefono"));
			System.out.println("EMAIL: " + rs.getString("email"));
			System.out.println("NOTE: " + rs.getString("note"));
		}	
	}
	
	public static void writeDBtoCSV() throws IOException, SQLException
	{
		FileWriter fileWriter = new FileWriter(file);
		rs = statement.executeQuery("SELECT * FROM rubrica");
		while (rs.next())
		{
			
			StringBuilder s = new StringBuilder();
			s.append(rs.getString("cognome")).append(rs.getString("nome")).append(rs.getString("telefono")).append(rs.getString("email")).append(rs.getString("note")).append("\n");
			String str = s.toString();
			fileWriter.write(str);
			
		}
		fileWriter.flush();
	}
	
	public static void writeCSVtoDB() throws SQLException, IOException
	{
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String[] arr = null;
		
		rs = statement.executeQuery("SELECT * FROM rubrica");

		while (rs.next()) {

			while (bufferedReader.ready())
		{			
			String linea = bufferedReader.readLine();
			arr = linea.split(";");
			
			try {
				preparedStatement = connection.prepareStatement(QUERY_INSERT);
				preparedStatement.setString(1, arr[1]);		//invertiti perchè mi sono sbagliato sopra
				preparedStatement.setString(2, arr[0]);		//
				preparedStatement.setString(3, arr[2]);
				preparedStatement.setString(4, arr[3]);
				preparedStatement.setString(5, arr[4]);
				preparedStatement.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
	}	
		
		
		
	}

}
