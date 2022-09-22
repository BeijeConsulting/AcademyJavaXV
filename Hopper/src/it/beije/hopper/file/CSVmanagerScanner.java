package it.beije.hopper.file;

import it.beije.hopper.Contatto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CSVmanagerScanner {

    public static List<Contatto> readRubrica(String path) {
        File file = new File(path);

        System.out.println("file exists? " + file.exists());
        //System.out.println("file is Directory? " + file.isDirectory());
        //System.out.println(Arrays.toString(file.list()));

        FileReader fileReader = null;

        List<Contatto> contatti = new ArrayList<Contatto>();
        try {
            fileReader = new FileReader(file);
//			while (fileReader.ready()) {
//				System.out.print((char)fileReader.read());
//			}

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int c = 0;
            List<String> rows = new ArrayList<String>();
            while (bufferedReader.ready()) {
                rows.add(bufferedReader.readLine());
            }

            Contatto contatto = null;
            for (String row : rows) {
//				StringTokenizer tokenizer = new StringTokenizer(row, ";");
//				System.out.println("COGNOME : " + tokenizer.nextToken());
//				System.out.println("NOME : " + tokenizer.nextToken());
//				System.out.println("TELEFONO : " + tokenizer.nextToken());
//				System.out.println("EMAIL : " + tokenizer.nextToken());
//				System.out.println("NOTE : " + tokenizer.nextToken());

                String[] cols = row.split(";");
//				for (String col : cols) {
//					System.out.println(col);
//				}

                contatto = new Contatto();
                contatto.setCognome(cols[0]);
                contatto.setNome(cols[1]);
                contatto.setTelefono(cols[2]);
                contatto.setEmail(cols[3]);
                contatto.setNote(cols[4]);/*
                System.out.println("COGNOME : " + contatto.getCognome());
                System.out.println("NOME : " + contatto.getNome());
                System.out.println("TELEFONO : " + contatto.getTelefono());
                System.out.println("EMAIL : " + contatto.getEmail());
                System.out.println("NOTE : " + contatto.getNote());*/

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

    public static void printRubrica(String path) {
        File file = new File(path);

        System.out.println("file exists? " + file.exists());
        //System.out.println("file is Directory? " + file.isDirectory());
        //System.out.println(Arrays.toString(file.list()));

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
//			while (fileReader.ready()) {
//				System.out.print((char)fileReader.read());
//			}

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int c = 0;
            List<String> rows = new ArrayList<String>();
            while (bufferedReader.ready()) {
                rows.add(bufferedReader.readLine());
                System.out.println("rows[" + c + "] " + rows.get(c++));
            }

            for (String row : rows) {
                StringTokenizer tokenizer = new StringTokenizer(row, ";");
                System.out.println("COGNOME : " + tokenizer.nextToken());
                System.out.println("NOME : " + tokenizer.nextToken());
                System.out.println("TELEFONO : " + tokenizer.nextToken());
                System.out.println("EMAIL : " + tokenizer.nextToken());
                System.out.println("NOTE : " + tokenizer.nextToken() + "\n");



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
    }

    public static void writeRubrica(List<Contatto> contatti, String path) throws IOException {

        FileWriter fileWriter = new FileWriter(path, true);


        char sep = ';';
        for (Contatto contatto : contatti) {
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

    }

    public static void scanner() throws IOException {/*
		List<Contatto> contatti = readRubrica("/temp/rubrica.csv");
		writeRubrica(contatti, "/temp/hopper_rubrica.csv");*/

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Inserisci opzione: \n1/ Inserisci nuovo contatto nella rubrica \n2/ Vedi la rubrica completa \n3/ Cerca tramite referenza \n4/ Esci dal sistema ");

        String line = scanner.nextLine();  // Read user input
        switch (line) {
            case "1": {
                List<Contatto> contattoList = new ArrayList<>();
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
                writeRubrica(contattoList, "hopper_rubrica.csv");
                break;

            }
            case "2":
                printRubrica("hopper_rubrica.csv");
                break;

            case "3": {
                System.out.println("Inserisci Referenza del contatto: ");
                String temp = scanner.nextLine();
                List<Contatto> contatti = readRubrica("hopper_rubrica.csv");
                for (Contatto contatto : contatti) {
                    if (contatto.toString().contains(temp.trim())) {
                        System.out.println(contatto.toString());
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
    }

    public static void main(String[] args) throws IOException {
        scanner();
    }


}
