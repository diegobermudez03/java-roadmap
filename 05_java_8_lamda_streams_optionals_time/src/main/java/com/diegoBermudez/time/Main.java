package com.diegoBermudez.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        //dates
        LocalDate ld = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2020, 8, 30);
        LocalDate ld3 = LocalDate.of(2021, Month.APRIL, 14);
        System.out.println(ld);
        System.out.println(ld2);
        System.out.println(ld3);


        System.out.println("---------------------------------------");
        //times
        LocalTime t1  = LocalTime.now();
        LocalTime t2 = LocalTime.of(14,25);
        LocalTime t3 = LocalTime.of(20, 41, 21, 10);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);


        System.out.println("---------------------------------------");
        //date and times
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.of(ld2, t2);
        LocalDateTime ldt3 = LocalDateTime.of(2024, 9, 14, 22, 14);
        System.out.println(ldt);
        System.out.println(ldt2);
        System.out.println(ldt3);


        System.out.println("---------------------------------------");
        //Zoned date and times
        /*for(String zone: ZoneId.getAvailableZoneIds()){
            System.out.println(zone);
        }*/
        ZonedDateTime zt = ZonedDateTime.of(ldt2, ZoneId.of("Europe/Athens"));
        ZonedDateTime zt2 = ZonedDateTime.of(2024, 10 , 5, 14, 59, 12, 10, ZoneId.of("Europe/Athens"));
        System.out.println(zt);
        System.out.println(zt2);


        System.out.println("-------------------------------------------------------------");
        //Calculations
        LocalDate newDate = LocalDate.of(2021,10, 5).plusMonths(7);
        System.out.println(newDate);
        LocalDate newDate2 = newDate.minusDays(5);
        System.out.println(newDate2);
        LocalTime lt = LocalTime.of(12, 20).minusHours(5);
        System.out.println(lt);


        System.out.println("-------------------------------------------------------------");
        //format dates
        DateTimeFormatter dtf = DateTimeFormatter.ISO_WEEK_DATE;
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd.MMMM.yyyy");
        System.out.println(dtf.format(zt));
        System.out.println(dtf2.format(ld3));
        System.out.println(ld3.format(dtf2));


        System.out.println("------------------------------------------------------------");
        //asking for time of specific zone
        System.out.println(LocalTime.now(ZoneId.of("Europe/Athens")));


        System.out.println("------------------------------------------------------------");
        //Instant, this is non human readable but machine readable GMT
        System.out.println(Instant.now());
        System.out.println(Instant.now().minusSeconds(100000));
    }
}
