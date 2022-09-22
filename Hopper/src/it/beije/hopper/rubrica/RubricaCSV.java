package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;
import it.beije.hopper.file.WriteRubrica;

import java.io.FileWriter;
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

    public static void writeRubrica() throws SQLException, IOException {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Contatto> listaContatti = new ArrayList<>();
        ResultSet rs = null;
        try {
            connection = RubricaJDBC.getConnection();
            statement = connection.createStatement();

            rs = statement.executeQuery("SELECT * FROM rubrica WHERE nome, cognome, telefono, email, note IS NOT NULL;");
            while (rs.next()) {
                Contatto contatto = new Contatto();
                contatto.setNome(rs.getString("nome"));
                contatto.setCognome(rs.getString("cognome"));
                contatto.setTelefono(rs.getString("telefono"));
                contatto.setEmail(rs.getString("email"));
                contatto.setNote(rs.getString("note"));
                listaContatti.add(contatto);
            }
            FileWriter fileWriter = new FileWriter("C:/test/nuovarubricaDB.csv");
            char sep = ';';
            for (Contatto contatto : listaContatti) {
                fileWriter.write(contatto.getNome());
                fileWriter.write(sep);
                fileWriter.write(contatto.getCognome());
                fileWriter.write(sep);
                fileWriter.write(contatto.getEmail());
                fileWriter.write(sep);
                fileWriter.write(contatto.getTelefono());
                fileWriter.write(sep);
                fileWriter.write(contatto.getNote());
                fileWriter.write('\n');
            }
            fileWriter.flush();
            fileWriter.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
        public static void main(String[] args) throws IOException, SQLException {
    RubricaCSV.writeRubrica();
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        // inserisci contatti dal csv al db
        ArrayList<Contatto> listaContatti = new ArrayList<>();

        for (int i = 0; i < WriteRubrica.loadRubricaFromCSV(path, sep).size(); i++) {
            Contatto contatto = new Contatto();
            contatto.setCognome(WriteRubrica.loadRubricaFromCSV(path, sep).get(i).getCognome());
            contatto.setNome(WriteRubrica.loadRubricaFromCSV(path, sep).get(i).getNome());
            contatto.setTelefono(WriteRubrica.loadRubricaFromCSV(path, sep).get(i).getTelefono());
            contatto.setEmail(WriteRubrica.loadRubricaFromCSV(path, sep).get(i).getEmail());
            contatto.setNote(WriteRubrica.loadRubricaFromCSV(path, sep).get(i).getNote());
            listaContatti.add(contatto);
        }
        try {
            connection = RubricaJDBC.getConnection();
            statement = connection.createStatement();

            // Inserisci contatti all'interno del DB
            preparedStatement = connection.prepareStatement("INSERT INTO rubrica (nome, cognome, telefono, email, note) VALUES (?, ?, ?, ?, ?)");
            for (Contatto cont : listaContatti) {
                preparedStatement.setString(1, cont.getNome());
                preparedStatement.setString(2, cont.getCognome());
                preparedStatement.setString(3, cont.getTelefono());
                preparedStatement.setString(4, cont.getEmail());
                preparedStatement.setString(5, cont.getNote());
                //   preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException cnfEx) {
            cnfEx.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
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