import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { datos } from '../interfaces/result-interfaces';

@Injectable({
  providedIn: 'root'
})
export class ConsultarService {

  private apiUrl: string = 'http://localhost:8080/handyMan/horasTrabajadas'
  constructor(private http: HttpClient) { }

  gethours(idTech: string, numweek: string): Observable<datos>{
    const url = `${ this.apiUrl }/${ idTech }&${ numweek }`
    return this.http.get<datos>( url );
  }

}
