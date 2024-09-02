import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MechanicComponent} from './mechanic.component'
import {MapComponent} from "./map/map.component";

const routes: Routes = [
  {
    path: '', component: MechanicComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MechanicRoutingModule { }
