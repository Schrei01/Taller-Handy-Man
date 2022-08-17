import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistrarServicioComponent } from './pages/registrar-servicio/registrar-servicio.component';

import {InputTextModule} from 'primeng/inputtext';
import {CalendarModule} from 'primeng/calendar';
import {ButtonModule} from 'primeng/button';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    RegistrarServicioComponent
  ],
  exports: [
    RegistrarServicioComponent
  ],
  imports: [
    CommonModule,
    InputTextModule,
    CalendarModule,
    ButtonModule,
    FormsModule
  ]
})
export class RegistroModule { }
