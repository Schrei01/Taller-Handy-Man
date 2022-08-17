package com.handyman.ias.application.services;

import com.handyman.ias.application.ports.output.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetHours implements com.handyman.ias.application.ports.input.GetHoursUseCase {
    private final ReportRepository reportRepository;

    public GetHours(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public HoursResult execute(String s, Integer numWeek) {
        CalculateHours c = new CalculateHours();
        return c.hours(this.reportRepository.getHours(s, numWeek), s);
    }
}
