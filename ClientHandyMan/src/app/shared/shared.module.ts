import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SidebarComponent } from './sidebar/sidebar.component';

import {ButtonModule} from 'primeng/button';
import { MenubarModule } from 'primeng/menubar';
import { InputTextModule } from 'primeng/inputtext';
import { FooterComponent } from './footer/footer.component';



@NgModule({
  declarations: [
    SidebarComponent,
    FooterComponent
  ],
  exports: [
    SidebarComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
    MenubarModule,
    ButtonModule,
    InputTextModule
  ]
})
export class SharedModule { }
