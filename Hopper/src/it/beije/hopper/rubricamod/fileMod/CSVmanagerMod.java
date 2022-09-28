package it.beije.hopper.rubricamod.fileMod;

import it.beije.hopper.Contatto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVmanagerMod {

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

				
				String[] cols = row.split(";");
				
				contatto = new Contatto();
				contatto.setCognome(cols[0]);
				contatto.setNome(cols[1]);
				contatto.setTelefono(cols[2]);
				contatto.setEmail(cols[3]);
				contatto.setNote(cols[4]);
//				System.out.println("COGNOME : " + contatto.getCognome());
//				System.out.println("NOME : " + contatto.getNome());
//				System.out.println("TELEFONO : " + contatto.getTelefono());
//				System.out.println("EMAIL : " + contatto.getEmail());
//				System.out.println("NOTE : " + contatto.getNote());
//
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
		//List<Contatto> contatti = readRubrica("/temp/rubrica.csv");
		//writeRubrica(contatti, "/temp/hopper_rubrica.csv");

//		String folderIn = "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy-pt2\\Hopper\\src\\it\\beije\\hopper\\testFile_CSV_XML\\rubrichecsv\\rubrica - testSecond.csv";
//		String folderOut = "C:\\Users\\Michael Angelo\\IdeaProjects\\Beije-Academy-pt2\\Hopper\\src\\it\\beije\\hopper\\rubricamod\\outputfiles\\csv\\";
		List<Contatto> contatti = readRubrica("src/testFile_CSV_XML/rubrichecsv/rubrica - test.csv");
		System.out.println("CONTATTI TEST FILE:");
		System.out.println(contatti);
		//writeRubrica(contatti, folderOut+"output.csv");

	}


}
