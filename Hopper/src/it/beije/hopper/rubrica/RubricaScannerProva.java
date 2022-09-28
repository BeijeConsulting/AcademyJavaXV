package it.beije.hopper.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import it.beije.hopper.Contatto;

public class RubricaScannerProva {

	static List contatti = new ArrayList();

	public static void main(String[] args) throws IOException {
		
		
		String st = null;
		String pathFile = "C:\\Users\\caste\\OneDrive\\Desktop\\BeijeAcademy\\Rubrica\\RubricaScanner\\rubrica.csv";
		
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready())
		{
			String linea = bufferedReader.readLine()+"\n";
			contatti.add(linea);
		}
			
	
	//File file = new File(pathFile);
	List<Contatto> contatti = new ArrayList<>();
		
	while(st!="0")
	{
		System.out.println("Selezionare operazione: \n 1: Leggi rubrica \n 2: aggiungi numero \n 0: esci \n");
		
		Scanner s = new Scanner(System.in);
		st = s.next();
		
			switch(st)
			{
			case "1":
				loadRubricaFromCSV(pathFile, ";");
				break;
			case "2":
			{
				writeRubricaCSV( pathFile, ";");	
				//System.out.println(contatti);
				break;
			}
			case "0":
				System.out.println("BYE!!");
				s.close();
				System.exit(0);				
			}
		}

	}

	
	public static List loadRubricaFromCSV(String pathFile, String separator) throws IOException
	{
		
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List c = contatti;
		while (bufferedReader.ready())
		{			
			c.add(bufferedReader.readLine());
		}
		for (int i = 0; i < contatti.size(); i++)
			System.out.println(contatti.get(i));
		return c;
		
	}
	
	public static void writeRubricaCSV(String pathFile, String separator) throws IOException 
	{

		Contatto contatto = new Contatto();	
		
		Scanner s = new Scanner(System.in);		
		System.out.println("Inserisci Cognome: ");	
		String st1 = s.next();
		contatto.setCognome(st1);
		
		System.out.println("Inserisci Nome: ");	
		String st2 = s.next();
		contatto.setNome(st2);
		
		System.out.println("Inserisci Email: ");
		String st3 = s.next();
		contatto.setEmail(st3);
		
		System.out.println("Inserisci Telefono: ");		
		String st4 = s.next();
		contatto.setTelefono(st4);
		
		System.out.println("Inserisci Note: ");		
		String st5 = s.next();
		contatto.setNote(st5);
		
//		System.out.println(contatto.getNome() + " " + contatto.getCognome() + " " + contatto.getEmail() + " " + contatto.getTelefono() + " " + contatto.getEmail());
		contatti.add(st1+";"+st2+";"+st3+";"+st4+";"+st5+"\n");
		
		FileWriter fileWriter = new FileWriter(pathFile);
		
		for(int i = 0; i < contatti.size(); i++)
			fileWriter.write(contatti.get(i).toString());
		fileWriter.flush();
	}

}
