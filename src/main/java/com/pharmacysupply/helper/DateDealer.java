package com.pharmacysupply.helper;

import com.pharmacysupply.entity.RepSchedule;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
/*
this is a helper class which will help to configure and increment the date according to the business project logic
The dateDealer function takes the doctor_list as an input and the starting date it get from the api
to return the list with the dates properly set into the list
 */
public class DateDealer {
    public static List<RepSchedule> placeDates(List<RepSchedule> list, LocalDate startingDate){
        LocalDate d=startingDate;
        list.get(0).setDate(d);
        LocalDate dd=d;

        for(int i=1;i<list.size();i++) {
            DayOfWeek k=dd.getDayOfWeek();
            if(k.getValue()==6){
                //If the day encountered is sunday, then skip the sunday and move to next date ie, monday.
                dd=dd.plusDays(2);

                list.get(i).setDate(dd);
            }else {
                //if the day encountered is not sunday, move to next day.
                dd = dd.plusDays(1);
                list.get(i).setDate(dd);
                //all days
            }

        }
        return list;
    }
}
