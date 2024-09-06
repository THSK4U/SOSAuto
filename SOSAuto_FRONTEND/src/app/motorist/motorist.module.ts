import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MotoristRoutingModule } from './motorist-routing.module';
import { MotoristComponent } from './motorist.component';
import { MapMotoristComponent } from './map-motorist/map-motorist.component';
import {MechanicModule} from "../mechanic/mechanic.module";
import { ListSuggestionsComponent } from './list-suggestions/list-suggestions.component';


@NgModule({
  declarations: [
    MotoristComponent,
    MapMotoristComponent,
    ListSuggestionsComponent
  ],
    imports: [
        CommonModule,
        MotoristRoutingModule,
        MechanicModule
    ]
})
export class MotoristModule { }
