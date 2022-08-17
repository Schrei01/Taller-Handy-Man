import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InicioComponent } from './pages/inicio/inicio.component';

import {ButtonModule} from 'primeng/button';



@NgModule({
  declarations: [
    InicioComponent
  ],
  exports: [
    InicioComponent
  ],
  imports: [
    CommonModule,
    ButtonModule
  ]
})
export class InicioModule { }
