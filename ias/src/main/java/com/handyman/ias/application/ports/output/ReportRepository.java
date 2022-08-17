package com.handyman.ias.application.ports.output;

import com.handyman.ias.infrastructure.models.ReportServDTO;

import java.util.List;

public interface ReportRepository {
    ReportServDTO save(ReportServDTO reportServDTO);

    List<ReportServDTO> getHours(String idTech, int numWeek);
}
