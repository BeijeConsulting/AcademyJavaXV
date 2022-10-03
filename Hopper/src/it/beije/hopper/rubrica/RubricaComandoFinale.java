package it.beije.hopper.rubrica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static it.beije.hopper.rubrica.RubricaHibernate.*;
import static it.beije.hopper.rubrica.JDBCMetodi.*;


public class RubricaComandoFinale {
		static String st;
		static String pathFile = "C:\\Users\\caste\\OneDrive\\Desktop\\BeijeAcademy\\Rubrica\\RubricaScanner\\rubrica.csv";
		static List contatti = new ArrayList();
		
		
	
		public static void main(String[] args) throws IOException, SQLException {
		
		
		refresh();
		menu();
		

	}
	
	public static void menu() throws IOException, SQLException
	{
		
		 
		while(st!="0")
		{
			System.out.println("Selezionare operazione: \n 1: Leggi rubrica \n 2: Aggiungi contatto \n 3: Cerca contatto \n 4: Modifica contatto "
					+ "\n 5: Elimina contatto \n 6: Esporta in CSV \n 0: esci \n");
			
			Scanner s = new Scanner(System.in);
			st = s.next();
			
				switch(st)
					{
						case "1":
						{							
							readDB();
							
							break;
						}
						case "2":
						{
							writeDB();
							break;
						}
						case "3":
						{
							search();
							break;
						}
						case "4":
						{
							updateContatto();
							break;
						}
						case "5":
						{
							deleteFromDB();
							break;
						}
						case "6":
						{
							toCSV();
							break;
						}
						case "0":
						{
							System.out.println("BYE!!");
							s.close();
							System.exit(0);	
						}
					}
			}
	}
	
	public static void refresh() throws IOException
	{
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready())
		{
			String linea = bufferedReader.readLine()+"\n";
			contatti.add(linea);
		}
	}
}
