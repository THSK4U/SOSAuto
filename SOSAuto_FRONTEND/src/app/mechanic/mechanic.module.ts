import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MechanicRoutingModule } from './mechanic-routing.module';
import { MechanicComponent } from './mechanic.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './ListSuggestions/sidebar.component';
import { MapComponent } from './map/map.component';


@NgModule({
    declarations: [
        MechanicComponent,
        NavbarComponent,
        SidebarComponent,
        MapComponent
    ],
    exports: [
        NavbarComponent
    ],
    imports: [
        CommonModule,
        MechanicRoutingModule
    ]
})
export class MechanicModule { }
