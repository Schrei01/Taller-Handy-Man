import { Component, OnInit } from '@angular/core';
import { datos } from '../../interfaces/result-interfaces';
import { ConsultarService } from '../../services/consultar.service';

@Component({
  selector: 'app-horastrabajadas',
  templateUrl: './horastrabajadas.component.html',
  styleUrls: ['./horastrabajadas.component.css']
})
export class HorastrabajadasComponent implements OnInit {

  show: boolean = false;
  idTech: string = '';
  numweek: string = '';
  datos: datos = {
    idTech: '',
    normalHours: '',
    nocturneHours: '',
    sundayHours: '',
    extraNormalHours: '',
    extraNocturneHours: '',
    extraSundayHours: ''
  };
  
  
  constructor(private consultarService: ConsultarService) { }

  ngOnInit(): void {
  }

  senddatas(){
    this.consultarService.gethours( this.idTech, this.numweek )
    .subscribe( datos =>{
      this.datos = datos;
      if(datos != null){
        this.show = true;
      }
    } );    
  }
}
