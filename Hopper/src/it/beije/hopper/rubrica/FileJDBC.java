package it.beije.hopper.rubrica;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class FileJDBC {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        File file = new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica.csv");
        initialize(file);
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hopper?serverTimezone=CET", "root", "Andrea1.");
    }



    public static void initialize(File file) throws IOException, SQLException {
        FileReader fileReader = new FileReader(file);
        if (file.exists())
            System.out.println("Il file esiste");
        else
            System.out.println("Il file è stato creato");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int count = 0;

        while (bufferedReader.ready() && count<5) {
            String linea = bufferedReader.readLine();
            if (count>=1) {
                String[] contatti = linea.split(";");
                writeDB(contatti);
            }
            count++;
        }
    }


    private static final String SQL_INSERT="INSERT INTO rubrica (ID,COGNOME,NOME,TELEFONO,EMAIL,NOTE) VALUES (?,?,?,?,?,?)";
    public static void writeDB(String[] contatti) throws SQLException {
        Connection connection = null;
        ResultSet rs=null;
        try{
            connection=getConnection();
            System.out.println("Connection open?"+!connection.isClosed());

            PreparedStatement pStatement= connection.prepareStatement(SQL_INSERT);


            if (contatti.length == 4) {
               pStatement.setString(1,null);
               pStatement.setString(2,contatti[1]);
               pStatement.setString(3,contatti[0]);
               pStatement.setString(4,contatti[3]);
               pStatement.setString(5,contatti[2]);
               pStatement.setString(6,null);
               System.out.println("COGNOME, NOME, EMAIL E TELEFONO AGGIUNTI: ");

            }

            if (contatti.length == 3) {
                pStatement.setString(1,null);
                pStatement.setString(2,contatti[1]);
                pStatement.setString(3,contatti[0]);
                pStatement.setString(4,null);
                pStatement.setString(5,contatti[2]);
                pStatement.setString(6,null);
                System.out.println(" COGNOME, NOME ED EMAIL AGGIUNTI:");
            }

            if (contatti.length == 2) {
                pStatement.setString(1,null);
                pStatement.setString(2,contatti[1]);
                pStatement.setString(3,contatti[0]);
                pStatement.setString(4,null);
                pStatement.setString(5,null);
                pStatement.setString(6,null);
                System.out.println("COGNOME E NOME AGGIUNTI: ");
            }

            if (contatti.length == 1) {
                pStatement.setString(1,null);
                pStatement.setString(2,null);
                pStatement.setString(3,contatti[0]);
                pStatement.setString(4,null);
                pStatement.setString(5,null);
                pStatement.setString(6,null);
                System.out.println("NOME AGGIUNTO: ");
            }

            pStatement.executeUpdate();
            rs=pStatement.executeQuery("SELECT * FROM rubrica");

            while (rs.next()) {
                System.out.print("ID : " + rs.getInt("id")+" ");
                System.out.print("COGNOME : " + rs.getString("cognome")+" ");
                System.out.print("NOME : " + rs.getString("nome")+" ");
                System.out.print("TELEFONO : " + rs.getString("telefono")+" ");
                System.out.print("EMAIL : " + rs.getString("email")+" ");
                System.out.println("NOTE : " + rs.getString("note")+" ");
            }
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }finally{
            rs.close();
        }
    }


}
