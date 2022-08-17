import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reporte } from '../interfaces/report-interface';

@Injectable({
  providedIn: 'root'
})
export class ReportarServiceService {

  private apiUrl: string = 'http://localhost:8080/handyMan/guardarReporte'
  constructor(private http: HttpClient) { }

  saveReport(report: Reporte): Observable<Reporte>{
    return this.http.post<Reporte>(`${ this.apiUrl }`, report);
  }
}
