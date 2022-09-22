package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;
import it.beije.hopper.file.WriteRubrica;

import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RubricaCSV {
   static String path = "C:/test/rubrica.csv";
    static String sep = ";";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "cirillo");
    }

    public static ArrayList<Contatto> listaContatti() throws IOException {
        ArrayList<Contatto> lista = new ArrayList<>();
        List<Contatto> contatto = WriteRubrica.loadRubricaFromCSV("C:/test/rubrica.csv", ";");
        return lista;
    }

    public static void main(String[] args) throws IOException {
        Connection connection = null;
        Statement statement = null;
        //ResultSet rs = null;

        try {
            connection = RubricaJDBC.getConnection();

            statement = connection.createStatement();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO rubrica ('cognome', 'nome', 'telefono', 'email', 'note') values (?, ?, ?, ?, ?)");
            // Inserisci contatti all'interno del DB
            for (int i = 0; i < WriteRubrica.loadRubricaFromCSV(path, sep).size(); i++) {
                Contatto contatto = new Contatto();
                contatto.setCognome(WriteRubrica.loadRubricaFromCSV(path, sep).get(i).getCognome());
                contatto.setNome(WriteRubrica.loadRubricaFromCSV(path, sep).get(i).getNome());
                contatto.setTelefono(WriteRubrica.loadRubricaFromCSV(path, sep).get(i).getTelefono());
                contatto.setEmail(WriteRubrica.loadRubricaFromCSV(path, sep).get(i).getEmail());
                contatto.setNote(WriteRubrica.loadRubricaFromCSV(path, sep).get(i).getNote());

                stmt.setString(1, contatto.getCognome());
                stmt.setString(2, contatto.getNome());
                stmt.setString(3, contatto.getTelefono());
                stmt.setString(4, contatto.getEmail());
                stmt.setString(5, contatto.getNote());
                int x = stmt.executeUpdate();
            }


        } catch (ClassNotFoundException cnfEx) {
            cnfEx.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                //rs.close();
                statement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

    }

}