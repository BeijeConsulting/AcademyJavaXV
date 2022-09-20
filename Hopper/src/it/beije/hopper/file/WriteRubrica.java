package it.beije.hopper.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
			System.out.println("COGNOME : " + contatto.getCognome());
			System.out.println("NOME : " + contatto.getNome());
			System.out.println("TELEFONO : " + contatto.getTelefono());
			System.out.println("EMAIL : " + contatto.getEmail());

			contatti.add(contatto);
		}
		return contatti;
	}

	public static void main(String[] args) throws IOException {
		WriteRubrica.loadRubricaFromCSV("/test/rubrica.csv", ";");
	}

}
