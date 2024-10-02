import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MechanicRoutingModule } from './mechanic-routing.module';
import { MechanicComponent } from './mechanic.component';
import { SidebarComponent } from './ListSuggestions/sidebar.component';
import { MapComponent } from './map/map.component';
import {NavbarComponent} from "./navbar/navbar.component";
import {MatIconModule} from "@angular/material/icon";
import { ProfileComponent } from './profile/profile.component';
import { HomeComponent } from './home/home.component';
import { ParticipationComponent } from './participation/participation.component';
import { ListParticipationComponent } from './participation/list-participation/list-participation.component';
import { DisponibiliteComponent } from './disponibilite/disponibilite.component';
import {MatButtonModule} from "@angular/material/button";


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
  ], exports: [
        ListParticipationComponent
    ],
    imports: [
        CommonModule,
        MechanicRoutingModule,
        MatIconModule,
        MatButtonModule,

    ]
})
export class MechanicModule { }
