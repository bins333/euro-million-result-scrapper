package com.bj;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

public class EuroMillionDrawDateUtils {

    public static ArrayList<String> getDrawDates(){

        LocalDate tempDate = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate euroTuesday = tempDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY));
        LocalDate euroFriday = tempDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));

        ArrayList<String> euroLotteryDates =  new ArrayList<>();

        while ((euroTuesday.isBefore(LocalDate.now()) || euroFriday.isBefore(LocalDate.now()))) {

            //System.out.println(euroFriday + " is " + euroFriday.getDayOfWeek());

            euroLotteryDates.add(euroFriday.toString());
            euroLotteryDates.add(euroTuesday.toString());

            euroFriday = euroFriday.plusDays(7);
            euroTuesday = euroTuesday.plusDays(7);

        }

        euroLotteryDates.remove(euroLotteryDates.size()-1);

        return euroLotteryDates;
    }
}
