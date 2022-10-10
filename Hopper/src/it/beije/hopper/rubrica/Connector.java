package it.beije.hopper.rubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Connector {
	
	private Connector() {}
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "iannaroot");
	}
	
	private static final int n = 10;
	private static Connection[] connections = new Connection[n];
	
	public static Connection getAvailableConnection() throws ClassNotFoundException, SQLException {
			
		for (int i = 0; i < n; i++) {
			if (connections[i] == null || connections[i].isClosed()) {
				connections[i] = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "iannaroot");
				
				System.out.println("return " + i);
				
				return connections[i];
			}
		}
		
		//return null;
		throw new SQLException("connessione non disponibile");
	}

}
