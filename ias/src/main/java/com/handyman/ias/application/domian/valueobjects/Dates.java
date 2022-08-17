package com.handyman.ias.application.domian.valueobjects;

import com.handyman.ias.application.ports.commons.Considerations;
import lombok.Data;
import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

@Data
public class Dates {
    private LocalDateTime initDate;
    private LocalDateTime endDate;

    public Dates(LocalDateTime initDate, LocalDateTime endDate) {
        Considerations.checkDate(initDate, endDate, "La fecha de finalización es menor a la fecha de inicio");
        Validate.notNull(initDate,"La fecha de inicio no puede ser nula");
        Validate.notNull(endDate, "La fecha de finalización no puede ser nula");
        this.initDate = initDate;
        this.endDate = endDate;
    }
}
