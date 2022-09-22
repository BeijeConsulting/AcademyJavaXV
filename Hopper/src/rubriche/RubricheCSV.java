package rubriche;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class RubricheCSV {

	static File f;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		System.out.println("Inserire path del file da creare/cercare: ");
		File file = new File(in.nextLine());
		f = file;
		try {
			if (f.createNewFile()) {
				System.out.println("File created");
			} else {
				System.out.println("File already exists");
			}

				System.out.println("Inserire path del primo file da cercare: ");
				File rubricaFile = new File(in.nextLine());
				createReader(rubricaFile);

				System.out.println("Inserire path del secondo file da cercare: ");
				File nomeFile = new File(in.nextLine());
				createReader(nomeFile);

				System.out.println("Inserire path del terzo file da cercare: ");
				File cognomeFile = new File(in.nextLine());
				createReader(cognomeFile);


				System.out.println("Inserire path del quarto file da cercare: ");
				File emailFile = new File(in.nextLine());
				createReader(emailFile);

				System.out.println("Inserire path del quinto file da cercare: ");
				File telFile = new File(in.nextLine());
				createReader(telFile);
			}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createReader(File file) {
		try{
			FileReader reader = new FileReader(file);
			writeFile(f, reader);
		}catch(IOException e){
			e.printStackTrace();
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
