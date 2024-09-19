import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MechanicRoutingModule } from './mechanic-routing.module';
import { MechanicComponent } from './mechanic.component';
import { SidebarComponent } from './ListSuggestions/sidebar.component';
import { MapComponent } from './map/map.component';
import {AppModule} from "../app.module";
import {NavbarComponent} from "./navbar/navbar.component";
import {MatIconModule} from "@angular/material/icon";
import { ProfileComponent } from './profile/profile.component';
import { HomeComponent } from './home/home.component';
import {AppComponent} from "../app.component";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { ParticipationComponent } from './participation/participation.component';
import { ListParticipationComponent } from './participation/list-participation/list-participation.component';
import { DisponibiliteComponent } from './disponibilite/disponibilite.component';


@NgModule({
  declarations: [
    MechanicComponent,
    SidebarComponent,
    MapComponent,
    NavbarComponent,
    ProfileComponent,
    HomeComponent,
    ParticipationComponent,
    ListParticipationComponent,
    DisponibiliteComponent
  ],exports: [
    ],
  imports: [
    CommonModule,
    MechanicRoutingModule,
    MatIconModule,

  ]
})
export class MechanicModule { }
