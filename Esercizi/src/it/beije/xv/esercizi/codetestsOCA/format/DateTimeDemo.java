package it.beije.xv.esercizi.codetestsOCA.format;

import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeDemo {
	public static void main(String[] args) {
		//LocalDate d = LocalDate.now();
		//specifying date
		/*
		LocalDate d = LocalDate.of(1995, Month.JANUARY, 8);
		System.out.println(d);
		
		//LocalTime t = LocalTime.now();
		LocalTime t = LocalTime.of(12, 35, 10 );
		System.out.println(t);
		
		System.out.println(LocalDateTime.now());
		
		LocalDateTime dt = LocalDateTime.of(d, t);
		System.out.println(dt);
		*/
		LocalDateTime dt2 = LocalDateTime.of(2022, Month.FEBRUARY, 28, 13, 13, 13);
		System.out.println(dt2);
	}
	
	
}
