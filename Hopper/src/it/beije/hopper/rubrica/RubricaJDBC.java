package it.beije.hopper.rubrica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RubricaJDBC {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "beije");
	}

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			connection = RubricaJDBC.getConnection();

			System.out.println("connection open? " + !connection.isClosed());

			statement = connection.createStatement();

			//INSERT
			String cognome = "Verdi";
			String nome = "Pippo";
			statement.executeUpdate("INSERT INTO rubrica VALUES (null, '" + cognome + "', '" + nome + "', '325235252', 'r.bianchi@beije.it', 'ciao ciao')");

			//UPDATE
			int r = statement.executeUpdate("UPDATE rubrica SET note = 'erano note' WHERE id < 10");
			System.out.println("updated rows : " + r);

			//DELETE
			r = statement.executeUpdate("DELETE FROM rubrica WHERE cognome = 'Roberta'");
			System.out.println("deleted rows : " + r);

			//SELECT
			rs = statement.executeQuery("SELECT * FROM rubrica");

			while (rs.next()) {
				//			System.out.println("ID : " + rs.getInt(1));
				//			System.out.println("COGNOME : " + rs.getString(2));
				//			System.out.println("NOME : " + rs.getString(3));
				//			System.out.println("TELEFONO : " + rs.getString(4));
				//			System.out.println("EMAIL : " + rs.getString(5));
				//			System.out.println("NOTE : " + rs.getString(6));

				System.out.println("ID : " + rs.getInt("id"));
				System.out.println("COGNOME : " + rs.getString("cognome"));
				System.out.println("NOME : " + rs.getString("nome"));
				System.out.println("TELEFONO : " + rs.getString("telefono"));
				System.out.println("EMAIL : " + rs.getString("email"));
				System.out.println("NOTE : " + rs.getString("note"));
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
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

	}

}
