package rubriche;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rubriche {

	public static void main(String args[]){
		
		File rubrica= new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica.csv");
		File cognome= new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica - cognome.csv");
		File email= new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica - email.csv");
		File nome= new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica - nome.csv");
		File tel= new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica - tel.csv");
		
		File f = new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\text.csv");
		try {
			if (f.createNewFile())
				System.out.println("File created");
			else  
				System.out.println("File already exists");
			
			FileReader rubricaFileReader=new FileReader(rubrica);
			BufferedReader rubricaBufferedReader=new BufferedReader(rubricaFileReader);
			
			FileWriter write=new FileWriter(f);
			
			int c = 0;
			List<String> rows = new ArrayList<String>();
			
			while (rubricaBufferedReader.ready()) {
				rows.add(rubricaBufferedReader.readLine());
				write.write(rows.get(c++)+"\n");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
