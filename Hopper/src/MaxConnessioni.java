import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.beije.hopper.rubrica.RubricaJDBC;

public class MaxConnessioni {
	
	static Connection connection = null;
		static Statement statement = null;
		static ResultSet rs = null;
		static PreparedStatement preparedStatement = null;
		
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int i = 1;
		
		while(true)
		{
			
			System.out.println("Connessione numero " + i);
			try {
				connection = RubricaJDBC.getConnection();
				System.out.println("connection open? " + !connection.isClosed());
				statement = connection.createStatement();


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
			i++;
		}

	}

}
