package com.handyman.ias.infrastructure.controllers;


import com.handyman.ias.application.ports.input.GetHoursUseCase;
import com.handyman.ias.application.ports.input.SaveUseCase;
import com.handyman.ias.application.services.HoursResult;
import com.handyman.ias.infrastructure.models.ReportServDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/handyMan")
public class ReportController {

    private final SaveUseCase saveUseCase;
    private final GetHoursUseCase getHoursUseCase;

    public ReportController(SaveUseCase saveUseCase, GetHoursUseCase getHoursUseCase) {
        this.saveUseCase = saveUseCase;
        this.getHoursUseCase = getHoursUseCase;
    }

    @PostMapping("/guardarReporte")
    public ReportServDTO saveReport(@RequestBody ReportServDTO reportServDTO){

        reportServDTO.setInitDate(reportServDTO.getInitDate().plusHours(-5));
        reportServDTO.setEndDate(reportServDTO.getEndDate().plusHours(-5));

        return saveUseCase.execute(reportServDTO);
    }

    @GetMapping("/horasTrabajadas/{idTech}&{numWeek}")
    public HoursResult workHours(@PathVariable String idTech,
                                 @PathVariable int numWeek){
        return getHoursUseCase.execute(idTech, numWeek);
    }

}
