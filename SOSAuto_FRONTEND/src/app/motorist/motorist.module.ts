import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MotoristRoutingModule } from './motorist-routing.module';
import { MotoristComponent } from './motorist.component';
import { MapMotoristComponent } from './map-motorist/map-motorist.component';
import { ListSuggestionsComponent } from './list-suggestions/list-suggestions.component';
import {NavbarComponent} from "./navbar/navbar.component";
import { CreatdemandeComponent } from './creatdemande/creatdemande.component';


@NgModule({
  declarations: [
    MotoristComponent,
    MapMotoristComponent,
    ListSuggestionsComponent,
    NavbarComponent,
    CreatdemandeComponent
  ],
    imports: [
        CommonModule,
        MotoristRoutingModule,
    ]
})
export class MotoristModule { }
