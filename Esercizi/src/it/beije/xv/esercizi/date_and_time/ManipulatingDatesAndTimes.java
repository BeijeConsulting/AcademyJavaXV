package it.beije.xv.esercizi.date_and_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class ManipulatingDatesAndTimes {
    public final static void main(String[] args){
//        System.out.println("Ciao");

//        LocalDate date = LocalDate.of(2014, Month.JANUARY,20 );
//        System.out.println(date);
//        date = date.plusDays(2).plusDays(2);
//        System.out.println(date);
//        date = date.plusWeeks(1);
//        System.out.println(date);


        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(5, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        System.out.println(dateTime);
        dateTime = dateTime.minusSeconds(20);
        System.out.println(dateTime);
    }
}
