package it.beije.hopper.esercizi.gesionerubrica;

import it.beije.hopper.Contatto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.query.Query;



public class GestioneConnessioni {

	//Gestione Rubrica con JDBC
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "Marinelli1997");
	}

	public List<Contatto> importFromDataBase() {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		List<Contatto> contatti = new ArrayList<>();
		Contatto contatto;
		
		try {
			connection = Rubrica.getConnection();

			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM rubrica");
			
			//SELECT
			while (rs.next()) {
				contatto = new Contatto();
				contatto.setCognome( rs.getString("cognome") );
				contatto.setNome( rs.getString("nome") );
				contatto.setTelefono( rs.getString("telefono") );
				contatto.setEmail( rs.getString("email") );
				contatto.setNote( rs.getString("note") );
				contatti.add(contatto);
			}
			
			System.out.println("Rubrica caricata correttamente da DataBase. ");

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				//connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		
		return contatti;
	}

	public void aggiungiContattoDataBase(Contatto contatto) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		PreparedStatement insert = null;
		
		try {
			connection = Rubrica.getConnection();
			
			insert = connection.prepareStatement("INSERT INTO `hopper`.`rubrica` (`cognome`, `nome`, `telefono`, `email`, `note`) VALUES (?, ?, ?, ?, ?)");
			insert.setString(1, contatto.getCognome());
			insert.setString(2, contatto.getNome());
			insert.setString(3, contatto.getEmail());
			insert.setString(4, contatto.getTelefono());
			insert.setString(5, contatto.getNote());
			insert.executeUpdate();
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			//try {
				//rs.close();
				//statement.close();
				//connection.close();
			//} catch (SQLException sqlEx) {
				//sqlEx.printStackTrace();
		//	}
		}
	}
	
	//Gestione Rubrica con Hibernate
	public List<Contatto> importFromHibernate() {
		Session session = HBMsessionFactory.opernSession();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM rubrica
		List<Contatto> contatti = query.getResultList();
		return contatti;
	}
	
	
	
}
