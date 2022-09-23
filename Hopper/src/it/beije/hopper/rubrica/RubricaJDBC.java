package it.beije.hopper.rubrica;


import java.sql.*;

public class RubricaJDBC {

	public static final String QUERY_INSERT = "INSERT INTO rubrica (nome, cognome, telefono, email, note) VALUES (?, ?, ?, ?, ?)";


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");


        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "Andrea1.");
    }


    public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = Connector.getAvailableConnection();

			System.out.println("connection : " + connection);
			System.out.println("connection open? " + !connection.isClosed());

			statement = connection.createStatement();

			//INSERT
			String cognome = "Verdi";
			String nome = "Pippo";
			//statement.executeUpdate("INSERT INTO rubrica VALUES (null, '" + cognome + "', '" + nome + "', '325235252', 'r.bianchi@beije.it', 'ciao ciao')");
			preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, cognome);
			preparedStatement.setString(2, nome);
			preparedStatement.setString(3, "12412412");
			preparedStatement.setString(4, "l@l.it");
			preparedStatement.setString(5, "addio");
			preparedStatement.executeUpdate();

//			//UPDATE
//			int r = statement.executeUpdate("UPDATE rubrica SET note = 'erano note' WHERE id < 10");
//			System.out.println("updated rows : " + r);
//
//			//DELETE
//			r = statement.executeUpdate("DELETE FROM rubrica WHERE cognome = 'Roberta'");
//			System.out.println("deleted rows : " + r);

            //INSERT

            //UPDATE
            int r = statement.executeUpdate("UPDATE rubrica SET note = 'erano note' WHERE id < 10");
            System.out.println("updated rows : " + r);

            rs = statement.executeQuery("SELECT * FROM rubrica");

				System.out.println("ID : " + rs.getInt("id"));
				System.out.println("COGNOME : " + rs.getString("cognome"));
				System.out.println("NOME : " + rs.getString("nome"));
				System.out.println("TELEFONO : " + rs.getString("telefono"));
				System.out.println("EMAIL : " + rs.getString("email"));
				System.out.println("NOTE : " + rs.getString("note"));
			}catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		    } catch (SQLException sqlEx) {
		    	sqlEx.printStackTrace();
		    } finally {
//			    try {
//				    rs.close();
//				    statement.close();
//				    connection.close();
//			    } catch (SQLException sqlEx) {
//				    sqlEx.printStackTrace();
//			    }
        }


    }

}
