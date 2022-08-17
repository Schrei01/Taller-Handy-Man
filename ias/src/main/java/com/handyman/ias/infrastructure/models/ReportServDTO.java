package com.handyman.ias.infrastructure.models;


import com.handyman.ias.application.domian.ReportServ;
import com.handyman.ias.application.domian.valueobjects.Dates;
import com.handyman.ias.application.domian.valueobjects.IdServ;
import com.handyman.ias.application.domian.valueobjects.IdTechnician;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ReportServDTO {
    private Long id;
    private String idServ;
    private String idTechnician;
    private LocalDateTime initDate;
    private LocalDateTime endDate;


    public ReportServ toDomain() {
        return new ReportServ(
                id,
                new IdServ(idServ),
                new IdTechnician(idTechnician),
                new Dates(initDate, endDate)
        );
    }

    public static ReportServDTO fromDomain(ReportServ reportServ){
        return new ReportServDTO(
                reportServ.getId(),
                reportServ.getIdServ().getValue(),
                reportServ.getIdTechnician().getValue(),
                reportServ.getDates().getInitDate(),
                reportServ.getDates().getEndDate()
        );
    }

    public ReportServDAO ToDAO(){
        return new ReportServDAO(
                id,
                idServ,
                idTechnician,
                initDate,
                endDate
        );
    }
}


