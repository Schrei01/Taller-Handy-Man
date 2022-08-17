package com.handyman.ias.application.services;

import com.handyman.ias.application.ports.input.SaveUseCase;
import com.handyman.ias.application.ports.output.ReportRepository;
import com.handyman.ias.infrastructure.models.ReportServDTO;
import org.springframework.stereotype.Service;

@Service
public class SaveReport implements SaveUseCase {
    private final ReportRepository reportRepository;

    public SaveReport(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public ReportServDTO execute(ReportServDTO reportServDTO) {
        return reportRepository.save(reportServDTO);
    }
}
