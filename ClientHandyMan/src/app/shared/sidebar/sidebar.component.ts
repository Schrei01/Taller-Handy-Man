import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {

    items!: MenuItem[];

    ngOnInit() {
        this.items = [
            {
                label:'¿Quiénes somos?',
                icon:'pi pi-fw pi-user'
            },
            {
                label:'Contáctanos',
                icon:'pi pi-fw pi-phone'
            }
        ];
    }   
}
