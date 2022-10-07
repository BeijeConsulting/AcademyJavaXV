package it.beije.xv.esercizi.date_and_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class CreatingDatesAndTimes {
    public static void main(String[] argss){
//        System.out.println(LocalDate.now());
//        System.out.println(LocalTime.now());
//        System.out.println(LocalDateTime.now());

        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 01, 20);
//
//        System.out.println(date1 +"\n"+date2);


        LocalTime time1 = LocalTime.of(6, 15);
        LocalTime time2 = LocalTime.of(6, 15, 30);
        LocalTime time3 = LocalTime.of(6, 15, 30 , 200);
//        System.out.println(time1);
//        System.out.println(time2);
//        System.out.println(time3);

        LocalDateTime dateTime0 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 16);
        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 16, 30);
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);

        System.out.println(dateTime0);
        System.out.println(dateTime1);
        System.out.println(dateTime2);


    }
}
