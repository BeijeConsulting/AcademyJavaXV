package it.beije.hopper.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.hopper.Contatto;

public class WriteRubrica {

	public static List<Contatto> loadRubricaFromCSV(String pathFile, String separator) throws IOException {
		List<Contatto> contatti = new ArrayList<Contatto>();
		File file = new File(pathFile);
		FileReader fileReader = null;
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
			contatto.setCognome(cols[0]);
			contatto.setNome(cols[1]);
			contatto.setTelefono(cols[2]);
			contatto.setEmail(cols[3]);
			contatti.add(contatto);
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
			fileWriter.write('\n');
		}

		fileWriter.flush();
		fileWriter.close();

	}

	public Contatto cercaContatto(String nome) throws IOException {
		List<Contatto> contatti = new ArrayList<Contatto>(loadRubricaFromCSV("C:/test/rubrica.csv", ";"));
		Contatto contatto = new Contatto();
		for (int i = 0; i < contatti.size(); i++) {
			if (contatti.get(i).getNome().equalsIgnoreCase(nome)) {
				System.out.println("Il contatto che cerchi è: " + contatti.get(i));
			}
		}
		return contatto;
	}

	public void inserisciContatto(String cognome, String nome, String telefono, String email) throws IOException {
		List<Contatto> contatti = new ArrayList<Contatto>(loadRubricaFromCSV("C:/test/rubrica.csv", ";"));
		FileWriter fileWriter = new FileWriter("/test/nuovarubrica.csv", true);
		Contatto contatto = new Contatto();
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setTelefono(telefono);
		contatto.setEmail(email);
		contatti.add(contatto);
		char sep = ';';
		fileWriter.write(contatto.getNome());
		fileWriter.write(sep);
		fileWriter.write(contatto.getCognome());
		fileWriter.write(sep);
		fileWriter.write(contatto.getEmail());
		fileWriter.write(sep);
		fileWriter.write(contatto.getTelefono());
		fileWriter.write('\n');
		fileWriter.flush();
		fileWriter.close();
	}
	
	public void eliminaContatto(String numeroTelefono) throws IOException {
		List<Contatto> contatti = new ArrayList<Contatto>(loadRubricaFromCSV("C:/test/rubrica.csv", ";"));
		FileWriter fileWriter = new FileWriter("/test/nuovarubrica.csv", true);
		Contatto contatto = new Contatto();
		
	}

	public static void main(String[] args) throws IOException {
		WriteRubrica.loadRubricaFromCSV("C:/test/rubrica.csv", ";");
		List<Contatto> contatti = loadRubricaFromCSV("C:/test/rubrica.csv", ";");
		WriteRubrica.writeRubrica(contatti, "C:/test/nuovarubrica.csv");
	}

}
