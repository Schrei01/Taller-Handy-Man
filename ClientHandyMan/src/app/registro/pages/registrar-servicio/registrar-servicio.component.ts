import { Component, OnInit } from '@angular/core';
import { Reporte } from '../../interfaces/report-interface';
import { ReportarServiceService } from '../../services/reportar-service.service';

@Component({
  selector: 'app-registrar-servicio',
  templateUrl: './registrar-servicio.component.html',
  styleUrls: ['./registrar-servicio.component.css']
})
export class RegistrarServicioComponent implements OnInit {

  start = new Date();
  end = new Date();

  report: Reporte = {
    id:           0,
    idServ:       '',
    idTechnician: '',
    initDate:       this.start,
    endDate:        this.end,
  }
  constructor(private registrarService: ReportarServiceService) { }

  ngOnInit(): void {
  }
  sendReport(report: Reporte){
    console.log(report.initDate);
    this.registrarService.saveReport(report)
    .subscribe(resp =>{
      console.log(resp);
    })
  }
}
