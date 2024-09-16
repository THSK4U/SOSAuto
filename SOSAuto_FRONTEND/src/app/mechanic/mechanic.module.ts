import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MechanicRoutingModule } from './mechanic-routing.module';
import { MechanicComponent } from './mechanic.component';
import { SidebarComponent } from './ListSuggestions/sidebar.component';
import { MapComponent } from './map/map.component';
import {AppModule} from "../app.module";
import {NavbarComponent} from "./navbar/navbar.component";


@NgModule({
  declarations: [
    MechanicComponent,
    SidebarComponent,
    MapComponent,
    NavbarComponent
  ],
    exports: [

    ],
  imports: [
    CommonModule,
    MechanicRoutingModule,

  ]
})
export class MechanicModule { }
