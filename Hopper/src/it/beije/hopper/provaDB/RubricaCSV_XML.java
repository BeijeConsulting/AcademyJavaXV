package it.beije.hopper.provaDB;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.util.*;
import java.io.*;

import it.beije.hopper.Contatto;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


public class RubricaCSV_XML {

    public static void main(String... a) throws IOException {
        List<Contatto> contatti = readRubricaCSV("/temp/rubrica.csv");
        writeRubricaCSV(contatti, "/temp/hopper_rubrica.csv");
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

        try {
            fileWriter   = new FileWriter(path);

            char sep = ';';
            for (Contatto contatto : contatti) {
                if((contatto.getNome() != null)){
                    fileWriter.write(contatto.getNome());
                    fileWriter.write(sep);
                }
                if((contatto.getCognome() != null)){
                    fileWriter.write(contatto.getCognome());
                    fileWriter.write(sep);
                }
                if((contatto.getEmail() != null)){
                    fileWriter.write(contatto.getEmail());
                    fileWriter.write(sep);
                }
                if((contatto.getTelefono() != null)){
                    fileWriter.write(contatto.getTelefono());
                    fileWriter.write(sep);
                }
                if((contatto.getNote() != null)){
                    fileWriter.write(contatto.getNote());

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
