package it.beije.java.xv.esercizi.stringhe;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.time.format.FormatStyle;
import java.time.temporal.IsoFields;
import java.util.Scanner;
/*
2 Realizzare un programma che, ricevuta in input una data in 
formato 13/09/2021 stampi le seguenti informazioni:
Lunedì 13 Settembre, giorno 256 dell'anno 2021, settimana numero 37
in italiano od inglese, va bene comunque
*/
public class DataInFormato {
	//Scanner scanner = new Scanner(System.in);
	
	//Lunedì 13 Settembre, giorno 256 dell'anno 2021, settimana numero 37
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		

		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date2 = LocalDate.parse(string, f);
		int week = date2.get ( IsoFields.WEEK_OF_WEEK_BASED_YEAR );
		
		//System.out.println(date.format(f));
		
		System.out.println(date2.format(f));
		
		//"Lunedì 13 Settembre, giorno 256 dell'anno 2021, settimana numero 37"
		//Monday 13 Sept, 256th day of the year 2021, week number
		System.out.println(date2.getDayOfWeek() + " " + date2.getDayOfMonth() 
			+ " " + date2.getMonth() 
			+ ", "+ date2.getDayOfYear() + "th day of the year " + date2.getYear() +
			", " +" week number "
			+ week);
		
		scanner.close();
	}
	
	
	
}


