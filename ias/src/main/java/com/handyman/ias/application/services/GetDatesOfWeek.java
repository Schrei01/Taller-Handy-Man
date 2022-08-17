package com.handyman.ias.application.services;

import com.handyman.ias.application.domian.valueobjects.Dates;

import java.time.LocalDateTime;
import java.util.Calendar;

public class GetDatesOfWeek {

    public Dates getDates(int numWeek){
        Calendar init = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        init.setWeekDate(2022, numWeek, Calendar.SUNDAY);
        end.setWeekDate(2022, numWeek, Calendar.SATURDAY);
        LocalDateTime initWeek = LocalDateTime.ofInstant(init.toInstant(), init.getTimeZone().toZoneId());
        LocalDateTime endWeek = LocalDateTime.ofInstant(end.toInstant(), end.getTimeZone().toZoneId());
        initWeek = LocalDateTime.of(initWeek.getYear(),initWeek.getMonth(),initWeek.getDayOfMonth(),0,0);
        endWeek =LocalDateTime.of(endWeek.getYear(),endWeek.getMonth(),endWeek.getDayOfMonth(),23,59);
        return new Dates(initWeek, endWeek);
    }
}
