package it.beije.hopper.rubrica;

import it.beije.hopper.Contatto;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubricaJDBC2 {

    public static final String QUERY_INSERT = "INSERT INTO rubrica (nome, cognome, telefono, email, note) VALUES (?, ?, ?, ?, ?)";
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "root");
    }

    public void scanner() {
        try {

            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            System.out.println("\n\n\tInserisci opzione: \n1/ Inserisci nuovo contatto nella rubrica \n2/ Vedi la rubrica completa \n3/ Cerca tramite referenza \n4/ Esci dal sistema ");
            connection = Connector.getAvailableConnection();
            List<Contatto> contattoList = new ArrayList<>();
            statement = connection.createStatement();
            String line = scanner.nextLine();  // Read user input
            switch (line) {
                case "1": {

                    do {
                        Contatto c = new Contatto();
                        System.out.println("Inserisci Nome: ");
                        c.setNome(scanner.nextLine() + " ");
                        System.out.println("Inserisci cognome: ");
                        c.setCognome(scanner.nextLine() + " ");
                        System.out.println("Inserisci Telefono: ");
                        c.setTelefono(scanner.nextLine() + " ");
                        System.out.println("Inserisci Email: ");
                        c.setEmail(scanner.nextLine() + " ");
                        System.out.println("Inserisci Note: ");
                        c.setNote(scanner.nextLine() + " ");
                        contattoList.add(c);
                        System.out.println("Vuoi inserire un altro utente (s/n): ");
                    } while (scanner.nextLine().trim().equalsIgnoreCase("s"));


                    for (Contatto c : contattoList) {
                        preparedStatement = connection.prepareStatement(QUERY_INSERT);
                        preparedStatement.setString(1, c.getCognome());
                        preparedStatement.setString(2, c.getNome());
                        preparedStatement.setString(3, c.getTelefono());
                        preparedStatement.setString(4, c.getEmail());
                        preparedStatement.setString(5, c.getNote());
                        preparedStatement.executeUpdate();
                    }
                    break;

                }
                case "2":
                    preparedStatement = connection.prepareStatement("SELECT * FROM rubrica");
                    rs = preparedStatement.executeQuery();
                    contattoList.clear();
                    while (rs.next()) {

                        Contatto c = new Contatto();
                        c.setNome(rs.getString("nome"));
                        c.setCognome(rs.getString("cognome"));
                        c.setTelefono(rs.getString("telefono"));
                        c.setEmail(rs.getString("email"));
                        c.setNote(rs.getString("note"));

                        contattoList.add(c);
                    }

                    for (Contatto c : contattoList) {
                        System.out.println(c.toString());
                    }
                    break;

                case "3": {
                    System.out.println("Inserisci Referenza del contatto: ");
                    String temp = scanner.nextLine();
                    preparedStatement = connection.prepareStatement("SELECT * FROM rubrica");
                    rs = preparedStatement.executeQuery();
                    contattoList.clear();
                    while (rs.next()) {

                        Contatto c = new Contatto();
                        c.setNome(rs.getString("nome"));
                        c.setCognome(rs.getString("cognome"));
                        c.setTelefono(rs.getString("telefono"));
                        c.setEmail(rs.getString("email"));
                        c.setNote(rs.getString("note"));

                        contattoList.add(c);
                    }

                    for (Contatto c : contattoList) {
                        if (c.toString().toLowerCase().contains(temp.trim().toLowerCase())) {
                            System.out.println(c.toString());
                        }
                    }
                    break;
                }
                case "4": {
                    System.out.println(":D");
                    System.exit(1);
                    break;
                }
                default: {
                    System.out.println("Parametro sbagliato, inserisci un valore valido");

                    break;
                }
            }
            scanner();

        } catch (ClassNotFoundException | SQLException cnfEx) {
            cnfEx.printStackTrace();
        } finally {
            try {
                assert rs != null;
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        RubricaJDBC2 rubricaJDBC2 = new RubricaJDBC2();
        rubricaJDBC2.scanner();

    }
}
