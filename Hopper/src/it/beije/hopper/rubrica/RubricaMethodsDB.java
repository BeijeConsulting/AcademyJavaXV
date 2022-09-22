package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;

import java.sql.*;
import java.util.ArrayList;

public class RubricaMethodsDB {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "cirillo");
    }

    public static ArrayList<Contatto> cercaContattoDB(String campo, String nome) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = RubricaJDBC.getConnection();
            statement = connection.createStatement();
            ArrayList<Contatto> listaContatti = new ArrayList<>();

            rs = statement.executeQuery("SELECT * FROM rubrica where " + campo + "= '" + nome + "'");

            while (rs.next()) {
                Contatto contatto = new Contatto();
                contatto.setNome(rs.getString("nome"));
                contatto.setCognome(rs.getString("cognome"));
                contatto.setTelefono(rs.getString("telefono"));
                contatto.setEmail(rs.getString("email"));
                contatto.setNote(rs.getString("note"));
                listaContatti.add(contatto);
            }
            System.out.println(listaContatti);
            return listaContatti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}