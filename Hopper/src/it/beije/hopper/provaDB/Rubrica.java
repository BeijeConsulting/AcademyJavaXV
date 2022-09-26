package it.beije.hopper.provaDB;
import it.beije.hopper.Contatto;
import javax.swing.plaf.nimbus.State;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Rubrica {

    public static ArrayList<Contatto> contatti = new ArrayList<Contatto>();
    public static  List<String> campi = Arrays.asList("id", "nome", "cognome", "email", "telefono", "note");

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "Saponara13");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        // List<Contatto> contatti = readRubricaCSV("C:\Users\Raffaele\Desktop\AcademyJavaXV\Hopper\src\it\beije\hopper\provaDB\testFiles\hopper_rubrica.csv");
        // writeRubricaCSV(contatti, "C:\Users\Raffaele\Desktop\AcademyJavaXV\Hopper\src\it\beije\hopper\provaDB\testFiles\rubrica.csv");

        Connection connection = Rubrica.getConnection();
        Statement statement = connection.createStatement();

        Scanner scanner = new Scanner(System.in);
        System.out.println("['1'] -> nuovo contatto \t['2'] -> modifica contatto \t['3'] -> elimina contatto \t['4'] -> stampa rubrica \t['5'] -> cerca contatto \t['6'] -> import/export \t['exit'] -> per uscire"+")");
        String input = scanner.nextLine();

        while(!input.equalsIgnoreCase("exit") ){

            switch (input){
                case "1" :  inserisciContatto(scanner, statement); break;
                case "2" :  modificaContatto(scanner, statement); break;
                case "3" :  eliminaContatto(scanner, statement); break;
                case "4" :  System.out.println("Vuoi ordinare per 'nome' o per 'cognome' ?");
                            String ord = scanner.nextLine();
                            for (Contatto c: getRubrica(statement, ord)) {
                                System.out.println(c.toString());
                            }
                            System.out.println("\n");
                            break;
                case "5" :  for (Contatto c: cercaContatto(scanner, statement)) {
                                System.out.println(c.toString());
                            }
                            System.out.println("\n");
                            break;
                case "6" :  import_export(scanner, statement); break;
                default: System.out.println("OPZIONE NON VALIDA!!1!1!!!1!");
            }

            System.out.println("['1'] -> nuovo contatto \t['2'] -> modifica contatto \t['3'] -> elimina contatto \t['4'] -> stampa rubrica \t['5'] -> cerca contatto  \t['6'] -> import/export \t['exit'] -> per uscire"+")");
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
        try{
            statement.executeUpdate("INSERT INTO rubrica VALUES (null, '" + cognome + "', '" + nome + "', '" + telefono + "', '" + email + "', '" + note + "')");
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }

    public static void import_export(Scanner scanner, Statement statement) throws SQLException, IOException {   // Dispatcher per import/export
        System.out.println("['1'] -> importa da .CSV \t['2'] -> importa da .XML \t['3'] -> esporta su .CSV \t['4'] -> esporta su .XML \t['exit'] -> per uscire");
        String command = scanner.nextLine();
        switch (command){
            case "1" :  importFromCSV(scanner, statement); break;
            case "2" :
            case "3" :  exportToCSV(scanner, statement); break;
            case "4" :
            case "exit" :  break;
            default: System.out.println("OPZIONE NON VALIDA!!1!1!!!1!");
        }

    }

    public static void importFromCSV(Scanner scanner, Statement statement) throws SQLException {
        System.out.println("Indica il path del file CSV dal quale importare i contatti in rubrica: ");
        String path = scanner.nextLine();
        List<Contatto> list = readRubricaCSV(path);
        list.remove(0);
        for (Contatto c: list) {
            if(c.getTelefono() != null && c.getTelefono().contains("'")){c.setTelefono(c.getTelefono().replace("'+39", ""));}
            String query = "INSERT INTO rubrica VALUES (null, ";

            if(c.getCognome() == null || c.getCognome() == "" )     {query += ""+ null + ", ";} else {query += "'"+ c.getCognome() + "', ";}
            if(c.getNome() == null || c.getNome() == "" )           {query += ""+ null + ", ";} else {query += "'"+ c.getNome() + "', ";}
            if(c.getTelefono() == null || c.getTelefono() == "" )   {query += ""+ null + ", ";} else {query += "'"+ c.getTelefono() + "', ";}
            if(c.getEmail() == null || c.getEmail() == "" )         {query += ""+ null + ", ";} else {query += "'"+ c.getEmail() + "', ";}
            if(c.getNote() == null || c.getNote() == "" )           {query += ""+ null + ")";}  else {query += "'"+ c.getNote() + "')";}

            try{
                statement.executeUpdate(query);
            }catch (SQLException sqlEx){
                sqlEx.printStackTrace();
            }finally {
                query = "";
            }

        }

    }

    public static void exportToCSV(Scanner scanner, Statement statement) throws SQLException, IOException {
        System.out.println("Indica il path del file CSV sul quale esportare i contatti della rubrica: ");
        String path = scanner.nextLine();
        List<Contatto> list = getRubrica(statement, "cognome");
        try{
            writeRubricaCSV(list, path);
        }catch (IOException e){
            e.printStackTrace();
        }
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

    public static void eliminaContatto(Scanner scanner, Statement statement) throws SQLException {

        System.out.println("Inserisci l'id del contatto che vuoi eliminare");
        String id = scanner.nextLine();

        try {
            statement.executeUpdate("DELETE FROM rubrica WHERE id="+id);
            System.out.println("Contatto eliminato!");
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }

    public static ArrayList<Contatto> getRubrica(Statement statement, String ord) throws SQLException {

        ArrayList<Contatto> contatti = new ArrayList<Contatto>();
        ResultSet rs = null;

        try {

            rs = statement.executeQuery("SELECT * FROM rubrica ORDER BY "+ord);

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

    public static ArrayList<Contatto> cercaContatto(Scanner scanner, Statement statement){

        ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();
        System.out.println("indica quale campo vuoi utilitizzare per effettuare la ricerca: ");
        String campo = scanner.nextLine();
        System.out.println("ora scrivi il valore: ");
        String valore = scanner.nextLine();

        ResultSet rs = null;

        try {

            rs = statement.executeQuery("SELECT * FROM rubrica WHERE " + campo + " = '" + valore+"'");

            while (rs.next()) {
                Contatto contatto = new Contatto();
                contatto.setNome(rs.getString("nome"));
                contatto.setCognome(rs.getString("cognome"));
                contatto.setTelefono(rs.getString("telefono"));
                contatto.setEmail(rs.getString("email"));
                contatto.setNote(rs.getString("note"));
                contattiTrovati.add(contatto);
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
        return contattiTrovati;
    }

    public static List<Contatto> readRubricaCSV(String path){

        File file = new File(path);
        System.out.println("file exists? " + file.exists());
        FileReader fileReader = null;
        List<Contatto> contatti = new ArrayList<Contatto>();

        try {
            fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int c = 0;
            List<String> rows = new ArrayList<String>();
            while (bufferedReader.ready()) {
                rows.add(bufferedReader.readLine());
            }

            Contatto contatto = null;
            for (String row : rows) {

                String[] cols = row.split(";");
                contatto = new Contatto();

                for (int i=0; i<cols.length; i++){
                    switch (i){
                        case 0: contatto.setCognome(cols[0]);
                            System.out.println("COGNOME : " + contatto.getCognome()); break;
                        case 1: contatto.setNome(cols[1]);
                            System.out.println("NOME : " + contatto.getNome()); break;
                        case 2: contatto.setEmail(cols[2]);
                            System.out.println("EMAIL : " + contatto.getEmail()); break;
                        case 3: contatto.setTelefono(cols[3]);
                            System.out.println("TELEFONO : " + contatto.getTelefono()); break;
                        case 4: contatto.setNote(cols[4]);
                            System.out.println("NOTE : " + contatto.getNote()); break;
                    }
                }
                contatti.add(contatto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException inner) {
                inner.printStackTrace();
            }
        }
        return contatti;
    }

    public static void writeRubricaCSV(List<Contatto> contatti, String path) throws IOException {
        FileWriter fileWriter = null;
        File f = new File(path);

        try {

            if(f.exists()){
                fileWriter   = new FileWriter(path, true);
            }else{
                fileWriter   = new FileWriter(path);
                fileWriter.write("COGNOME;NOME;E-MAIL;TELEFONO;NOTE\n");
            }


            char sep = ';';
            for (Contatto contatto : contatti) {
                if((contatto.getCognome() != null)){
                    fileWriter.write(contatto.getCognome());
                    fileWriter.write(sep);
                }else {
                    fileWriter.write("");
                    fileWriter.write(sep);
                }
                if((contatto.getNome() != null)){
                    fileWriter.write(contatto.getNome());
                    fileWriter.write(sep);
                }else {
                    fileWriter.write("");
                    fileWriter.write(sep);
                }
                if((contatto.getEmail() != null)){
                    fileWriter.write(contatto.getEmail());
                    fileWriter.write(sep);
                }else {
                    fileWriter.write("");
                    fileWriter.write(sep);
                }
                if((contatto.getTelefono() != null)){
                    fileWriter.write(contatto.getTelefono());
                    fileWriter.write(sep);
                }else {
                    fileWriter.write("");
                    fileWriter.write(sep);
                }
                if((contatto.getNote() != null)){
                    fileWriter.write(contatto.getNote());

                }else {
                    fileWriter.write("");
                    fileWriter.write(sep);
                }
                fileWriter.write('\n');
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fileWriter.flush();
            fileWriter.close();
        }
    }
}
