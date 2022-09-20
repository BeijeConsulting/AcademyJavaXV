package rubriche;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RubricheCSV {

	public static void main(String args[]){
		
		File rubrica= new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica.csv");
		File cognome= new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica - cognome.csv");
		File email= new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica - email.csv");
		File nome= new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica - nome.csv");
		File tel= new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\rubrica - tel.csv");
		
		createReader(rubrica);
		
	}
	
	public static void createReader(File file) {
		File f = new File("C:\\Users\\andre\\OneDrive\\Documents\\Beije\\Programming\\MyStuff\\RubricaEsercizioFile\\text.csv");
		FileReader reader=null;
		
		try {
			if (f.createNewFile()) {
				System.out.println("File created");
			}
			else{
				System.out.println("File already exists");
			}			
			reader=new FileReader(file);	
			writeFile(f,reader);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void writeFile(File file,FileReader reader) {
		try{
			
			BufferedReader buffered=new BufferedReader(reader);
			FileWriter write=new FileWriter(file);
		
			int c = 0;
			List<String> rows = new ArrayList<String>();
		
			while (buffered.ready()) {
				rows.add(buffered.readLine());
				write.write(rows.get(c++)+"\n");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
