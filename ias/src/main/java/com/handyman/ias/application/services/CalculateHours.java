package com.handyman.ias.application.services;

import com.handyman.ias.infrastructure.models.ReportServDTO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;



public class CalculateHours {

    public static HoursResult hours(List<ReportServDTO> list, String s) {
        int normalMinutes = 0;
        int nocturneMinutes = 0;
        int sundayMinutes = 0;
        int extraNormalMinutes = 0;
        int extraNocturneMinutes = 0;
        int extraSundayMinutes = 0;
        int auxExtraNormalMinutes = 0;
        int auxExtraNocturneMinutes = 0;
        int auxExtraSundayMinutes = 0;
        HoursResult result = new HoursResult();


        for (ReportServDTO date : list){
            LocalDateTime initServ = date.getInitDate();
            LocalDateTime endServ = date.getEndDate();

                if (initServ.getDayOfWeek() == endServ.getDayOfWeek()){
    
                    //Horas normales L-S 07:00 a 20:00
                    if (
                            initServ.get(ChronoField.DAY_OF_WEEK) != 7
                                    && 7*60 <= initServ.get(ChronoField.MINUTE_OF_DAY)
                                    && endServ.get(ChronoField.MINUTE_OF_DAY) <= 20*60
                    ){
    
                        int auxNormalMinutes = endServ.get(ChronoField.MINUTE_OF_DAY) - initServ.get(ChronoField.MINUTE_OF_DAY);
                        normalMinutes += auxNormalMinutes;
                    }
                    // Horas normales L-S 07:00 a 20:00 y Horas nocturnas L-S 00:00 a 07:00
                    if (
                            initServ.get(ChronoField.DAY_OF_WEEK) != 7 &&
                                    initServ.get(ChronoField.MINUTE_OF_DAY) < 7*60 &&
                                    7*60 < endServ.get(ChronoField.MINUTE_OF_DAY) && endServ.get(ChronoField.MINUTE_OF_DAY) <= 20*60
                    ) {
                        int auxNocturneMinutes3 = 7*60 - initServ.get(ChronoField.MINUTE_OF_DAY);
                        int auxNormalMinutes3 = endServ.get(ChronoField.MINUTE_OF_DAY) - 7*60;
                        normalMinutes += auxNormalMinutes3;
                        nocturneMinutes += auxNocturneMinutes3;
                    }
                    // Horas normales L-S 07:00 a 20:00 y Horas nocturnas L-S 20:00 a 24:00
                    if (
                            initServ.get(ChronoField.DAY_OF_WEEK) != 7 &&
                                    7*60 <= initServ.get(ChronoField.MINUTE_OF_DAY) && initServ.get(ChronoField.MINUTE_OF_DAY) <= 20*60 &&
                                    endServ.get(ChronoField.MINUTE_OF_DAY) > 20*60
                    ){
                        int auxNocturneMinutes4 = endServ.get(ChronoField.MINUTE_OF_DAY) - 20*60;
                        int auxNormalMinutes4 = 20*60 - initServ.get(ChronoField.MINUTE_OF_DAY);
                        normalMinutes += auxNormalMinutes4;
                        nocturneMinutes += auxNocturneMinutes4;
                    }
                    //Horas nocturnas L-S 20:00 a 24:00
                    if (
                            initServ.get(ChronoField.DAY_OF_WEEK) != 7 &&
                                    20*60 <= initServ.get(ChronoField.MINUTE_OF_DAY) &&
                                    endServ.get(ChronoField.MINUTE_OF_DAY) <= 24*60
                    ){
                        int auxNocturneMinutes = endServ.get(ChronoField.MINUTE_OF_DAY) - initServ.get(ChronoField.MINUTE_OF_DAY);
                        nocturneMinutes += auxNocturneMinutes;
                    }
                    //Horas nocturnas L-S 00:00 a 07:00
                    if (
                            initServ.get(ChronoField.DAY_OF_WEEK) != 7 &&
                                    0 <= initServ.get(ChronoField.MINUTE_OF_DAY) &&
                                    endServ.get(ChronoField.MINUTE_OF_DAY) <= 7*60
                    ){
                        int auxNocturneMinute2 = endServ.get(ChronoField.MINUTE_OF_DAY) - initServ.get(ChronoField.MINUTE_OF_DAY);
                        nocturneMinutes += auxNocturneMinute2;
                    }
                    //Horas dominicales
                    if (initServ.get(ChronoField.DAY_OF_WEEK) == 7){
                        int auxSundayMinutes = endServ.get(ChronoField.MINUTE_OF_DAY) - initServ.get(ChronoField.MINUTE_OF_DAY);
                        sundayMinutes += auxSundayMinutes;
                    }
                    if(     initServ.get(ChronoField.DAY_OF_WEEK) != 7
                            && 7*60 >= initServ.get(ChronoField.MINUTE_OF_DAY)
                            && endServ.get(ChronoField.MINUTE_OF_DAY) >= 20*60){
                        int auxNocturneMinutes5 = (7*60 - initServ.get(ChronoField.MINUTE_OF_DAY)) + (endServ.get(ChronoField.MINUTE_OF_DAY) - 20*60);
                        int auxNormalMinutes5 = 13*60;
                        nocturneMinutes += auxNocturneMinutes5;
                        normalMinutes += auxNormalMinutes5;
                    }
                }

            if (normalMinutes + nocturneMinutes + sundayMinutes > 48*60){
                int aux = 48*60 - auxExtraNormalMinutes - auxExtraNocturneMinutes - auxExtraSundayMinutes;
                System.out.println(aux);
                if (initServ.get(ChronoField.MINUTE_OF_DAY)<7*60){
                    extraNocturneMinutes += nocturneMinutes - auxExtraNocturneMinutes - aux;
                    extraNormalMinutes += normalMinutes - auxExtraNormalMinutes;
                    extraSundayMinutes += sundayMinutes - auxExtraSundayMinutes;
                }
                if (7*60<=initServ.get(ChronoField.MINUTE_OF_DAY) && initServ.get(ChronoField.MINUTE_OF_DAY)<=20*60){
                    extraNocturneMinutes += nocturneMinutes - auxExtraNocturneMinutes;
                    extraNormalMinutes += normalMinutes - auxExtraNormalMinutes - aux;
                    extraSundayMinutes += sundayMinutes - auxExtraSundayMinutes;
                }
                if (initServ.get(ChronoField.MINUTE_OF_DAY)>20*60){
                    extraNocturneMinutes += nocturneMinutes - auxExtraNocturneMinutes;
                    extraNormalMinutes += normalMinutes - auxExtraNormalMinutes;
                    extraSundayMinutes += sundayMinutes - auxExtraSundayMinutes- aux;
                }
            }
            auxExtraNormalMinutes = normalMinutes;
            auxExtraNocturneMinutes = nocturneMinutes;
            auxExtraSundayMinutes = sundayMinutes;
        }

        String normalHours = (normalMinutes - extraNormalMinutes)/60    + ":" + (normalMinutes - extraNormalMinutes)%60;
        String nocturneHours = (nocturneMinutes - extraNocturneMinutes)/60  + ":" + (nocturneMinutes - extraNocturneMinutes)%60;
        String sundayHours = (sundayMinutes - extraSundayMinutes)/60    + ":" + (sundayMinutes - extraSundayMinutes)%60;
        String extraNormalHours = extraNormalMinutes/60     + ":" + extraNormalMinutes%60;
        String extraNocturneHours = extraNocturneMinutes/60 + ":" + extraNocturneMinutes%60;
        String extraSundayHours = extraSundayMinutes/60 + ":" + extraSundayMinutes%60;

        result.setIdTech(s);
        result.setNormalHours(normalHours);
        result.setNocturneHours(nocturneHours);
        result.setSundayHours(sundayHours);
        result.setExtraNormalHours(extraNormalHours);
        result.setExtraNocturneHours(extraNocturneHours);
        result.setExtraSundayHours(extraSundayHours);

        return result;
    }



}
