import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MotoristRoutingModule } from './motorist-routing.module';
import { MotoristComponent } from './motorist.component';
import { MapMotoristComponent } from './map-motorist/map-motorist.component';
import { ListSuggestionsComponent } from './list-suggestions/list-suggestions.component';
import { CreatdemandeComponent } from './creatdemande/creatdemande.component';
import {FormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatDialogModule} from "@angular/material/dialog";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatCardModule} from "@angular/material/card";
import {NavbarComponent} from "./navbar/navbar.component";
import { HomeComponent } from './home/home.component';
import { HistoriqueComponent } from './historique/historique.component';
import { ParticipationDemandeComponent } from './participation-demande/participation-demande.component';



@NgModule({
  declarations: [
    MotoristComponent,
    MapMotoristComponent,
    ListSuggestionsComponent,
    CreatdemandeComponent,
    NavbarComponent,
    HomeComponent,
    HistoriqueComponent,
    ParticipationDemandeComponent
  ],
  imports: [
    CommonModule,
    MotoristRoutingModule,
    FormsModule,
    MatIconModule,
    MatDialogModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatDialogModule,
    FormsModule,

  ]
})
export class MotoristModule { }
