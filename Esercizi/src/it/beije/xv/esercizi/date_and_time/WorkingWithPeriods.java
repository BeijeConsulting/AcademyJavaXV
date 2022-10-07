package it.beije.xv.esercizi.date_and_time;

import java.time.*;

public class WorkingWithPeriods {
//    public static void main(String[] args){
//        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
//        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
//        Period period = Period.ofMonths(1);
//
////        performAnimalEnrichment(start, end);
//        performAnimalEnrichment(start, end, period);
//    }
//    private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period){
//        LocalDate upTo = start;
//        while( upTo.isBefore(end) ){
//            System.out.println("give new toy: " + upTo);
//            upTo = upTo.plus(period);
//        }
//    }


//    private static void performAnimalEnrichment(LocalDate start, LocalDate end){
//        LocalDate upTo = start;
//        while(upTo.isBefore(end)){
//            System.out.println("give new toy: " + upTo);
//            upTo = upTo.plusMonths(1);
//        }
//
//    }
    public static void main(String[] args){
        /*
          You cannot chain methods when creating a period.
          The following to line of code might look equivalent but are not
        * */
        Period everyYearAndWeek = Period.of(1, 0, 7);
        System.out.println(everyYearAndWeek);
        Period wrong = Period.ofYears(1).ofWeeks(1);
        System.out.println(wrong);


        //Duration --> days, hours, minutes, seconds or nanoseconds

        // /// ////////

        LocalDate date = LocalDate.of(2015, 1, 20);
        LocalTime time = LocalTime.of(6, 15);

        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Period period = Period.ofMonths(1);

        System.out.println(date.plus(period));
        System.out.println(dateTime.plus(period));
        System.out.println(time.plus(period));
    }
}
