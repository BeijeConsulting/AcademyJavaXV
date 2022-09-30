package it.beije.hopper.rubricamod.fileMod;

import it.beije.hopper.Contatto;

import java.io.*;
import java.nio.file.Files;
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
				String line = bufferedReader.readLine();
				if( c != 0 ){
					rows.add(line);
					System.out.println("rows["+ (c-1) + "] " + rows.get(c-1));
				}
				c++;
			}
			
			Contatto contatto = null;
			for (String row : rows) {

				String[] cols = row.split(";");
				if(cols[0].equalsIgnoreCase("cognome")) continue;
				//TODO: temp solution--> needs to be fixed!
				contatto = new Contatto();
				contatto.setCognome( cols.length >= 1 ? cols[0]:"");
				contatto.setNome(cols.length >= 2 ? cols[1] : "");
				contatto.setEmail(cols.length >= 3 ? cols[2]:"");
				contatto.setTelefono(cols.length >= 4 ? cols[3]:"");
				contatto.setNote(cols.length >= 5 ? cols[4]:"");

				System.out.println("DATA: " + contatto);
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
		File file = new File(path);
		FileWriter fileWriter = new FileWriter(file, file.exists());
		char sep = ';';
		for (Contatto contatto : contatti) {
			fileWriter.write(contatto.getNome() == null ? "":contatto.getNome());
			fileWriter.write(sep);
			fileWriter.write(contatto.getCognome() == null ? "":contatto.getCognome());
			fileWriter.write(sep);
			fileWriter.write(contatto.getEmail() == null ? "":contatto.getEmail());
			fileWriter.write(sep);
			fileWriter.write(contatto.getTelefono() == null ? "":contatto.getTelefono());
			fileWriter.write(sep);
			fileWriter.write(contatto.getNote() == null ? "":contatto.getNote());
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
		List<Contatto> contatti = readRubrica("src/testFile_CSV_XML/rubrichecsv/rubrica - cognomeReduced.csv");
//		System.out.println("CONTATTI TEST FILE:");
//		System.out.println(contatti);
		writeRubrica(contatti, "src/testFile_CSV_XML/output/rubrica - cognomeReducedOut.csv");

	}


}
