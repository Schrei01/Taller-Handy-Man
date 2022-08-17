package com.handyman.ias.application.domian;

import com.handyman.ias.application.domian.valueobjects.Dates;
import com.handyman.ias.application.domian.valueobjects.IdServ;
import com.handyman.ias.application.domian.valueobjects.IdTechnician;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportServ {

    private Long id;
    private IdServ idServ;
    private IdTechnician idTechnician;
    private Dates dates;
}
