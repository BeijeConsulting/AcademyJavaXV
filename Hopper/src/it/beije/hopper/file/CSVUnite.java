package it.beije.hopper.file;

import it.beije.hopper.Contatto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CSVUnite {

    static List<Contatto> contatti = new ArrayList<Contatto>();

    public static List<Contatto> readRubrica(String path) {
        File file = new File(path);

        System.out.println("file exists? " + file.exists());

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int c = 0;
            List<String> rows = new ArrayList<String>();
            while (bufferedReader.ready()) {
                rows.add(bufferedReader.readLine());
                System.out.println("rows[" + c + "] " + rows.get(c++));
            }

            for (int i = 0; i < rows.size(); i++) {

                String[] cols = rows.get(i).split(";");
                Contatto contatto;
                if (contatti.size() > i)
                     contatto = contatti.get(i);
                else contatto = new Contatto();

                if (contatto.getCognome() == null && cols.length > 0 && !(cols[0].isEmpty()))
                    contatto.setCognome(Objects.requireNonNull(cols[0]));
                if (contatto.getNome() == null && cols.length > 1 && !(cols[1].isEmpty()))
                    contatto.setNome(Objects.requireNonNull(cols[1]));
                if (contatto.getEmail() == null && cols.length > 2 && !(cols[2].isEmpty()))
                    contatto.setEmail(Objects.requireNonNull(cols[2]));
                if (contatto.getTelefono() == null && cols.length > 3 && !(cols[3].isEmpty()))
                    contatto.setTelefono(Objects.requireNonNull(cols[3]));
                System.out.println("COGNOME : " + contatto.getCognome());
                System.out.println("NOME : " + contatto.getNome());
                System.out.println("TELEFONO : " + contatto.getTelefono());
                System.out.println("EMAIL : " + contatto.getEmail());

                if (contatti.size() > i)
                    contatti.set(i, contatto);
                else contatti.add(contatto);

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

    public static void writeRubrica(List<Contatto> contatti, String path) throws IOException {

        FileWriter fileWriter = new FileWriter(path);
        char sep = ';';
        for (Contatto contatto : contatti) {
            if (contatto.getNome() != null)
                fileWriter.write(contatto.getNome());
            fileWriter.write(sep);
            if (contatto.getCognome() != null)
                fileWriter.write(contatto.getCognome());
            fileWriter.write(sep);
            if (contatto.getEmail() != null)
                fileWriter.write(contatto.getEmail());
            fileWriter.write(sep);
            if (contatto.getTelefono() != null)
                fileWriter.write(contatto.getTelefono());
            fileWriter.write(sep);
            fileWriter.write('\n');
        }

        fileWriter.flush();
        fileWriter.close();

    }

    public static void main(String[] args) throws IOException {
        File folder = new File("C:\\Users\\emanu\\Desktop\\rubriche");
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (!file.isDirectory()) {
                readRubrica(file.getPath());
            }
        }
        writeRubrica(contatti, "hopper_rubrica.csv");
        System.out.println(Files.size(Paths.get("hopper_rubrica.csv")));
    }


}
