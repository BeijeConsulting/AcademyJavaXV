package it.beije.hopper.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import MyStuff.Contatto;

public class CSVmanager {

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
				System.out.println("rows["+ c + "] " + rows.get(c++));
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
				//contatto.setNote(cols[4]);
				System.out.println("COGNOME : " + contatto.getCognome());
				System.out.println("NOME : " + contatto.getNome());
				System.out.println("TELEFONO : " + contatto.getTelefono());
				System.out.println("EMAIL : " + contatto.getEmail());
				//System.out.println("NOTE : " + contatto.getNote());
				
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

	public static void writeRubrica(List<Contatto> contatti, String path) throws IOException {
		
		FileWriter fileWriter = new FileWriter(path);
		
//		for (String row : rows) {
//			fileWriter.write(row);
//			fileWriter.write('\n');
//		}
		
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

	public static void main(String[] args) throws IOException {
		List<Contatto> contatti = readRubrica("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica - cognome.csv");
		//writeRubrica(contatti, "/temp/hopper_rubrica.csv");
	}


}
