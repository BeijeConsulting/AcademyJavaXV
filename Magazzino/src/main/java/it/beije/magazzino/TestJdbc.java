package it.beije.magazzino;

import java.sql.Connection;
import java.sql.DriverManager;

///JUST USED FOR TESTING CONNECTION WITH DB TODO: DELETE FILE
public class TestJdbc {

	public static void main(String[] args) {
		 
		String jdbcUrl = "jdbc:mysql://localhost:3306/warehouse?useSSL=false";
		//String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user ="root";
		String pass = "beije";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!");



			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		

	}

}
