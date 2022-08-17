package com.handyman.ias.application.services;

import com.handyman.ias.infrastructure.models.ReportServDTO;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class CalculateHoursTest {
    @Test
    public void should_return_algo_when_service_is_one_day(){
     HoursResult result = new HoursResult(
        "12345688",
        "0:0",
        "0:0",
        "0:0",
        "0:0",
        "0:0",
        "0:0"
     );
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,19,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,19,00,00);

        ReportServDTO reportServDTO = new ReportServDTO(
        0L,
        "idServ",
        "12345688",
                startDate,
                endDate
        );
        String idTech = "12345688";
        List<ReportServDTO> list = new ArrayList<>();
        list.add(reportServDTO);

        Assert.assertEquals(result,CalculateHours.hours(list,idTech));

    }
}