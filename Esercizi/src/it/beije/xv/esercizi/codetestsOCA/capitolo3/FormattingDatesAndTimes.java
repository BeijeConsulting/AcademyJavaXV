package it.beije.xv.esercizi.codetestsOCA.capitolo3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormattingDatesAndTimes {
	
	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time = LocalTime.of(11, 12, 34);
		
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		
		System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		
		
		
		System.out.println("----------------------------");
		
		DateTimeFormatter shortDateTime = 
				DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(shortDateTime.format(dateTime));
		System.out.println(dateTime.format(shortDateTime));
		System.out.println("---------------------");
		
		System.out.println(dateTime.format(shortDateTime));
		System.out.println(date.format(shortDateTime));
		
		
		
	}
	
	
}
