package com.handyman.ias.application.ports.commons;

import java.time.LocalDateTime;

public class Considerations {

    private Considerations(){}

    public static void checkDate(LocalDateTime initDate, LocalDateTime endDate, String message) {
        if (endDate.compareTo(initDate) < 0){
            throw new RuntimeException(message);
        }
    }
}
