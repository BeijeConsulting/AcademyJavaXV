package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;

import java.sql.*;
import java.util.ArrayList;

public class RubricaMethodsDB {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "cirillo");
    }

    public static ArrayList<Contatto> listaDB() {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Contatto contatto;
        try {
            connection = RubricaMethodsDB.getConnection();
            statement = connection.createStatement();
            ArrayList<Contatto> listaContatti = new ArrayList<>();

            rs = statement.executeQuery("SELECT * FROM rubrica");

            while (rs.next()) {
                contatto = new Contatto();
                contatto.setNome(rs.getString("nome"));
                contatto.setCognome(rs.getString("cognome"));
                contatto.setTelefono(rs.getString("telefono"));
                contatto.setEmail(rs.getString("email"));
                contatto.setNote(rs.getString("note"));
                contatto.setId(rs.getInt("id"));
                listaContatti.add(contatto);
            }
            System.out.println(listaContatti);
            return listaContatti;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rs.close();
                statement.close();
            } catch (SQLException sqlEx) {
                System.out.println("");
                ;
            }
        }
    }

    public static ArrayList<Contatto> cercaContattoDB(String campo, String nome) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        Contatto contatto;
        try {
            connection = RubricaMethodsDB.getConnection();
            statement = connection.createStatement();
            ArrayList<Contatto> listaContatti = new ArrayList<>();

            rs = statement.executeQuery("SELECT * FROM rubrica where " + campo + "= '" + nome + "'");

            while (rs.next()) {
                contatto = new Contatto();
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

    public static void inserisciContattoDB(Contatto contatto) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = RubricaMethodsDB.getConnection();
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("INSERT INTO rubrica (nome, cognome, telefono, email, note) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, contatto.getNome());
            preparedStatement.setString(2, contatto.getCognome());
            preparedStatement.setString(3, contatto.getTelefono());
            preparedStatement.setString(4, contatto.getEmail());
            preparedStatement.setString(5, contatto.getNote());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
    }

    public static void modificaContattoDB(String id, String campo, String nuovoValore) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = RubricaMethodsDB.getConnection();
            statement = connection.createStatement();

            preparedStatement = connection.prepareStatement("UPDATE rubrica SET " + campo + " = ? WHERE id = ?");
            preparedStatement.setString(1, nuovoValore);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
    }

    public static void eliminaContattoDB(String id) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = RubricaMethodsDB.getConnection();
            statement = connection.createStatement();

            preparedStatement = connection.prepareStatement("DELETE FROM rubrica WHERE id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
    }
}