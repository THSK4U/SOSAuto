import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MechanicComponent} from './mechanic.component'
import {MapComponent} from "./map/map.component";
import {ProfileComponent} from "./profile/profile.component";
import {HomeComponent} from "./home/home.component";
import {ParticipationComponent} from "./participation/participation.component";
import {ListParticipationComponent} from "./participation/list-participation/list-participation.component";

const routes: Routes = [
  {
    path: '',
    component: MechanicComponent,
    children: [
      { path: '', component: HomeComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'participation/:demandeid', component: ParticipationComponent },
      { path: 'participation', component: ListParticipationComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MechanicRoutingModule { }
