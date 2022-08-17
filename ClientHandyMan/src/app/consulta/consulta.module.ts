import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


import {InputTextModule} from 'primeng/inputtext';
import {InputNumberModule} from 'primeng/inputnumber';
import {ButtonModule} from 'primeng/button';

import { HorastrabajadasComponent } from './pages/horastrabajadas/horastrabajadas.component';



@NgModule({
  declarations: [
    HorastrabajadasComponent
  ],
  exports: [
    HorastrabajadasComponent
  ],
  imports: [
    CommonModule,
    InputTextModule,
    InputNumberModule,
    ButtonModule,
    FormsModule
  ]
})
export class ConsultaModule { }
