package it.beije.hopper.provaDB;

import it.beije.hopper.Contatto;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Rubrica {

    public static ArrayList<Contatto> contatti = new ArrayList<Contatto>();
    public static  List<String> campi = Arrays.asList("id", "nome", "cognome", "email", "telefono", "note");

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "Saponara13");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection = Rubrica.getConnection();
        Statement statement = connection.createStatement();

        Scanner scanner = new Scanner(System.in);
        System.out.println("['i'] -> nuovo contatto, ['m'] -> modifica contatto, ['v'] -> stampa rubrica ("+"exit per uscire"+")");
        String input = scanner.nextLine();

        while(!input.equals("exit") ){

            switch (input){
                case "i" :  inserisciContatto(scanner, statement); break;
                case "m" :  modificaContatto(scanner, statement); break;
                case "v" :  for (Contatto c: getRubrica(statement)) {
                                System.out.println(c.toString());
                            }
                            System.out.println("\n");
                            break;
                default: System.out.println("Hai inserito un carattere non consentito!");
            }

            System.out.println("['i'] -> nuovo contatto, ['m'] -> modifica contatto, ['v'] -> stampa rubrica ("+"exit per uscire"+")");
            input = scanner.nextLine();
        }

        try {
            statement.close();
         //   connection.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }

    public static void inserisciContatto(Scanner scanner, Statement statement) throws SQLException {

        System.out.println("Inserisci nome: ");
        String nome = scanner.nextLine();
        System.out.println("Inserisci cognome: ");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci telefono: ");
        String telefono = scanner.nextLine();
        System.out.println("Inserisci email: ");
        String email = scanner.nextLine();
        System.out.println("Inserisci note: ");
        String note = scanner.nextLine();

        statement.executeUpdate("INSERT INTO rubrica VALUES (null, '" + cognome + "', '" + nome + "', '" + telefono + "', '" + email + "', '" + note + "')");

    }

    public static void modificaContatto(Scanner scanner, Statement statement) throws SQLException {


        System.out.println("Inserisci l'id del contatto che vuoi modificare");
        String id = scanner.nextLine();
        System.out.println("Inserisci il nome del campo che vuoi modificare");
        String campo = scanner.nextLine();
        if(!campi.contains(campo)){
            System.out.println("Il campo che hai inserito non esiste, inserisci un campo esistente!");
            campo = scanner.nextLine();
        }else if (campo.equalsIgnoreCase("id")){
            System.out.println("Il campo ID non può essere modificato, inserisci un campo che non sia ID!");
            campo = scanner.nextLine();
        }
        System.out.println("Inserisci il nuovo valore");
        String valore = scanner.nextLine();

        try {
            statement.executeUpdate("UPDATE rubrica SET " + campo + "= '"+ valore +"' WHERE id ="+id+"");
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }

    public static ArrayList<Contatto> getRubrica(Statement statement) throws SQLException {

        ArrayList<Contatto> contatti = new ArrayList<Contatto>();
        ResultSet rs = null;

        try {

            rs = statement.executeQuery("SELECT * FROM rubrica");

            while (rs.next()) {
                Contatto contatto = new Contatto();
                contatto.setNome(rs.getString("nome"));
                contatto.setCognome(rs.getString("cognome"));
                contatto.setTelefono(rs.getString("telefono"));
                contatto.setEmail(rs.getString("email"));
                contatto.setNote(rs.getString("note"));
                contatti.add(contatto);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                rs.close();
                //statement.close();
                //connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
        return contatti;
    }
}
