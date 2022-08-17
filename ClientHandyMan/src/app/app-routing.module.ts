import { Component, NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AppComponent } from "./app.component";
import { HorastrabajadasComponent } from "./consulta/pages/horastrabajadas/horastrabajadas.component";
import { InicioComponent } from "./inicio/pages/inicio/inicio.component";
import { RegistrarServicioComponent } from "./registro/pages/registrar-servicio/registrar-servicio.component";


const routes: Routes = [
    {
        path: '',
        component: InicioComponent,
        pathMatch: 'full'
    },
    {
        path: 'registrar',
        component: RegistrarServicioComponent
    },
    {
        path: 'consultar',
        component: HorastrabajadasComponent
    },
    {
        path: '**',
        redirectTo: ''
    }
]

@NgModule({
    imports: [
        RouterModule.forRoot( routes )
    ],
    exports:[
        RouterModule
    ]
})
export class AppRoutingModule {}